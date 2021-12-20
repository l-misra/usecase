package com.usecase.db;

import java.util.concurrent.ConcurrentHashMap;

import com.usecase.orderdetail.model.OrderDetails;

public class OrderDetailDb {

    private static ConcurrentHashMap<String, OrderDetails> db = new ConcurrentHashMap<String, OrderDetails>();

    public static void add(OrderDetails orderDetails) {
        if (null != orderDetails) {
            System.out.println("Adding in db. orderDetails " + orderDetails);
            db.put(orderDetails.getOrderId(), orderDetails);
        }

    }

    public static OrderDetails getProduct(String id) {
        if( id == null  )
            return null;
        OrderDetails detail = db.get(id);
        System.out.println("Fetched from cached orderDetails " + detail);
        return detail;
    }

    public static void update(OrderDetails orderDetails) {
        if( orderDetails != null ) {
            OrderDetails order = getProduct(orderDetails.getOrderId());
            if( order != null ) {
                orderDetails.setCreateDate(order.getCreateDate());
                orderDetails.setLastUpdatedDate(order.getLastUpdatedDate());
            }
            
            add(orderDetails);
        }
       
    }
    
}
