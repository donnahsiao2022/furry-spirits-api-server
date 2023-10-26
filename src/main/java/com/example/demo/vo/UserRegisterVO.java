package com.example.demo.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class UserRegisterVO {

    @Schema(type = "java.lang.String",
            description = "帳號",
            example = "ball")
    private String name;

    @Schema(type = "java.lang.String",
            description = "密碼",
            example = "123")
    private String password;

    @Schema(type = "java.lang.Boolean",
            description = "是否為 admin",
            example = "true")
    private boolean isAdmin;
}
