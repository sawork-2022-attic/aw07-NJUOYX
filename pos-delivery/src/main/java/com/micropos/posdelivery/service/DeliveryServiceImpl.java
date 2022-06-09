package com.micropos.posdelivery.service;

import com.micropos.posdelivery.repository.DeliveryRepository;
import com.micropos.posorder.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Consumer;

@Service
public class DeliveryServiceImpl implements DeliveryService{

    @Autowired
    private DeliveryRepository deliveryRepository;

    @Override
    public List<Order> checkOrder(String uid) {
        return deliveryRepository.query(uid);
    }

    @Bean
    public Consumer<Order>getOrder(){return new OrderGetter();}

}
