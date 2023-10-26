package com.example.demo.config.exception;

import com.example.demo.enums.WebError;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class DataAlreadyExistException extends BaseException{

    public DataAlreadyExistException() {

        this.setCode(WebError.DATA_ALREADY_EXIST.getCode());
        this.setMessage(WebError.DATA_ALREADY_EXIST.getMessage());

    }
}
