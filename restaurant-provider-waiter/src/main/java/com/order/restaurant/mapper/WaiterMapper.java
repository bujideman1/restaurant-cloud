package com.order.restaurant.mapper;

import com.order.restaurant.entities.FoodBody;
import com.order.restaurant.entities.Table;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface WaiterMapper {
     List<FoodBody> getReadyFoodByTableId(@Param("table_id")Integer tableId);
     List<Table> getAllReadyTable();
     int complateOrder(@Param("order_id")Integer orderId);
     int readyOrder(@Param("order_id")Integer orderId);
     int cancelOrder(@Param("order_id")Integer orderId);
     int finishOrder(@Param("table_id")Integer tableId);
     List<FoodBody> getAllDoneFoodByTableId(@Param("table_id")Integer tableId);
}
