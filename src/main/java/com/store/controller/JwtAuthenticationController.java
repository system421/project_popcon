package com.store.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.store.dto.CustomerDTO;
import com.store.entity.Customer;
import com.store.security.JwtTokenResponse;
import com.store.security.JwtTokenService;
import com.store.service.AuthenticationService;

@RestController
public class JwtAuthenticationController {

    private Logger logger = LoggerFactory.getLogger(getClass());
    
    private final JwtTokenService tokenService;

    public JwtAuthenticationController(JwtTokenService tokenService) {
        this.tokenService = tokenService;
    }

    @Autowired
    AuthenticationService authenticationService;

    // 로그인 처리 + token 얻기
    @PostMapping("/authenticate")
    public ResponseEntity<JwtTokenResponse> generateToken(
            @RequestBody Map<String, String> jwtTokenRequest) {

    	logger.info("logger: jwtTokenRequest: {}", jwtTokenRequest);

    	CustomerDTO customer = authenticationService.findById(jwtTokenRequest.get("userid"));
    	
    	PasswordEncoder passwordEncoder = passwordEncoder(); 
    	UsernamePasswordAuthenticationToken authenticationToken=null; 

        if (customer != null && passwordEncoder.matches(jwtTokenRequest.get("password"), customer.getCustomerPw())) { // 일치하는 사용자와 비번이 일치하면
            List<GrantedAuthority> roles = new ArrayList<>();
            roles.add(new SimpleGrantedAuthority("USER")); // 권한 부여, 현재는 모든 사용자권한을 USER로 지정한다.
         
            authenticationToken = new UsernamePasswordAuthenticationToken(
                new Customer(
                    customer.getCustomerIdx(),
                    customer.getCustomerId(), 
                    jwtTokenRequest.get("password"), 
                    customer.getCustomerName(),
                    customer.getCustomerPhone(),
                    customer.getCustomerDate(),
                    customer.getCustomerGender(),
                    customer.getCustomerTime(),
                    customer.getCustomerAdd(),
                    customer.getCustomerAddMore(),
                    customer.getCustomerEmail(),
                    customer.getCustomerRate(),
                    customer.getCustomerRole()
                ), 
                null, 
                roles
            ); 
        }
        
        String token = tokenService.generateToken(authenticationToken);
        return ResponseEntity.ok(new JwtTokenResponse(token));
    }

    // 암호화 객체 생성
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @GetMapping("/authenticate-hello")
    public String authenticateHello() {
        return "authenticateHello";
    }
}
