package com.store.dto;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.apache.ibatis.type.Alias;

import com.store.entity.Keep;
import com.store.entity.KeepItemEntity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Alias("Keep")
public class KeepDTO {
	
	private int fridgeIdx;
	private int customerIdx;
	private List<KeepItemDTO> keepItems;
	
	public static KeepDTO of (Keep keepEntity, List<KeepItemEntity> itemEntities) {
		KeepDTO keep = new KeepDTO();
		keep.setFridgeIdx(keepEntity.getFridgeIdx());
		keep.setCustomerIdx(keepEntity.getCustomer().getCustomerIdx());
		keep.setKeepItems(new ArrayList<>());
		for (KeepItemEntity itemEntity : itemEntities) {
			keep.getKeepItems().add(KeepItemDTO.of(itemEntity));
		}
		return keep;
		}
	}
	

