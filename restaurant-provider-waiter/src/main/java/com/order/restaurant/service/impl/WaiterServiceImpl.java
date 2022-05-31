package com.order.restaurant.service.impl;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.order.restaurant.entities.FoodBody;
import com.order.restaurant.entities.Table;
import com.order.restaurant.mapper.WaiterMapper;
import com.order.restaurant.service.WaiterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class WaiterServiceImpl implements WaiterService {
    @Autowired
    private WaiterMapper waiterMapper;
    @Override
    public List<FoodBody> getReadyFoodByTableId(Integer tableId) {
        return waiterMapper.getReadyFoodByTableId(tableId);
    }

    @Override
    public List<Table> getAllReadyTable() {
        return waiterMapper.getAllReadyTable();
    }

    @Override
    public int complateOrder(Integer orderId) {
        return waiterMapper.complateOrder(orderId);
    }

    @Override
    public int readyOrder(Integer orderId) {
        return waiterMapper.readyOrder(orderId);
    }

    @Override
    public int finishOrder(Integer orderId) {
        return waiterMapper.finishOrder(orderId);
    }

    @Override
    public int cancelOrder(Integer orderId) {
        return waiterMapper.cancelOrder(orderId);
    }


    @Override
    public List<FoodBody> getAllDoneFoodByTableId(Integer tableId) {
        return waiterMapper.getAllDoneFoodByTableId(tableId);
    }

    @HystrixCommand(fallbackMethod = "getBills_fallback",commandProperties = {
            @HystrixProperty(name="circuitBreaker.enabled",value = "true"),//是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"),//请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"),//时间窗口期
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "60"),//失败率达到多少
    })
    @Override
    public Map<String, Object> getBills(Integer tableId) {
        float totalMoney=0;
        List<FoodBody> foods = waiterMapper.getAllDoneFoodByTableId(tableId);
        for(FoodBody f:foods){
            float money=f.getFoodNum()*f.getPrice();
            f.setPrice(money);
            totalMoney+=money;
        }
        Map<String,Object> result=new HashMap<>();
        result.put("tableId",tableId);
        result.put("foodInfo",foods);
        result.put("totalMoney",totalMoney);
        return result;
    }

    @Override
    public int payBill(Integer tableId) {
        return waiterMapper.finishOrder(tableId);
    }


    public String getBills_fallback(Integer tableId){
        return "服务繁忙，请稍后再试";
    }
}
