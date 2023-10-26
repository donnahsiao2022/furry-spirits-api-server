package com.example.demo.config.exception;

import com.example.demo.enums.WebError;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class DataNotFoundException extends BaseException {

    public DataNotFoundException() {

        this.setCode(WebError.DATA_NOT_FOUND.getCode());
        this.setMessage(WebError.DATA_NOT_FOUND.getMessage());

    }
}
