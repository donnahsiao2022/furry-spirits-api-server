package com.example.demo.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class DownloadRequestVO {

    @Schema(type = "java.lang.String",
            description = "檔案名稱",
            example = "hello.jpg")
    @JsonProperty("filename")
    private String filename;

}
