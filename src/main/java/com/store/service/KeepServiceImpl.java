package com.store.service;

import com.store.dto.KeepDTO;
import com.store.dto.KeepItemDTO;
import com.store.entity.Keep;
import com.store.entity.KeepItemEntity;
import com.store.entity.Customer;
import com.store.mapper.KeepMapper;
import com.store.repository.CustomerRepository;
import com.store.repository.KeepItemRepository;
import com.store.repository.KeepRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class KeepServiceImpl implements KeepService {

    private final KeepRepository keepRepository;
    private final KeepItemRepository keepItemRepository;
    private final KeepMapper keepMapper;
    private final CustomerRepository customerRepository;

    @Autowired
    public KeepServiceImpl(KeepRepository keepRepository, KeepItemRepository keepItemRepository, KeepMapper keepMapper, CustomerRepository customerRepository) {
        this.keepRepository = keepRepository;
        this.keepItemRepository = keepItemRepository;
        this.keepMapper = keepMapper;
        this.customerRepository = customerRepository;
    }


    @Override
    @Transactional
    public KeepDTO createKeep(KeepDTO keepDTO) {
        Customer customer = customerRepository.findById(keepDTO.getCustomerIdx())
                .orElseThrow(() -> new RuntimeException("Customer not found"));

        Keep keepEntity = new Keep();
        keepEntity.setCustomer(customer);
        keepEntity.setCreatedDate(LocalDateTime.now());
        keepEntity.setKeepDate(LocalDateTime.now());
        keepEntity = keepRepository.save(keepEntity);

        List<KeepItemEntity> keepItems = new ArrayList<>();
        for (KeepItemDTO keepItemDTO : keepDTO.getKeepItems()) {
            KeepItemEntity keepItemEntity = new KeepItemEntity();
            keepItemEntity.setKeep(keepEntity);
            keepItemEntity.setSkuIdx(keepItemDTO.getSkuIdx());
            keepItemEntity.setQty(keepItemDTO.getQty());
            keepItems.add(keepItemEntity);
        }

        keepItemRepository.saveAll(keepItems);

        return KeepDTO.of(keepEntity, keepItems);
    }

    @Override
    @Transactional
    public KeepItemDTO updateKeepItemQuantity(int keepItemIdx, int qty) {
        KeepItemEntity keepItemEntity = keepItemRepository.findById(keepItemIdx)
                .orElseThrow(() -> new RuntimeException("KeepItem not found"));

        keepItemEntity.setQty(qty);
        keepItemEntity = keepItemRepository.save(keepItemEntity);

        return KeepItemDTO.of(keepItemEntity);
    }

    @Override
    public List<KeepDTO> getKeepByCustomerIdx(int customerIdx) {
        return keepMapper.findKeepByCustomerIdx(customerIdx);
    }

    @Override
    public void deleteFromFridge(int fridgeIdx) {
        keepItemRepository.deleteByKeepFridgeIdx(fridgeIdx);
    }

    @Override
    @Transactional
    public KeepItemEntity addToKeep(KeepItemDTO keepItemDTO) {
        Keep keepEntity = keepRepository.findById(keepItemDTO.getFridgeIdx())
                .orElseThrow(() -> new RuntimeException("Keep not found"));

        Optional<KeepItemEntity> existingKeepItem = keepItemRepository.findByKeepFridgeIdxAndSkuIdx(keepEntity.getFridgeIdx(), keepItemDTO.getSkuIdx());

        if (existingKeepItem.isPresent()) {
            KeepItemEntity keepItemEntity = existingKeepItem.get();
            keepItemEntity.setQty(keepItemEntity.getQty() + 1);
            return keepItemRepository.save(keepItemEntity);
        } else {
            KeepItemEntity keepItemEntity = new KeepItemEntity();
            keepItemEntity.setKeep(keepEntity);
            keepItemEntity.setSkuIdx(keepItemDTO.getSkuIdx());
            keepItemEntity.setQty(1);
            return keepItemRepository.save(keepItemEntity);
        }
    }

    @Override
    public List<KeepItemDTO> findAll(){
    	return keepMapper.findAll();
    }
}
