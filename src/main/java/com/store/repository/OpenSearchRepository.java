package com.store.repository;

import com.store.entity.OpenSearchEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OpenSearchRepository extends JpaRepository<OpenSearchEntity, Long> {
}
