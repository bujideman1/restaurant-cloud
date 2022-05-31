package com.order.restaurant.service;

import cn.hutool.json.JSONObject;
import com.order.restaurant.entities.CommentResult;
import org.springframework.stereotype.Component;

@Component
public class OrderFallbackService  implements OrderService{
    @Override
    public CommentResult getFoodList(Integer tableId) {
        return new CommentResult(404,"获取菜单失败请稍后再试",null);
    }

    @Override
    public String order(Integer tableId, JSONObject json) {
        return "null";
    }
}
