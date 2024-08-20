
package com.store.repository;

import com.store.entity.CartItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CartItemRepository extends JpaRepository<CartItemEntity, Integer> {
	List<CartItemEntity> findByCartCartIdx(int cartIdx);
	void deleteByCartCartIdx(int cartItemIdx);
	// Cart의 Customer 필드를 통한 customerIdx로 삭제
    void deleteByCartCustomerCustomerIdx(int customerIdx);
    void deleteByCartCustomerCustomerIdxAndSkuIdxAndSkuValue(int customerIdx, int skuIdx, int skuValue);
  
	Optional<CartItemEntity> findByCartCartIdxAndSkuIdx(int cartIdx, int skuIdx);
	List<CartItemEntity> findByCartCustomerCustomerIdx(int customerIdx);

}
