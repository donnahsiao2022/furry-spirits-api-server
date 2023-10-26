package com.example.demo.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class CreateOrderVO {

    @JsonProperty(value = "order_detail")
    private List<OrderDetailVO> orderDetailVOList;

}
