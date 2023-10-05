package com.example.demo.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "訂單")
@RestController
@RequestMapping("/order")
@Slf4j
public class OrderController {

}

