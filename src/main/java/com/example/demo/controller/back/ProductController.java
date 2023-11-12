package com.example.demo.controller.back;

import com.example.demo.entity.Product;
import com.example.demo.service.ProductService;
import com.example.demo.vo.CreateProductVO;
import com.example.demo.vo.UpdateProductVO;
import com.example.demo.vo.web.SuccessfullyResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "[後台] 產品管理")
@RestController
@RequestMapping("/backStage/product/v1/")
@SecurityRequirement(name = "JWT_Authentication")
@Slf4j
public class ProductController {

    @Autowired
    ProductService productService;

    @Operation(summary = "新增產品", description = "")
    @PostMapping("/create")
    public ResponseEntity<?> create(
            @RequestBody CreateProductVO createProductVO) {

        Product product = productService.create(createProductVO);

        return ResponseEntity.ok(
                new SuccessfullyResponse<>(product));
    }

    @Operation(summary = "編輯產品", description = "")
    @PostMapping("/update")
    public ResponseEntity<?> update(
            @RequestBody UpdateProductVO updateProductVO) {

        Product product = productService.update(updateProductVO);

        return ResponseEntity.ok(
                new SuccessfullyResponse<>(product));
    }

    @Operation(summary = "產品列表", description = "")
    @PostMapping("/list")
    public ResponseEntity<?> list() {

        return ResponseEntity.ok(
                new SuccessfullyResponse<>(productService.findProductList()));
    }

}
