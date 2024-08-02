package com.store.dto;

import org.apache.ibatis.type.Alias;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@ToString
@Alias("FaqDTO")
public class FaqDTO {

	int faqIdx;
	int faqtypeIdx;
	String faqQ;
	String faqA;
	
}
