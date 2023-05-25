package com.order.service;

import com.order.details.OrderRequest;
import com.order.details.OrderResponse;
import com.order.entity.Order;

import java.time.LocalDate;
import java.util.List;

public interface OrderService {
    List<Order> getOrdersByCustomDateRange(String userId, LocalDate startDate, LocalDate endDate);
}
