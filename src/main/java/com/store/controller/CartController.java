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
@RequestMapping("/cart")
public class CartController {

    private final CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    // 장바구니 생성
    @PostMapping
    public ResponseEntity<CartDTO> createCart(@RequestBody CartDTO cartDTO) {
        return ResponseEntity.ok(cartService.createCart(cartDTO));
    }

    // SKU를 사용하여 장바구니에 추가
    @PostMapping("/sku/addToCart")
    public ResponseEntity<CartItemDTO> addToCart(@RequestBody CartItemDTO cartItemDTO) {
        CartItemEntity cartItemEntity = cartService.addToCart(cartItemDTO);
        return ResponseEntity.ok(CartItemDTO.of(cartItemEntity));
    }

    // 장바구니 아이템 수량 업데이트
    @PutMapping("/cartitem/{cartItemIdx}/quantity")
    public ResponseEntity<CartItemDTO> updateCartItemQuantity(@PathVariable int cartItemIdx, @RequestBody Map<String, Integer> updateRequest) {
        int newQuantity = updateRequest.get("skuValue");
        CartItemDTO updatedCartItem = cartService.updateCartItemQuantity(cartItemIdx, newQuantity);
        return ResponseEntity.ok(updatedCartItem);
    }

    // 장바구니에서 아이템 삭제
    @DeleteMapping("/cartitem/{cartItemIdx}")
    public ResponseEntity<Void> deleteCartItem(@PathVariable int cartItemIdx) {
        cartService.deleteCartItem(cartItemIdx);
        return ResponseEntity.noContent().build();
    }

    // 고객 ID를 기반으로 장바구니 목록 가져오기
    @GetMapping("/customer/{customerIdx}")
    public ResponseEntity<List<CartDTO>> getCartsByCustomerIdx(@PathVariable int customerIdx) {
        return ResponseEntity.ok(cartService.getCartsByCustomerIdx(customerIdx));
    }

    // 모든 장바구니 아이템 조회
    @GetMapping("/cart/items")
    public ResponseEntity<List<CartItemDTO>> findAll() {
        return ResponseEntity.ok(cartService.findAll());
    }

    // 장바구니에서 Keep으로 이동
    @PostMapping("/cart/moveToKeep")
    public ResponseEntity<String> moveToKeep(@RequestParam int cartItemIdx, @RequestParam int fridgeIdx) {
        try {
            cartService.moveToKeep(cartItemIdx, fridgeIdx);
            return ResponseEntity.ok("Product moved to keep successfully");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error moving product to keep: " + e.getMessage());
        }
    }

    // 고객 ID를 기반으로 장바구니 비우기
    @DeleteMapping("/cart/clear/{customerIdx}")
    public ResponseEntity<Void> clearCartByCustomerIdx(@PathVariable int customerIdx) {
        cartService.clearCartByCustomerIdx(customerIdx);
        return ResponseEntity.noContent().build();
    }

    // 특정 Cart ID를 기반으로 장바구니 아이템 목록 가져오기
    @GetMapping("/items/{cartIdx}")
    public ResponseEntity<List<CartItemDTO>> getCartItems(@PathVariable int cartIdx) { // 변경된 부분: @RequestParam -> @PathVariable
        List<CartItemDTO> cartItems = cartService.getCartItems(cartIdx);
        return ResponseEntity.ok(cartItems);
    }

    // Keep에서 장바구니로 아이템 이동
    @PostMapping("/moveToCart")
    public ResponseEntity<String> moveKeepItemToCart(@RequestParam int keepItemIdx, @RequestParam int cartIdx) {
        cartService.moveKeepItemToCart(keepItemIdx, cartIdx);
        return ResponseEntity.ok("Item moved to cart successfully.");
    }
}
