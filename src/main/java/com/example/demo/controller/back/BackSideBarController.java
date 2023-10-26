package com.example.demo.controller.back;

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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "[後台] 側邊欄")
@RestController
@RequestMapping("/backStage/sidebar/v1")
@SecurityRequirement(name = "JWT_Authentication")
@Slf4j
public class BackSideBarController {

    @Autowired
    AccountService accountService;

    @Autowired
    SideBarService sideBarService;

    @Operation(summary = "列表", description = "")
    @GetMapping("/list")
    public ResponseEntity<?> getBackStageSidebar() {

        if (!accountService.isAccountAdmin()) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }

        return ResponseEntity.ok(
                new SuccessfullyResponse<>(sideBarService.findBackStageSideBar()));
    }

}
