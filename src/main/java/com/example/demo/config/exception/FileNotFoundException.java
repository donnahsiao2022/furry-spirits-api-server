package com.example.demo.config.exception;

import com.example.demo.enums.WebError;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class FileNotFoundException extends BaseException {

    public FileNotFoundException() {

        this.setCode(WebError.DATA_FILE_NOT_FOUND_EXCEPTION.getCode());
        this.setMessage(WebError.DATA_FILE_NOT_FOUND_EXCEPTION.getMessage());

    }
}
