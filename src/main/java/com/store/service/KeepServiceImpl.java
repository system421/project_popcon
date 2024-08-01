package com.store.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.store.dto.CartDTO;
import com.store.dto.KeepDTO;
import com.store.entity.Cart;
import com.store.entity.Customer;
import com.store.entity.Keep;
import com.store.entity.Sku;
import com.store.mapper.KeepMapper;
import com.store.repository.CustomerRepository;
import com.store.repository.KeepRepository;
import com.store.repository.SkuRepository;
@Service
public class KeepServiceImpl implements KeepService{

	@Autowired
    private KeepMapper keepMapper;

    @Autowired
    private KeepRepository keepRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private SkuRepository skuRepository;

    @Override
    public Keep addToFridge(KeepDTO keepDto) {
        Keep keep = convertToEntity(keepDto);
        return keepRepository.save(keep);
    }

    @Override
    public List<KeepDTO> findAll() {
        return keepMapper.findAll();
    }

    @Override
    public void deleteFromFridge(int fridgeIdx) {
        keepRepository.deleteById(fridgeIdx);
    }

     public Keep updateFridge(KeepDTO keepDto) {
        Keep existingKeep = keepRepository.findById(keepDto.getFridgeIdx())
                .orElseThrow(() -> new IllegalArgumentException("Invalid Fridge ID:" + keepDto.getFridgeIdx()));
  
        Customer customer = customerRepository.findById(keepDto.getCustomerIdx())
                .orElseThrow(() -> new IllegalArgumentException("Invalid customer ID:" + keepDto.getCustomerIdx()));
        Sku sku = skuRepository.findById(keepDto.getSkuIdx())
                .orElseThrow(() -> new IllegalArgumentException("Invalid SKU ID: " + keepDto.getSkuIdx()));

        existingKeep.setCustomer(customer);
        existingKeep.setSku(sku);

        return keepRepository.save(existingKeep);
    }

    private Keep convertToEntity(KeepDTO keepDto) {
        Keep keep = new Keep();

        Customer customer = customerRepository.findById(keepDto.getCustomerIdx())
                .orElseThrow(() -> new IllegalArgumentException("Invalid customer ID: " + keepDto.getCustomerIdx()));
        Sku sku = skuRepository.findById(keepDto.getSkuIdx())
                .orElseThrow(() -> new IllegalArgumentException("Invalid SKU ID: " + keepDto.getSkuIdx()));

        keep.setCustomer(customer);
        keep.setSku(sku);

        return keep;
    }
}

	

	

