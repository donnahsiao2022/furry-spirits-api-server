package com.example.demo.controller.back;

import com.example.demo.config.exception.DateFormatException;
import com.example.demo.entity.Order;
import com.example.demo.service.AccountService;
import com.example.demo.service.OrderService;
import com.example.demo.vo.QueryOrderListVO;
import com.example.demo.vo.util.VOMapper;
import com.example.demo.vo.web.BaseResponse;
import com.example.demo.vo.web.OrderListResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;

@Tag(name = "[後台] 訂單管理")
@RestController
@RequestMapping("/backStage/order/v1/")
@SecurityRequirement(name = "JWT_Authentication")
@Slf4j
public class BackOrderController {

    @Autowired
    AccountService accountService;

    @Autowired
    OrderService orderService;

    @Autowired
    VOMapper voMapper;

    @Operation(summary = "取得 訂單列表", description = "")
    @PostMapping("/list")
    public ResponseEntity<BaseResponse> getOrderList(
            @RequestBody QueryOrderListVO queryOrderListVO) {

        if (!accountService.isAccountAdmin()) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }

        Page<Order> orderPage;

        try {

            orderPage = orderService.queryList(queryOrderListVO);

        } catch (ParseException e) {
            throw new DateFormatException();
        }

        return ResponseEntity.ok(
                new OrderListResponse(
                        orderPage,
                        voMapper.toWebOrderListVO(orderPage.getContent())));

    }

}

