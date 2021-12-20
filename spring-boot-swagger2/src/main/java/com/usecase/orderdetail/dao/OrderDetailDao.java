package com.usecase.orderdetail.dao;

import java.util.Date;

import org.springframework.stereotype.Component;

import com.usecase.db.OrderDetailDb;
import com.usecase.orderdetail.model.OrderDetails;

@Component
public class OrderDetailDao {

    public OrderDetails postOrderById(String id) {
        String token = System.currentTimeMillis() + "";
        Date date = new Date();
        OrderDetails orderDetails = new OrderDetails(token, "order accepted", "accepted", date, date, id);
        OrderDetailDb.add(orderDetails);
        return orderDetails;
    }
    
    public void updateDb(OrderDetails orderDetails) {
        OrderDetailDb.update(orderDetails);
    }

}
