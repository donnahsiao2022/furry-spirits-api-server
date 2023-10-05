package com.example.demo.controller;

import com.example.demo.entity.Account;
import com.example.demo.enums.WebError;
import com.example.demo.service.JwtService;
import com.example.demo.service.AccountService;
import com.example.demo.vo.UserAuthenticateVO;
import com.example.demo.vo.UserRegisterVO;
import com.example.demo.vo.web.FailureResponse;
import com.example.demo.vo.web.SuccessfullyResponse;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@Tag(name = "驗證 & 授權")
@RestController
@RequestMapping("/account/v1/")
@Slf4j
public class AccountController {

    @Autowired
    AccountService accountService;

    @Autowired
    JwtService jwtService;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    private HttpServletRequest servletRequest;

    @Operation(summary = "註冊 使用者帳號", description = "")
    @PostMapping("/register")
    public ResponseEntity<?> register(
            @RequestBody UserRegisterVO userRegisterVO) {

        Account account = accountService.register(userRegisterVO.getName(),
                passwordEncoder.encode(userRegisterVO.getPassword()));
        if (account == null) {
            return ResponseEntity.ok(
                    new FailureResponse(WebError.REGISTER_FAIL));
        }

        return ResponseEntity.ok(
                new SuccessfullyResponse<>(""));
    }

    @Operation(summary = "驗證", description = "")
    @PostMapping("/authenticate")
    public ResponseEntity<?> authenticate(
            @RequestBody UserAuthenticateVO userAuthenticateVO) {

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        userAuthenticateVO.getName(),
                        userAuthenticateVO.getPassword()
                )
        );

        String jwtToken = jwtService.generateToken(userAuthenticateVO.getName());

        ObjectNode response = new ObjectNode(JsonNodeFactory.instance);
        response.put("token", jwtToken);

        return ResponseEntity.ok(
                new SuccessfullyResponse<>(response));
    }
    
    
}
