package com.order.restaurant.entities;

import lombok.Data;

import java.io.Serializable;

@Data
public class RestaurantInfo implements Serializable {
    private int restaurantId;
    private String restaurantName;
    private String status;
}
