package com.example.demo.config;

import com.example.demo.config.exception.*;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import io.jsonwebtoken.ExpiredJwtException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Slf4j
public class ExceptionHandlerConfiguration {

    @ExceptionHandler(DataNotFoundException.class)
    public Object dataNotFoundHandler(DataNotFoundException dataNotFoundException) {

        return ResponseEntity.status(HttpStatus.OK).body(getResponseBody(dataNotFoundException));
    }

    @ExceptionHandler(DataAlreadyExistException.class)
    public Object dataAlreadyExistException(DataAlreadyExistException dataAlreadyExistException) {

        return ResponseEntity.status(HttpStatus.OK).body(getResponseBody(dataAlreadyExistException));
    }

    @ExceptionHandler(DateFormatException.class)
    public Object dateFormatException(DateFormatException dateFormatException) {

        return ResponseEntity.status(HttpStatus.OK).body(getResponseBody(dateFormatException));
    }

    @ExceptionHandler(FileUploadFailException.class)
    public Object fileUploadFailException(FileUploadFailException fileUploadFailException) {

        return ResponseEntity.status(HttpStatus.OK).body(getResponseBody(fileUploadFailException));
    }

    @ExceptionHandler(FileDownloadFailException.class)
    public Object fileDownloadFailException(FileDownloadFailException fileDownloadFailException) {

        return ResponseEntity.status(HttpStatus.OK).body(getResponseBody(fileDownloadFailException));
    }

    @ExceptionHandler(NullPointerException.class)
    public Object nullPointerExceptionHandler(NullPointerException nullPointerException) {

        log.error("NullPointerExceptionHandler => ", nullPointerException.fillInStackTrace());

        ObjectNode response = new ObjectNode(JsonNodeFactory.instance);

        response.put("statusCode", 9999);
        response.put("message", "系統執行錯誤");

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @ExceptionHandler(ExpiredJwtException.class)
    public Object expiredJwtExceptionHandler(ExpiredJwtException expiredJwtException) {

        return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
    }


    @ExceptionHandler(FileNotFoundException.class)
    public Object fileNotFoundException(FileNotFoundException fileNotFoundException) {

        return ResponseEntity.status(HttpStatus.OK).body(getResponseBody(fileNotFoundException));
    }

    @ExceptionHandler(ProductNotFoundException.class)
    public Object productNotFoundException(ProductNotFoundException productNotFoundException) {

        return ResponseEntity.status(HttpStatus.OK).body(getResponseBody(productNotFoundException));
    }

    private JsonNode getResponseBody(BaseException ex) {

        ObjectNode response = new ObjectNode(JsonNodeFactory.instance);

        response.put("statusCode", ex.getCode());
        response.put("message", ex.getMessage());

        return response;

    }

}
