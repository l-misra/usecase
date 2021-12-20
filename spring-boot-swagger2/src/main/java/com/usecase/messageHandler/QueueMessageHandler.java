package com.usecase.messageHandler;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.usecase.orderdetail.dao.OrderDetailDao;
import com.usecase.orderdetail.model.OrderDetails;
import com.usecase.queue.Message;
import com.usecase.queue.NotificationQueue;
import com.usecase.queue.QueueOrderDetails;

@Component
public class QueueMessageHandler {

    @Autowired
    private List<BaseMsgHandler> messageHandlers;

    public static boolean STOP = false;

    public static void stop() {
        STOP = true;
    }

    @PostConstruct
    public void postConStruct() {
        for (BaseMsgHandler bm : messageHandlers) {
            System.out.println("Starting thread for " + bm.getName());
            new Thread(bm).start();
        }
    }

}

abstract class BaseMsgHandler implements Runnable {
    @Override
    public void run() {
        System.out.println("Started thread for " + getName());
        while (QueueMessageHandler.STOP == false) {
            System.out.println("Processing message in " + getName());
            processMessage();
        }
    }

    public abstract void processMessage();
    
    public abstract String getName();
}

@Component
class OrderMsgHandler extends BaseMsgHandler {
    @Autowired
    private QueueOrderDetails orderDetails;

    @Autowired
    private OrderDetailDao detailDao;

    @Autowired
    private NotificationQueue nq;

    @Override
    public void processMessage() {
        Message message = null;
        try {
            message = orderDetails.pullFromQueu();
            System.out.println("OrderMsgHandler : ORDER processed successully , message" + message);
            message.setMessage("Order processed");
            message.setOrderStatus("PROCESSED");

        } catch (InterruptedException e) {
            System.err.println("OrderMsgHandler :unable to process message : " + message);
            e.printStackTrace();
            message.setMessage("Order failed" + e.getMessage());
            message.setOrderStatus("FAILED");
        } finally {
            try {
                if( message != null ) {
                    OrderDetails details = new OrderDetails(message.getOrderId(), message.getMessage(),
                            message.getOrderStatus(), null, null, message.getPid());
                    nq.pushToQueue(message);
                    detailDao.updateDb(details);
                }
                
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    @Override
    public String toString() {
        return "OrderMsgHandler [orderDetails=" + orderDetails + ", detailDao=" + detailDao + ", nq=" + nq + "]";
    }

    @Override
    public String getName() {
        return "OrderMsgHandler";
    }
    
    

}

@Component
class NotificationMsgHandler extends BaseMsgHandler {

    @Autowired
    private NotificationQueue nq;

    @Override
    public void processMessage() {
        Message message;
        try {
            message = nq.pullFromQueu();
            System.out.println("NotificationMsgHandler :Notification received for message " + message);
        } catch (InterruptedException e) {
            System.out.println("NotificationMsgHandler :Error in NotificationMsgHandler");
            e.printStackTrace();
        }

    }

    @Override
    public String getName() {
        return "NotificationMsgHandler";
    }
}