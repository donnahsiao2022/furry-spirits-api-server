package com.example.demo.enums;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

public enum WebError {

    NO_STATUS(-1, "無狀態"),
    REGISTER_FAIL(1000, "註冊失敗"),
    DATA_NOT_FOUND(1001, "資料不存在"),
    DATA_ALREADY_EXIST(1002, "資料已存在"),
    DATE_FORMAT_EXCEPTION(1003, "日期格式錯誤"),
    DATA_ISSUE_EXCEPTION(1004, "檔案異常"),
    DATA_FILE_NOT_FOUND_EXCEPTION(1005, "檔案不存在"),
    PRODUCT_NOT_FOUND(2000, "產品不存在");

    private final Integer code;
    private final String message;

    WebError(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    private static final Map<Integer, WebError> lookup = new HashMap<>();

    static {
        for (WebError suit : EnumSet.allOf(WebError.class)) {
            lookup.put(suit.ordinal(), suit);
        }
    }

    public static WebError fromOrdinal(Integer ordinal) {
        return (ordinal == null) ? NO_STATUS : lookup.get(ordinal);
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

}
