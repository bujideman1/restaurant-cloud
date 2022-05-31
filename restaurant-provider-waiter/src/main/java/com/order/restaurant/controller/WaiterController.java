package com.order.restaurant.controller;

import com.order.restaurant.entities.CommentResult;
import com.order.restaurant.entities.FoodBody;
import com.order.restaurant.service.WaiterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class WaiterController {
    @Autowired
    private WaiterService waiterService;
    @GetMapping(value = "waiter/getReadyFoods")
    public CommentResult getReadyFoods(@RequestParam("table_id") Integer tableId){
        List<FoodBody> readyFoods = waiterService.getReadyFoodByTableId(tableId);
        return new CommentResult(200,"获取待准备菜单成功",readyFoods);
    }
    @PostMapping(value = "waiter/readyFood/{food_id}")
    public CommentResult readyFood(@PathVariable("food_id")Integer foodId){
        int i = waiterService.readyOrder(foodId);
        return new CommentResult(200,"菜品加入制作成功",null);
    }
    @PostMapping(value = "waiter/complateFood/{food_id}")
    public CommentResult complateFood(@PathVariable("food_id")Integer foodId){
        int i = waiterService.complateOrder(foodId);
        return new CommentResult(200,"菜品制作成功",null);
    }
    @PostMapping(value = "waiter/cancelFood/{food_id}")
    public CommentResult cancelFood(@PathVariable("food_id")Integer foodId){
        int i = waiterService.cancelOrder(foodId);
        return new CommentResult(200,"菜品取消制作",null);
    }
    @GetMapping(value = "waiter/checkout/{table_id}")
    public CommentResult checkout(@PathVariable("table_id")Integer tableId){
        Map<String, Object> bills = waiterService.getBills(tableId);
        return new CommentResult(200,"账单获取成功",bills);
    }
    @GetMapping(value = "waiter/checkout2/{table_id}")
    public CommentResult checkout2(@PathVariable("table_id")Integer tableId){
        List<FoodBody> foods = waiterService.getAllDoneFoodByTableId(tableId);
        return new CommentResult(200,"账单获取成功",foods);
    }
    @RequestMapping(value = "waiter/paybill/{table_id}")
    public CommentResult paybill(@PathVariable("table_id")Integer tableId){
        waiterService.payBill(tableId);
        return new CommentResult(200,"支付成功",null);
    }
}
