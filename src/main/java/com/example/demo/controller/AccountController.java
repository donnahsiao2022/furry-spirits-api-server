package com.example.demo.controller;

import com.example.demo.entity.Account;
import com.example.demo.service.AccountService;
import com.example.demo.vo.AccountCreationVO;
import com.example.demo.vo.util.VOMapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "帳號")
@RestController
@RequestMapping("/account")
@Slf4j
public class AccountController {

    @Autowired
    VOMapper voMapper;

    @Autowired
    AccountService accountService;

    @Operation(summary = "新增帳號", description = "")
    @PostMapping("/create")
    public ResponseEntity<?> create(
            @RequestBody AccountCreationVO accountCreationVO) {

        accountService.save(
                voMapper.toAccount(accountCreationVO));

        return ResponseEntity.ok("success");
    }

    @Operation(summary = "取得帳號 列表", description = "")
    @GetMapping("/list")
    public ResponseEntity<?> list() {
        return ResponseEntity.ok(
                accountService.getAccoutList());
    }

    @Operation(summary = "用 ID 搜尋帳號", description = "")
    @GetMapping("/query")
    public ResponseEntity<?> query(@RequestParam int accountId) {
        return ResponseEntity.ok(
                accountService.findAccountById(accountId));
    }

    @Operation(summary = "用 ID 刪除帳號", description = "")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int accountId) {

        Account account = accountService.findAccountById(accountId);
        if (account == null) {
            return ResponseEntity.ok("查無 ID");
        }

        accountService.deleteAccount(account);

        return ResponseEntity.ok("success");
    }

}
