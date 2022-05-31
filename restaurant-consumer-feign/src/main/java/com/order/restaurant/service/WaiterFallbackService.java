package com.order.restaurant.service;

import com.order.restaurant.entities.CommentResult;
import org.springframework.stereotype.Component;

@Component
public class WaiterFallbackService implements WaiterService {
    @Override
    public CommentResult getReadyFoods(Integer tableId) {
        return null;
    }

    @Override
    public CommentResult readyFood(Integer foodId) {
        return null;
    }

    @Override
    public CommentResult complateFood(Integer foodId) {
        return null;
    }

    @Override
    public CommentResult cancelFood(Integer foodId) {
        return null;
    }

    @Override
    public CommentResult checkout(Integer tableId) {
        return new CommentResult(400,"服务忙，稍后再试");
    }

    @Override
    public CommentResult checkout2(Integer tableId) {
        return null;
    }

    @Override
    public CommentResult paybill(Integer tableId) {
        return null;
    }
}
