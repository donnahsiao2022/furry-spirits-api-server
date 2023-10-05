package com.example.demo.controller;

import com.example.demo.service.AccountService;
import com.example.demo.service.SideBarService;
import com.example.demo.vo.web.SuccessfullyResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "側邊欄")
@RestController
@RequestMapping("")
@Slf4j
public class SideBarController {

    @Autowired
    AccountService accountService;

    @Autowired
    SideBarService sideBarService;

    @SecurityRequirement(name = "JWT_Authentication")
    @Operation(summary = "後台 sidebar", description = "")
    @GetMapping("/backStage/v1/sidebar/list")
    public ResponseEntity<?> getBackStageSidebar() {

        if (!accountService.isAccountAdmin()) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }

        return ResponseEntity.ok(
                new SuccessfullyResponse<>(sideBarService.findBackStageSideBar()));
    }

    @Operation(summary = "首頁 sidebar", description = "")
    @GetMapping("/frontStage/v1/sidebar/list")
    public ResponseEntity<?> getFrontStageSidebar() {

        return ResponseEntity.ok(
                new SuccessfullyResponse<>(""));
    }
}
