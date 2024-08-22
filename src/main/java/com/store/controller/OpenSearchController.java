package com.store.controller;

import com.store.dto.OpenSearchDTO;
import com.store.service.OpenSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/opensearch")
public class OpenSearchController {

    private final OpenSearchService openSearchService;

    @Autowired
    public OpenSearchController(OpenSearchService openSearchService) {
        this.openSearchService = openSearchService;
    }

    @PostMapping
    public ResponseEntity<OpenSearchDTO> createOpenSearch(@RequestBody OpenSearchDTO openSearchDto) {
        try {
            OpenSearchDTO savedOpenSearchDto = openSearchService.createOpenSearch(openSearchDto);
            return ResponseEntity.status(201).body(savedOpenSearchDto);
        } catch (IOException e) {
            return ResponseEntity.status(500).build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<OpenSearchDTO> getOpenSearchById(@PathVariable Long id) {
        Optional<OpenSearchDTO> openSearchDto = openSearchService.getOpenSearchById(id);
        return openSearchDto.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(404).build());
    }

    @GetMapping("/search")
    public ResponseEntity<List<OpenSearchDTO>> searchOpenSearch(@RequestParam String keyword) {
        try {
            List<OpenSearchDTO> results = openSearchService.searchOpenSearch(keyword);
            return ResponseEntity.ok(results);
        } catch (IOException e) {
            return ResponseEntity.status(500).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOpenSearch(@PathVariable Long id) {
        try {
            openSearchService.deleteOpenSearch(id);
            return ResponseEntity.status(204).build();
        } catch (IOException e) {
            return ResponseEntity.status(500).build();
        }
    }
}
