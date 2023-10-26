package com.example.demo.controller.front;

import com.example.demo.service.SideBarService;
import com.example.demo.vo.web.SuccessfullyResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "[首頁] 側邊欄")
@RestController
@RequestMapping("/frontStage/sidebar/v1")
@Slf4j
public class SideBarController {

    @Autowired
    SideBarService sideBarService;

    @Operation(summary = "列表", description = "")
    @GetMapping("/list")
    public ResponseEntity<?> getFrontStageSidebar() {

        return ResponseEntity.ok(
                new SuccessfullyResponse<>(""));
    }
}
