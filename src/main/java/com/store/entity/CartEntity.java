
package com.store.entity;


import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;

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

	    @OneToOne
	    @JoinColumn(name = "customer_idx")
	    @JsonBackReference
	    private Customer customer;

	    @Column(name = "created_date")
	    private LocalDateTime createdDate;
	    private LocalDateTime updatedDate;
}
