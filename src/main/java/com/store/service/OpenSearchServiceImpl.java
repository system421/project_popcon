package com.store.service;

import com.store.dto.OpenSearchDTO;
import com.store.entity.OpenSearchEntity;
import com.store.repository.OpenSearchRepository;
import com.store.service.OpenSearchService;
import org.opensearch.action.delete.DeleteRequest;
import org.opensearch.action.index.IndexRequest;
import org.opensearch.action.search.SearchRequest;
import org.opensearch.action.search.SearchResponse;
import org.opensearch.client.RequestOptions;
import org.opensearch.client.RestHighLevelClient;
import org.opensearch.index.query.QueryBuilders;
import org.opensearch.search.builder.SearchSourceBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OpenSearchServiceImpl implements OpenSearchService {

    private final OpenSearchRepository openSearchRepository;
    private final RestHighLevelClient openSearchClient;

    @Autowired
    public OpenSearchServiceImpl(OpenSearchRepository openSearchRepository, RestHighLevelClient openSearchClient) {
        this.openSearchRepository = openSearchRepository;
        this.openSearchClient = openSearchClient;
    }

    @Override
    @Transactional
    public OpenSearchDTO createOpenSearch(OpenSearchDTO openSearchDto) throws IOException {
        // DTO -> 엔티티로 변환
        OpenSearchEntity openSearchEntity = OpenSearchEntity.builder()
                .title(openSearchDto.getTitle())
                .content(openSearchDto.getContent())
                .build();

        // JPA를 사용하여 MySQL에 저장
        OpenSearchEntity savedEntity = openSearchRepository.save(openSearchEntity);

        // OpenSearch에 인덱싱
        IndexRequest indexRequest = new IndexRequest("opensearch")
                .id(savedEntity.getId().toString())
                .source("title", savedEntity.getTitle(),
                        "content", savedEntity.getContent());

        openSearchClient.index(indexRequest, RequestOptions.DEFAULT);

        // 엔티티 -> DTO로 변환하여 반환
        return new OpenSearchDTO(savedEntity.getId(), savedEntity.getTitle(), savedEntity.getContent());
    }

    @Override
    public Optional<OpenSearchDTO> getOpenSearchById(Long id) {
        return openSearchRepository.findById(id)
                .map(entity -> new OpenSearchDTO(entity.getId(), entity.getTitle(), entity.getContent()));
    }

    @Override
    public List<OpenSearchDTO> searchOpenSearch(String keyword) throws IOException {
        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
        sourceBuilder.query(QueryBuilders.matchQuery("content", keyword));

        SearchRequest searchRequest = new SearchRequest("opensearch");
        searchRequest.source(sourceBuilder);

        SearchResponse searchResponse = openSearchClient.search(searchRequest, RequestOptions.DEFAULT);

        // SearchHit[] 배열을 스트림으로 변환
        return Arrays.stream(searchResponse.getHits().getHits())
                .map(hit -> {
                    Long id = Long.valueOf(hit.getId());
                    String title = (String) hit.getSourceAsMap().get("title");
                    String content = (String) hit.getSourceAsMap().get("content");
                    return new OpenSearchDTO(id, title, content);
                })
                .collect(Collectors.toList());
    }
    @Override
    @Transactional
    public void deleteOpenSearch(Long id) throws IOException {
        // JPA를 사용하여 MySQL에서 삭제
        openSearchRepository.deleteById(id);

        // OpenSearch에서 인덱스 삭제
        DeleteRequest deleteRequest = new DeleteRequest("opensearch", id.toString());
        openSearchClient.delete(deleteRequest, RequestOptions.DEFAULT);
    }
}
