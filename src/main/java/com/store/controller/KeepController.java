package com.store.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.store.dto.KeepDTO;
import com.store.dto.KeepItemDTO;
import com.store.entity.KeepItemEntity;
import com.store.service.KeepService;

@RestController
@RequestMapping("/keep")
public class KeepController {

    private final KeepService keepService;

   
    public KeepController(KeepService keepService) {
        this.keepService = keepService;
    }

    // 고객의 냉장고(Keep) 생성
    @PostMapping("/create")
    public ResponseEntity<KeepDTO> createKeep(@RequestBody KeepDTO keepDTO) {
        KeepDTO createdKeep = keepService.createKeep(keepDTO);
        return ResponseEntity.ok(createdKeep);
    }

    // 냉장고에 있는 항목의 수량 업데이트
    @PutMapping("/update-item/{keepItemIdx}")
    public ResponseEntity<KeepItemDTO> updateKeepItemQuantity(@PathVariable int keepItemIdx, @RequestParam int qty) {
        KeepItemDTO updatedKeepItem = keepService.updateKeepItemQuantity(keepItemIdx, qty);
        return ResponseEntity.ok(updatedKeepItem);
    }

    // 특정 고객의 냉장고 내용 조회
    @GetMapping("/{customerIdx}")
    public ResponseEntity<List<KeepDTO>> getKeepByCustomerIdx(@PathVariable int customerIdx) {
        List<KeepDTO> keeps = keepService.getKeepByCustomerIdx(customerIdx);
        return ResponseEntity.ok(keeps);
    }
    
    // 냉장고에서 항목 삭제
    @DeleteMapping("/delete-item/{keepItemIdx}")
    public ResponseEntity<Void> deleteKeepItem(@PathVariable int keepItemIdx) {
        keepService.deleteFromFridge(keepItemIdx);
        return ResponseEntity.noContent().build();
    }

    // 냉장고에 항목 추가
    @PostMapping("/moveitem")
    public ResponseEntity<String> moveItemsToCart(@RequestParam int keepItemIdx, @RequestParam int cartIdx) {
        try {
            keepService.moveItemsToCart(keepItemIdx, cartIdx);
            return ResponseEntity.ok("Product moved to cart successfully");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error moving product to cart: " + e.getMessage());
        }
    }
}
