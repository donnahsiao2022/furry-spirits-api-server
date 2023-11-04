package com.example.demo.config.exception;

import com.example.demo.enums.WebError;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class FileUploadFailException extends BaseException {

    public FileUploadFailException() {

        this.setCode(WebError.FILE_UPLOAD_FAIL.getCode());
        this.setMessage(WebError.FILE_UPLOAD_FAIL.getMessage());

    }
}
