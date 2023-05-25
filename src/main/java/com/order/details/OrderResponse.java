package com.order.details;

import lombok.Data;

@Data
public class OrderResponse {
    private int status;
    private String msg;
    private OrderResponseData data;

}
