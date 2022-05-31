package com.order.restaurant.entities;

import lombok.Data;

import java.io.Serializable;
@Data
public class OrderInfo implements Serializable {
    private long orderId;
    private int foodId;
    private int foodNum;
    private String taste;
}
