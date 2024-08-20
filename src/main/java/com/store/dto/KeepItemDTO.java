package com.store.dto;

import java.sql.Date;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.apache.ibatis.type.Alias;

import com.store.entity.KeepItemEntity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class KeepItemDTO {
	
	private int keepItemIdx;
	private int fridgeIdx;
	private int skuIdx;
	private int qty;
	
	public static KeepItemDTO of(KeepItemEntity itemEntity) {
		if(itemEntity == null) {
			return null;
		}
		KeepItemDTO item = new KeepItemDTO();
		item.setKeepItemIdx(itemEntity.getKeepItemIdx());
		item.setFridgeIdx(itemEntity.getKeep().getFridgeIdx());
		item.setSkuIdx(itemEntity.getSkuIdx());
		item.setQty(itemEntity.getQty());
		return item;
	}
}
