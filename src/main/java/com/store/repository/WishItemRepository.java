package com.store.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.store.entity.Customer;
import com.store.entity.Wish;
import com.store.entity.WishItemEntity;

@Repository
public interface WishItemRepository extends JpaRepository<WishItemEntity, Integer> {
	List<WishItemEntity> findByWishWishIdx(int wishIdx);
	void deleteByWishWishIdx(int wishItemIdx);
	Optional<WishItemEntity> findByWishWishIdxAndSkuIdx(int wishIdx, int skuIdx);
}
