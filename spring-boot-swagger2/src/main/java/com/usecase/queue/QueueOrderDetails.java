package com.usecase.queue;

import java.util.PriorityQueue;
import java.util.Queue;

import org.springframework.stereotype.Component;

@Component()
public class QueueOrderDetails extends AbstractQueue {

    private static final int QUEUE_SIZE = 10;
    private static final int RETRY = 3;
    private static final String QUEUE_NAME = "QUEUE_ORDER_DETAILS";

    private static Queue<Message> queue = new PriorityQueue();

    @Override
    public Queue getQueue() {
        return queue;
    }

    @Override
    public String getQueueName() {
        return QUEUE_NAME;
    }

    @Override
    public String getClassName() {
        return "QueueOrderDetails";
    }

}
