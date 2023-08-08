package com.example.demo.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class AccountCreationVO {

    @NotNull
    @Schema(name = "name",
            description = "名稱",
            type = "java.lang.String",
            example = "ball")
    @JsonProperty(value = "name")
    private String name;

}
