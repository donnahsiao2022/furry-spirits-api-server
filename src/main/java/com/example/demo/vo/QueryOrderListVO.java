package com.example.demo.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class QueryOrderListVO {

    @Schema(type = "java.lang.String",
            description = "訂單編號",
            example = "")
    @JsonProperty(value = "order_number")
    private String orderNumber;

    @Schema(type = "java.lang.String",
            description = "訂單狀態",
            example = "")
    @JsonProperty(value = "order_status")
    private String orderStatus;

    @Schema(type = "java.lang.Integer",
            description = "頁數",
            example = "1")
    private int page;

    @Schema(type = "java.lang.Integer",
            description = "頁數大小",
            example = "10")
    private int size;

    @Schema(type = "java.lang.String",
            description = "開始時間",
            example = "2023/03/17 12:00:00")
    @JsonProperty(value = "start_datetime")
    private String startDatetime;

    @Schema(type = "java.lang.String",
            description = "結束時間",
            example = "2023/04/17 12:00:00")
    @JsonProperty(value = "end_datetime")
    private String endDatetime;
}
