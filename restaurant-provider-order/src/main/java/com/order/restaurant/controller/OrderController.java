package com.order.restaurant.controller;

import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.order.restaurant.entities.CommentResult;
import com.order.restaurant.entities.FoodBody;
import com.order.restaurant.entities.FoodInfo;
import com.order.restaurant.service.OrderService;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.util.Collection;
import java.util.List;

@RestController
public class OrderController {
    @Resource
    private OrderService orderService;
    @GetMapping(value = "/order/getFoodList")
    public CommentResult getFoodList(@RequestParam("table_id") Integer tableId){
        Collection<FoodInfo> foodList = orderService.getFoodList(tableId);
        return new CommentResult<>(200,"success",foodList);

    }
    @PostMapping(value = "/order/{table_id}")
    public String order(@PathVariable("table_id") Integer tableId,  @RequestBody JSONObject json){
        JSONArray data = json.getJSONArray("data");
        List<FoodBody> foodBodies = JSONUtil.toList(data, FoodBody.class);
        for(FoodBody f:foodBodies){
            System.out.println(f.toString());
            orderService.addOrder(tableId,f);
        }
        return data.toString();
    }
}
