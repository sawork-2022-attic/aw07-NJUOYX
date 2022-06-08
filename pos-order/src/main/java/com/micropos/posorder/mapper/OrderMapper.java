package com.micropos.posorder.mapper;

import com.micropos.poscounter.dto.OrderDto;
import com.micropos.posorder.model.Order;
import org.mapstruct.Mapper;

@Mapper
public interface OrderMapper {
    Order toOrder(OrderDto orderDto);
    OrderDto toOrderDto(Order order);
}
