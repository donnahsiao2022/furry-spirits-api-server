package com.example.demo.enums;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

public enum OrderStatus {

    NO_STATUS(-2, "無狀態"),
    CANCEL(-1, "訂單取消"),
    NEW_ORDER(0, "待付款"),
    PAYING(1, "付款中"),
    PAY_SUCCESS(2, "付款成功"),
    PAY_FAIL(3, "付款失敗"),
    DELIVERING(4, "出貨中"),
    ARRIVED(5, "已到貨");

    private final Integer code;
    private final String description;

    OrderStatus(Integer code, String description) {
        this.code = code;
        this.description = description;
    }

    private static final Map<Integer, OrderStatus> lookup = new HashMap<>();

    static {
        for (OrderStatus suit : EnumSet.allOf(OrderStatus.class)) {
            lookup.put(suit.getCode(), suit);
        }
    }

    public static OrderStatus fromOrdinal(Integer ordinal) {
        return (ordinal == null) ? NO_STATUS : lookup.get(ordinal);
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return description;
    }
}
