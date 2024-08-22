package com.store.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.apache.ibatis.type.Alias;

import com.store.entity.CartEntity;
import com.store.entity.CartItemEntity;
import com.store.entity.Wish;
import com.store.entity.WishItemEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Alias("wish")
public class WishDTO {
	
	   private int wishIdx;
	    private int customerIdx;
	    private List<WishItemDTO> wishItems;
	    
	    public static WishDTO of(Wish wishEntity, List<WishItemEntity> itemEntities) {
	        WishDTO wish = new WishDTO();
	        wish.setWishIdx(wishEntity.getWishIdx());
	        wish.setCustomerIdx(wishEntity.getCustomer().getCustomerIdx());
	        wish.setWishItems(new ArrayList<>());
	        for (WishItemEntity itemEntity : itemEntities) {
	            wish.getWishItems().add(WishItemDTO.of(itemEntity));
	        }
	        return wish;
	    }
		
	
}
