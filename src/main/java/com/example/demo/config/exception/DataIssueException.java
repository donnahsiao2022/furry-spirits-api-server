package com.example.demo.config.exception;

import com.example.demo.enums.WebError;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class DataIssueException extends BaseException {

    public DataIssueException() {

        this.setCode(WebError.DATA_ISSUE_EXCEPTION.getCode());
        this.setMessage(WebError.DATA_ISSUE_EXCEPTION.getMessage());

    }
}
