package com.store.security;

import javax.persistence.Entity;

import com.store.entity.Customer;
import com.store.entity.Sku;
import com.store.entity.Wish;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

// token 저장 기능
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@ToString
public class JwtTokenResponse {
	String token;
	int customerIdx;

}
