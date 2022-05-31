package com.order.restaurant.entities;

import lombok.Data;

import java.io.Serializable;

@Data
public class Table implements Serializable {
    private int tableId;
    private int restaurantId;
    private int capacity;
    private String status;
}
