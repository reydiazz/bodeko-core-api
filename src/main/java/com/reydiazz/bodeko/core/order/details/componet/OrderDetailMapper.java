package com.reydiazz.bodeko.core.order.details.componet;

import com.reydiazz.bodeko.core.order.details.entity.OrderDetail;
import com.reydiazz.bodeko.core.order.details.web.response.OrderDetailResponse;
import org.springframework.stereotype.Component;

@Component
public class OrderDetailMapper {

    public OrderDetailResponse toResponse (OrderDetail orderDetails){
        return  new OrderDetailResponse(
                orderDetails.getId(),
                orderDetails.getPrice(),
                orderDetails.getQuantity(),
                orderDetails.getOrder().getId(),
                orderDetails.getProduct().getId()
        );

    }
}
