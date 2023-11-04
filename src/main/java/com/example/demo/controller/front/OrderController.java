package com.example.demo.controller.front;

import com.example.demo.config.exception.ProductNotFoundException;
import com.example.demo.entity.Account;
import com.example.demo.entity.Order;
import com.example.demo.entity.Product;
import com.example.demo.service.AccountService;
import com.example.demo.service.JwtService;
import com.example.demo.service.OrderService;
import com.example.demo.service.ProductService;
import com.example.demo.vo.CreateOrderVO;
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

import javax.servlet.http.HttpServletRequest;

@Tag(name = "[首頁] 訂單")
@RestController
@RequestMapping("/frontStage/order/v1/")
@SecurityRequirement(name = "JWT_Authentication")
@Slf4j
public class OrderController {

    @Autowired
    ProductService productService;

    @Autowired
    OrderService orderService;

    @Autowired
    AccountService accountService;

    @Autowired
    JwtService jwtService;

    @Autowired
    HttpServletRequest servletRequest;

    @Operation(summary = "建立訂單", description = "")
    @PostMapping("/create")
    public ResponseEntity<?> create(
            @RequestBody CreateOrderVO createOrderVO) {

        createOrderVO.getOrderDetailVOList().forEach(orderDetailVO -> {
            Product product = productService.findById(orderDetailVO.getProductId());
            if (product == null) {
                throw new ProductNotFoundException();
            }
            orderDetailVO.setProduct(product);
        });

        Account account = accountService.findAccountByName(
                jwtService.extractUsernameByRequest(servletRequest));

        Order order = orderService.create(
                account,
                createOrderVO.getOrderDetailVOList());

        return ResponseEntity.ok(
                new SuccessfullyResponse<>(order));
    }

}

