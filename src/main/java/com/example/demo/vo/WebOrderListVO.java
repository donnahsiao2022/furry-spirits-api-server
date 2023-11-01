package com.example.demo.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class WebOrderListVO {

    @JsonProperty(value = "id")
    private int id;

    @JsonProperty(value = "order_number")
    private String orderNumber;

    @JsonProperty(value = "buyer_id")
    private int buyerId;

    @JsonProperty(value = "buyer_name")
    private String buyerName;

    @JsonProperty(value = "status")
    private int status;

    @JsonProperty(value = "status_description")
    private String statusDescription;

    @JsonProperty(value = "total_amount")
    private int totalAmount;

    @JsonProperty(value = "create_datetime")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss" , timezone = "GMT+8")
    private LocalDateTime createDatetime;

    @JsonProperty(value = "pay_datetime")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss" , timezone = "GMT+8")
    private LocalDateTime payDatetime;

}
