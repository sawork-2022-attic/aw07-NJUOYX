package com.micropos.posdelivery.service;


import com.micropos.posorder.model.Order;

import java.util.List;

public interface DeliveryService {
    List<Order> checkOrder(String uid);
}
