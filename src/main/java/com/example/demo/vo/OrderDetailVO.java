package com.example.demo.vo;

import com.example.demo.entity.Product;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class OrderDetailVO {

    @Schema(name = "product_id",
            description = "訂購物品 id",
            type = "java.lang.Integer",
            example = "1")
    @JsonProperty(value = "product_id")
    private int productId;
    @Schema(name = "count",
            description = "數量",
            type = "java.lang.Integer",
            example = "3")
    @JsonProperty(value = "count")
    private int count;

    @JsonIgnore
    private Product product;
}
