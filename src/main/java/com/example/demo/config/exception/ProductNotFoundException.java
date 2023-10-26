package com.example.demo.config.exception;

import com.example.demo.enums.WebError;

public class ProductNotFoundException extends BaseException {

    public ProductNotFoundException() {

        this.setCode(WebError.PRODUCT_NOT_FOUND.getCode());
        this.setMessage(WebError.PRODUCT_NOT_FOUND.getMessage());

    }
}
