package com.micropos.posdelivery.service;

import com.micropos.posdelivery.repository.DeliveryRepository;
import com.micropos.posorder.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.function.Consumer;

@Service
public class OrderGetter implements Consumer<Order> {

    @Autowired
    private DeliveryRepository deliveryRepository;

    @Override
    public void accept(Order order) {
        deliveryRepository.insert(order);
    }
}
