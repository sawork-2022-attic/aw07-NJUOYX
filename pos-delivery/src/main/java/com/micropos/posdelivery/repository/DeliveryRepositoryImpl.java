package com.micropos.posdelivery.repository;

import com.micropos.posorder.model.Order;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class DeliveryRepositoryImpl implements DeliveryRepository{

    Map<String, List<Order>> repository = new HashMap<>();

    @Override
    public List<Order> query(String uid) {
        return repository.get(uid);
    }

    @Override
    public void insert(Order order) {
        if(order != null){
            String uid = order.getUser().getUid();
            List<Order> orderList = repository.get(uid);
            if(orderList == null){
                repository.put(uid, List.of(order));
            }else{
                orderList.add(order);
            }
        }
    }
}
