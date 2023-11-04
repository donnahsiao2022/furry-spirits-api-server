package com.example.demo.config.exception;

import com.example.demo.enums.WebError;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class FileDownloadFailException extends BaseException {

    public FileDownloadFailException() {

        this.setCode(WebError.FILE_DOWNLOAD_FAIL.getCode());
        this.setMessage(WebError.FILE_DOWNLOAD_FAIL.getMessage());

    }
}
