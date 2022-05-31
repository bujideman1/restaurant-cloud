package com.order.restaurant.controller;

import com.order.restaurant.entities.CommentResult;
import com.order.restaurant.service.WaiterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class WaiteController {
    @Autowired
    private WaiterService waiterService;
    @GetMapping(value = "consumer/waiter/getReadyFoods")
    public CommentResult getReadyFoods(@RequestParam("table_id") Integer tableId){
        return waiterService.getReadyFoods(tableId);
    }
    @PostMapping(value = "consumer/waiter/readyFood/{food_id}")
    public CommentResult readyFood(@PathVariable("food_id")Integer foodId){
        return waiterService.readyFood(foodId);
    }
    @PostMapping(value = "consumer/waiter/complateFood/{food_id}")
    public CommentResult complateFood(@PathVariable("food_id")Integer foodId){
        return  waiterService.complateFood(foodId);

    }
    @PostMapping(value = "consumer/waiter/cancelFood/{food_id}")
    public CommentResult cancelFood(@PathVariable("food_id")Integer foodId){
        return  waiterService.cancelFood(foodId);

    }
    @GetMapping(value = "consumer/waiter/checkout/{table_id}")
    public CommentResult checkout(@PathVariable("table_id")Integer tableId){
        return  waiterService.checkout(tableId);

    }
    @RequestMapping(value = "consumer/waiter/paybill/{table_id}")
    public CommentResult paybill(@PathVariable("table_id")Integer tableId){
        return waiterService.paybill(tableId);
    }
}
