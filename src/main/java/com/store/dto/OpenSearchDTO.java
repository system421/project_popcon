package com.store.dto;

import com.store.entity.CartEntity;
import com.store.entity.CartItemEntity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.ibatis.type.Alias;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OpenSearchDTO {
    private Long id;
    private String title;
    private String content;
   
}
