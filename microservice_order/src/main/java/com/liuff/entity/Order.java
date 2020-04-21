package com.liuff.entity;

import java.time.Instant;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    private String orderId;
    private Long userId;
    private Instant createDate;
    private Instant updateDate;
    private List<OrderDetail> orderDetails;
}