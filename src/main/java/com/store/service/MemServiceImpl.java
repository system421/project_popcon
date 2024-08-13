package com.store.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.store.dto.CustomerDTO;
import com.store.entity.CartEntity;
import com.store.entity.Customer;
import com.store.entity.Wish;
import com.store.entity.Keep;
import com.store.mapper.CustomerMapper;
import com.store.repository.CartRepository;
import com.store.repository.CustomerRepository;
import com.store.repository.WishRepository;
import com.store.repository.KeepRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
@Transactional 
public class MemServiceImpl implements MemService {

    private final CustomerRepository customerRepository;
    private final CartRepository cartRepository;
    private final WishRepository wishRepository;
    private final KeepRepository keepRepository;

    @Override
    public CustomerDTO findById(int customerIdx) {
        Customer customer = customerRepository.findByCustomerIdx(customerIdx);
        return new CustomerDTO(customer);
    }

    @Override
    public Customer registerMem(Customer mem) {
        // 필요 시 ID와 이메일 중복 체크 로직 추가
        // 예: if (customerRepository.findByCustomerId(mem.getCustomerId()) != null) { throw new IllegalArgumentException("User ID already exists"); }
        Customer savedCustomer = customerRepository.save(mem);

        // 회원 가입 시 카트 생성
        CartEntity cart = CartEntity.builder()
                .customer(savedCustomer)
                .createdDate(LocalDateTime.now())
                .updatedDate(LocalDateTime.now())
                .build();
        cartRepository.save(cart);
        
        // 회원 가입 시 위시리스트 생성
        Wish wish = Wish.builder()
                .customer(savedCustomer)
                .createdDate(LocalDateTime.now())
                .updatedDate(LocalDateTime.now())
                .build();
        wishRepository.save(wish);

        // 회원 가입 시 냉장고(Keep) 생성
        Keep keep = Keep.builder()
                .customer(savedCustomer)
                .createdDate(LocalDateTime.now())
                .keepDate(LocalDateTime.now())
                .build();
        keepRepository.save(keep);

        return savedCustomer;
    }

    @Override
    public Customer findByUserID(String id) {
        return customerRepository.findByCustomerId(id);
    }

    @Override
    public CustomerDTO registerCustomer(CustomerDTO customerDTO) {
        Customer customer = Customer.builder()
                .customerId(customerDTO.getCustomerId())
                .customerPw(customerDTO.getCustomerPw())
                .customerName(customerDTO.getCustomerName())
                .customerPhone(customerDTO.getCustomerPhone())
                .customerDate(customerDTO.getCustomerDate())
                .customerGender(customerDTO.getCustomerGender())
                .customerAdd(customerDTO.getCustomerAdd())
                .customerAddMore(customerDTO.getCustomerAddMore())
                .customerEmail(customerDTO.getCustomerEmail())
                .customerRate(customerDTO.getCustomerRate())
                .customerRole(customerDTO.getCustomerRole())
                .build();

        Customer savedCustomer = customerRepository.save(customer);

        // 회원 가입 시 카트 생성
        CartEntity cart = CartEntity.builder()
                .customer(savedCustomer)
                .createdDate(LocalDateTime.now())
                .updatedDate(LocalDateTime.now())
                .build();
        cartRepository.save(cart);
        
        // 회원 가입 시 위시리스트 생성
        Wish wish = Wish.builder()
                .customer(savedCustomer)
                .createdDate(LocalDateTime.now())
                .updatedDate(LocalDateTime.now())
                .build();
        wishRepository.save(wish);

        // 회원 가입 시 냉장고(Keep) 생성
        Keep keep = Keep.builder()
                .customer(savedCustomer)
                .createdDate(LocalDateTime.now())
                .keepDate(LocalDateTime.now())
                .build();
        keepRepository.save(keep);

        return CustomerDTO.builder()
                .customerIdx(savedCustomer.getCustomerIdx())
                .customerId(savedCustomer.getCustomerId())
                .customerPw(savedCustomer.getCustomerPw())
                .customerName(savedCustomer.getCustomerName())
                .customerPhone(savedCustomer.getCustomerPhone())
                .customerDate(savedCustomer.getCustomerDate())
                .customerGender(savedCustomer.getCustomerGender())
                .customerAdd(savedCustomer.getCustomerAdd())
                .customerAddMore(savedCustomer.getCustomerAddMore())
                .customerEmail(savedCustomer.getCustomerEmail())
                .customerRate(savedCustomer.getCustomerRate())
                .customerRole(savedCustomer.getCustomerRole())
                .build();
    }
}
