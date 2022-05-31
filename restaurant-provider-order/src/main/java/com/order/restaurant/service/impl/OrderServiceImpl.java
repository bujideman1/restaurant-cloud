package com.order.restaurant.service.impl;

import com.order.restaurant.entities.FoodBody;
import com.order.restaurant.entities.FoodInfo;
import com.order.restaurant.mapper.OrderMapper;
import com.order.restaurant.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderMapper orderMapper;
    @Override
    public Collection<FoodInfo> getFoodList(int tableId) {
        return orderMapper.getFoodList(tableId);
    }

    @Override
    public int addOrder(int tableId, FoodBody foodBody) {
        return orderMapper.addOrder(tableId,foodBody);
    }
}
