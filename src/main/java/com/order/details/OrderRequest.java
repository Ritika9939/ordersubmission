package com.order.details;

import java.time.LocalDate;

public class OrderRequest {
    private String userId;
    private LocalDate fromDate;
    private LocalDate toDate;

    public OrderRequest() {
    }

    public OrderRequest(String userId, LocalDate fromDate, LocalDate toDate) {
        this.userId = userId;
        this.fromDate = fromDate;
        this.toDate = toDate;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public LocalDate getFromDate() {
        return fromDate;
    }

    public void setFromDate(LocalDate fromDate) {
        this.fromDate = fromDate;
    }

    public LocalDate getToDate() {
        return toDate;
    }

    public void setToDate(LocalDate toDate) {
        this.toDate = toDate;
    }
}
