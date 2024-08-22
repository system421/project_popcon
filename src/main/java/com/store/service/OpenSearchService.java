package com.store.service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import com.store.dto.CartDTO;
import com.store.dto.CartItemDTO;
import com.store.dto.OpenSearchDTO;
import com.store.entity.CartEntity;
import com.store.entity.CartItemEntity;
import com.store.entity.OpenSearchEntity;

public interface OpenSearchService {
	   OpenSearchDTO createOpenSearch(OpenSearchDTO openSearchDto) throws IOException;

	    Optional<OpenSearchDTO> getOpenSearchById(Long id);

	    List<OpenSearchDTO> searchOpenSearch(String keyword) throws IOException;

	    void deleteOpenSearch(Long id) throws IOException;
    }