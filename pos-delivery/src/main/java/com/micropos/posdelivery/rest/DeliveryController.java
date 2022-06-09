package com.micropos.posdelivery.rest;


import com.micropos.posdelivery.service.DeliveryService;
import com.micropos.posdelivery.api.DeliveryApi;
import com.micropos.posorder.dto.OrderDto;
import com.micropos.posorder.mapper.OrderMapper;
import com.micropos.posorder.mapper.OrderMapperImpl;
import com.micropos.posorder.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api")
public class DeliveryController implements DeliveryApi {

    @Autowired
    private DeliveryService deliveryService;
    private OrderMapper orderMapper = new OrderMapperImpl();

    @Override
    public ResponseEntity<Object> checkDelivery(String uid) {
        List<Order> orderList = deliveryService.checkOrder(uid);
        if(orderList == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else{
            List<OrderDto> orderDtoList = orderMapper.toOrderDtoList(orderList);
            return new ResponseEntity<>(orderList, HttpStatus.OK);
        }
    }
}
