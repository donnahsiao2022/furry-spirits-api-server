package com.example.demo.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class UserAuthenticateVO {

    @Schema(type = "java.lang.String",
            description = "帳號",
            example = "ball")
    @JsonProperty(value = "system_id")
    private String name;

    @Schema(type = "java.lang.String",
            description = "密碼",
            example = "123")
    @JsonProperty(value = "password")
    private String password;
}
