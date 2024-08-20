package com.store.controller;

import com.store.dto.CartDTO;
import com.store.dto.CartItemDTO;
import com.store.entity.CartItemEntity;
import com.store.service.CartService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

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
    @PostMapping("/sku/addToCart")
    public ResponseEntity<CartItemDTO> addToCart(@RequestBody CartItemDTO cartItemDTO) {
    	CartItemEntity cartItemEntity = cartService.addToCart(cartItemDTO);
    	return ResponseEntity.ok(CartItemDTO.of(cartItemEntity));
    }
    @PutMapping("/cartitem/{cartItemIdx}/quantity")
    public ResponseEntity<CartItemDTO> updateCartItemQuantity(@PathVariable int cartItemIdx, @RequestBody Map<String, Integer> updateRequest) {
        int newQuantity = updateRequest.get("skuValue");
        CartItemDTO updatedCartItem = cartService.updateCartItemQuantity(cartItemIdx, newQuantity);
        return ResponseEntity.ok(updatedCartItem);
    }
    @DeleteMapping("/cartitem/{cartItemIdx}")
    public ResponseEntity<Void> deleteCartItem(@PathVariable int cartItemIdx) {
        cartService.deleteCartItem(cartItemIdx);
        return ResponseEntity.noContent().build();
    }
    @GetMapping("/customer/{customerIdx}")
    public ResponseEntity<List<CartDTO>> getCartsByCustomerIdx(@PathVariable int customerIdx) {
        return ResponseEntity.ok(cartService.getCartsByCustomerIdx(customerIdx));
    }

    @GetMapping("/cart/items")
    public ResponseEntity<List<CartItemDTO>> findAll() {
        return ResponseEntity.ok(cartService.findAll());
    }
    @PostMapping("/cart/moveToKeep")
    public ResponseEntity<String> moveToKeep(@RequestParam int cartItemIdx, @RequestParam int fridgeIdx) {
        try {
            cartService.moveToKeep(cartItemIdx, fridgeIdx);
            return ResponseEntity.ok("Product moved to keep successfully");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error moving product to keep: " + e.getMessage());
        }
    }

    @DeleteMapping("/cart/clear/{customerIdx}")
    public ResponseEntity<Void> clearCartByCustomerIdx(@PathVariable int customerIdx) {
        cartService.clearCartByCustomerIdx(customerIdx);
        return ResponseEntity.noContent().build();
    }
   

    @DeleteMapping("/clear/{customerIdx}")
    public ResponseEntity<Void> clearCart(@PathVariable int customerIdx) {
        cartService.deleteCartItemsByCustomerIdx(customerIdx, List.of());
        return ResponseEntity.ok().build();
    }
}
