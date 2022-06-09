package com.micropos.posdelivery.repository;

import com.micropos.posorder.model.Order;

import java.util.List;

public interface DeliveryRepository {
    List<Order> query(String uid);
    void insert(Order order);
}
