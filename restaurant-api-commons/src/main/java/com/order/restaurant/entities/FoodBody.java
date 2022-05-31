package com.order.restaurant.entities;

import lombok.Data;

import java.io.Serializable;
@Data
public class FoodBody  implements Serializable {
    private int foodId;
    private String foodName;
    private int  foodNum;
    private String taste;
    private float price;
}
