
package com.store.entity;


import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@ToString
@Entity
@Table(name = "cart")
public class CartEntity {
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private int cartIdx;

	    @Column(name = "customer_idx")
	    private int customerIdx;

	    private LocalDateTime createdDate;
	    private LocalDateTime updatedDate;
}
