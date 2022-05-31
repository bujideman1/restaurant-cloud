package com.order.restaurant.service;

import com.order.restaurant.entities.FoodBody;
import com.order.restaurant.entities.Table;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface WaiterService {
    List<FoodBody> getReadyFoodByTableId(@Param("table_id")Integer tableId);
    List<Table> getAllReadyTable();
    int complateOrder(@Param("order_id")Integer orderId);
    int readyOrder(@Param("order_id")Integer orderId);
    int finishOrder(@Param("order_id")Integer orderId);
    int cancelOrder(@Param("order_id")Integer orderId);
    List<FoodBody> getAllDoneFoodByTableId(@Param("table_id")Integer tableId);
    Map<String,Object> getBills(Integer tableId);
    int payBill(@Param("table_id")Integer tableId);
}
