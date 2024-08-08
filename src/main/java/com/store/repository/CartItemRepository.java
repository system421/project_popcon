
package com.store.repository;

import com.store.entity.CartItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CartItemRepository extends JpaRepository<CartItemEntity, Integer> {
	 List<CartItemEntity> findByCartCartIdx(int cartIdx);
	void deleteByCartCartIdx(int cartIdx);
	 Optional<CartItemEntity> findByCartCartIdxAndSkuIdx(int cartIdx, int skuIdx);
}
