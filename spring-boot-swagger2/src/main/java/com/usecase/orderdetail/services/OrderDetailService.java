package com.usecase.orderdetail.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.usecase.errorcode.ErrorCode;
import com.usecase.orderdetail.dao.OrderDetailDao;
import com.usecase.orderdetail.model.OrderDetails;
import com.usecase.queue.Message;
import com.usecase.queue.NotificationQueue;
import com.usecase.queue.QueueOrderDetails;
import com.usecase.response.ErrorResponse;
import com.usecase.response.Response;
import com.usecase.response.SuccessResponse;

@Service
public class OrderDetailService {

    @Autowired
    private OrderDetailDao orderDetailDao;

    @Autowired
    private QueueOrderDetails queueOrderDetails;
    
    @Autowired
    private NotificationQueue notificationQueue;

    public Response postOrderById(String id) {
        OrderDetails details = null;
        Message message = null;
        try {
            details = orderDetailDao.postOrderById(id);
            System.out.println("order details : " + details);
            message = toMessage(details);
            queueOrderDetails.pushToQueue(message);
            System.out.println("messge details " + message);
            return new SuccessResponse("Order accepted", true, details);
        } catch (Exception e) {
            System.err.println("Error occured while process order " + id);
            e.printStackTrace();
            return new ErrorResponse(e.getMessage() + "Error occured while process order " + id,
                    ErrorCode.UNKNOWN_ERROR, false);
        }finally {
            try {
                System.out.println("OrderDetailService pushing to notificationQueue message" + message);
                notificationQueue.pushToQueue(message);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    private Message toMessage(OrderDetails details) {
        if (details == null)
            return null;
        Message message = new Message(details.getOrderDetails(), details.getOrderId(), details.getOrderId(),
                details.getPid(), details.getOrderStatus());
        return message;
    }

}
