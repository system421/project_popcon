package com.store.dto;

import java.util.Date;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.apache.ibatis.type.Alias;

import com.store.entity.CartItemEntity;
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
public class WishItemDTO {
	   private int wishItemIdx;
	   private int wishIdx;
	    private int skuIdx;
	    private String skuName;
	    private Integer skuCost;
		
	    public static WishItemDTO of(WishItemEntity itemEntity) {
	        if (itemEntity == null) {
	            return null;
	        }
	        WishItemDTO item = new WishItemDTO();
	        item.setWishItemIdx(itemEntity.getWishItemIdx());
	        item.setWishIdx(itemEntity.getWish().getWishIdx());  // 추가된 필드 설정
	        item.setSkuIdx(itemEntity.getSkuIdx());
	        return item;
	    }
}
