package com.order.restaurant.entities;

import lombok.Data;

import java.io.Serializable;
@Data
public class FoodInfo implements Serializable {
    private int foodId;
    private int restaurantId;
    private String foodName;
    private String price;
}
