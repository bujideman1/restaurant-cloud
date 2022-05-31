package com.order.restaurant.mapper;

import com.order.restaurant.entities.FoodBody;
import com.order.restaurant.entities.FoodInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Collection;
@Mapper
public interface OrderMapper {
    Collection<FoodInfo> getFoodList(@PathVariable("tableId") int tableId);
    int addOrder(@Param("table_id") int tableId, @Param("foodBody") FoodBody foodBody);
}
