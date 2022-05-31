package com.order.restaurant.service;

import com.order.restaurant.entities.CommentResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;


@Component
@FeignClient(value = "restaurant-provider-waiter",fallback = WaiterFallbackService.class)
public interface WaiterService {
    @GetMapping(value = "waiter/getReadyFoods")
    public CommentResult getReadyFoods(@RequestParam("table_id") Integer tableId);
    @PostMapping(value = "waiter/readyFood/{food_id}")
    public CommentResult readyFood(@PathVariable("food_id")Integer foodId);
    @PostMapping(value = "waiter/complateFood/{food_id}")
    public CommentResult complateFood(@PathVariable("food_id")Integer foodId);
    @PostMapping(value = "waiter/cancelFood/{food_id}")
    public CommentResult cancelFood(@PathVariable("food_id")Integer foodId);
    @GetMapping(value = "waiter/checkout/{table_id}")
    public CommentResult checkout(@PathVariable("table_id")Integer tableId);
    @GetMapping(value = "waiter/checkout2/{table_id}")
    public CommentResult checkout2(@PathVariable("table_id")Integer tableId);
    @RequestMapping(value = "waiter/paybill/{table_id}")
    public CommentResult paybill(@PathVariable("table_id")Integer tableId);
}
