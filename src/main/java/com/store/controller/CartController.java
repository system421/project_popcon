package com.store.controller;

import com.store.dto.CartDTO;
import com.store.dto.CartItemDTO;
import com.store.entity.CartItemEntity;
import com.store.service.CartService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CartController {

    private final CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @PostMapping
    public ResponseEntity<CartDTO> createCart(@RequestBody CartDTO cartDTO) {
        return ResponseEntity.ok(cartService.createCart(cartDTO));
    }

    @PutMapping("/Cart/{cartIdx}")
    public ResponseEntity<CartDTO> updateCart(@PathVariable int cartIdx, @RequestBody CartDTO cartDTO) {
        return ResponseEntity.ok(cartService.updateCart(cartIdx, cartDTO));
    }

    @DeleteMapping("/Cart/{cartIdx}")
    public ResponseEntity<Void> deleteCart(@PathVariable int cartIdx) {
        cartService.deleteCart(cartIdx);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/customer/{customerIdx}")
    public ResponseEntity<List<CartDTO>> getCartsByCustomerIdx(@PathVariable int customerIdx) {
        return ResponseEntity.ok(cartService.getCartsByCustomerIdx(customerIdx));
    }

    @PostMapping("/sku/addToCart")
    public ResponseEntity<CartItemEntity> addToCart(@RequestBody CartItemDTO cartItemDTO) {
        CartItemEntity cartItemEntity = cartService.addToCart(cartItemDTO);
        return ResponseEntity.ok(cartItemEntity);
    }
}
