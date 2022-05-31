package com.order.restaurant.controller;

import cn.hutool.json.JSONObject;
import com.order.restaurant.entities.CommentResult;
import com.order.restaurant.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
public class OrderController {
    @Resource
    private OrderService orderService;
    @GetMapping(value = "consumer/order/getFoodList")
    public CommentResult getFoodList(@RequestParam("table_id") Integer tableId){
        return orderService.getFoodList(tableId);
    }
    @PostMapping(value = "consumer/order/{table_id}")
    public String order(@PathVariable("table_id") Integer tableId, @RequestBody JSONObject json){
        return orderService.order(tableId,json);
    }
}
