package com.store.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.store.entity.Customer;
import com.store.entity.Keep;
import com.store.entity.KeepItemEntity;

public interface KeepItemRepository extends JpaRepository<KeepItemEntity, Integer>  {
	List<KeepItemEntity> findByKeepFridgeIdx(int fridgeIdx);
    void deleteByKeepFridgeIdx(int fridgeIdx);
    Optional<KeepItemEntity> findByKeepFridgeIdxAndSkuIdx(int fridgeIdx, int skuIdx);
}
