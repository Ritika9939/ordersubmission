package com.order.details;

import lombok.Data;

import java.util.List;
@Data
public class OrderResponseData {
    private String date;
    private String totalOrderedAmount;
    private String totalOrderedQuantity;
    private List<OrderItem> items;

}
