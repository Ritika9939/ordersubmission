package com.order.service.impl;

import com.order.entity.Order;
import com.order.repository.ItemRepository;
import com.order.repository.OrderRepository;
import com.order.service.OrderService;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
@Service
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final ItemRepository itemRepository;

    public OrderServiceImpl(OrderRepository orderRepository, ItemRepository itemRepository) {
        this.orderRepository = orderRepository;
        this.itemRepository = itemRepository;
    }

    public List<Order> getOrdersByCustomDateRange(String userId, LocalDate startDate, LocalDate endDate) {
        return orderRepository.findByUserIdAndOrderDateBetween(userId, startDate.atStartOfDay(), endDate.atTime(LocalTime.MAX));
    }
}