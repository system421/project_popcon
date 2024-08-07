
package com.store.entity;


import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@ToString
@Entity
public class CartEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false, name = "cart_idx")
	private int cartIdx;

	@ManyToOne
	@JoinColumn(name = "customer_idx", nullable = false)
	private Customer customer;
}
