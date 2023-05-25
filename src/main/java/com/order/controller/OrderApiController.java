package com.order.controller;

import com.order.details.OrderItemResponse;
import com.order.details.OrderResponse;
import com.order.details.OrderResponseData;
import com.order.entity.Order;
import com.order.entity.OrderDetail;
import com.order.service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderApiController {

    private final OrderService orderService;

    public OrderApiController(OrderService orderService) {
        this.orderService = orderService;
    }

    //http://localhost:8080/api/orders/custom-date-range
    @GetMapping("/custom-date-range")
    public ResponseEntity<OrderResponse> getOrderListByCustomDateRange(@RequestParam("user_id") String userId,
                                                                       @RequestParam("from_date") String fromDate,
                                                                       @RequestParam("to_date") String toDate) {
        LocalDate startDate = LocalDate.parse(fromDate);
        LocalDate endDate = LocalDate.parse(toDate);

        List<Order> orders = orderService.getOrdersByCustomDateRange(userId, startDate, endDate);

        // Create the response object
        OrderResponse response = new OrderResponse();
        response.setStatus(200);
        response.setMsg("Success");
        response.setData(convertOrdersToResponseData(orders));

        return ResponseEntity.ok(response);
    }

    private OrderResponseData convertOrdersToResponseData(List<Order> orders) {
        OrderResponseData responseData = new OrderResponseData();

        BigDecimal totalAmount = BigDecimal.ZERO;
        int totalQuantity = 0;

        List<OrderItemResponse> itemResponses = new ArrayList<>();

        for (Order order : orders) {

            for (OrderDetail detail : order.getOrderDetails()) {
                BigDecimal itemAmount = detail.getAmount();
                int itemQuantity = detail.getQuantity();

                totalAmount = totalAmount.add(itemAmount);
                totalQuantity += itemQuantity;


                OrderItemResponse itemResponse = new OrderItemResponse();
                itemResponse.setItemName(detail.getItem().getItemName());

                itemResponses.add(itemResponse);
            }
        }

        responseData.setDate("");
        responseData.setTotalOrderedAmount(totalAmount.toString());
        responseData.setTotalOrderedQuantity(String.valueOf(totalQuantity));

        return responseData;
    }
}
