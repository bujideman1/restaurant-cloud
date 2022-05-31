package com.order.restaurant.service;

import com.order.restaurant.entities.FoodBody;
import com.order.restaurant.entities.FoodInfo;
import org.apache.ibatis.annotations.Param;

import java.util.Collection;

public interface OrderService {
    Collection<FoodInfo> getFoodList(@Param("table_id")int tableId);
    int addOrder(@Param("table_id")int tableId, FoodBody foodBody);
}
