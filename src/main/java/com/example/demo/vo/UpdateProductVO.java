package com.example.demo.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class UpdateProductVO {

    @NotNull
    @Schema(name = "id",
            description = "產品 id",
            type = "java.lang.Integer",
            example = "1")
    @JsonProperty(value = "id")
    private int id;

    @NotNull
    @Schema(name = "name",
            description = "產品名稱",
            type = "java.lang.String",
            example = "mac")
    @JsonProperty(value = "name")
    private String name;

    @NotNull
    @Schema(name = "price",
            description = "產品價格",
            type = "java.lang.Integer",
            example = "200")
    @JsonProperty(value = "price")
    private int price;

    @Schema(name = "description",
            description = "產品描述",
            type = "java.lang.String",
            example = "產品描述")
    @JsonProperty(value = "description")
    private String description;

    @Schema(name = "image_filename",
            description = "產品圖片-檔名",
            type = "java.lang.String",
            example = "test.jpg")
    @JsonProperty(value = "image_filename")
    private String imageFilename;

}
