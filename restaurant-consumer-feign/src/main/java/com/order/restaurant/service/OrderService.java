package com.order.restaurant.service;

import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import com.order.restaurant.entities.CommentResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;

import org.springframework.web.bind.annotation.*;


@Component
@FeignClient(value = "restaurant-provider-order",fallback = OrderFallbackService.class)
public interface OrderService {
    @GetMapping(value = "/order/getFoodList")
    public CommentResult getFoodList(@RequestParam("table_id") Integer tableId);
    @PostMapping(value = "/order/{table_id}")
    public String order(@PathVariable("table_id") Integer tableId, @RequestBody JSONObject json);
}
