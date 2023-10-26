package com.example.demo.config.exception;

import com.example.demo.enums.WebError;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class DateFormatException extends BaseException {

    public DateFormatException() {

        this.setCode(WebError.DATE_FORMAT_EXCEPTION.getCode());
        this.setMessage(WebError.DATE_FORMAT_EXCEPTION.getMessage());

    }
}
