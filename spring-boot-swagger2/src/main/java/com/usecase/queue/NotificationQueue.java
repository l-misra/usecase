package com.usecase.queue;

import java.util.PriorityQueue;
import java.util.Queue;

import org.springframework.stereotype.Component;

@Component()
public class NotificationQueue extends AbstractQueue {

    private static final int QUEUE_SIZE = 60;
    private static final int RETRY = 3;
    private static final String QUEUE_NAME = "QUEUE_NOTIFICATION_DETAILS";

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
        return "NotificationQueue";
    }

}
