package com.example.demo.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class UserRegisterVO {

    @Schema(type = "java.lang.string",
            description = "帳號",
            example = "ball")
    private String name;

    @Schema(type = "java.lang.string",
            description = "密碼",
            example = "123")
    private String password;
}
