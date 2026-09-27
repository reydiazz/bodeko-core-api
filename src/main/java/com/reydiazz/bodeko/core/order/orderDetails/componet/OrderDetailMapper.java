package com.reydiazz.bodeko.core.order.orderDetails.componet;

import com.reydiazz.bodeko.core.order.orderDetails.entity.OrderDetails;
import com.reydiazz.bodeko.core.order.orderDetails.web.response.OrderDetailResponse;
import org.springframework.stereotype.Component;

@Component
public class OrderDetailMapper {

    public OrderDetailResponse toResponse (OrderDetails orderDetails){
        return  new OrderDetailResponse(
                orderDetails.getId(),
                orderDetails.getPrice(),
                orderDetails.getQuantity(),
                orderDetails.getOrder().getId(),
                orderDetails.getProduct().getId()
        );

    }
}
