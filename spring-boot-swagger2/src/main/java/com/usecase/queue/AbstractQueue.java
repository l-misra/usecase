package com.usecase.queue;

import java.util.Queue;

public abstract class AbstractQueue {

    private static final int QUEUE_SIZE = 10;
    private static final int RETRY = 3;
    

    public boolean pushToQueue(Message msg) throws InterruptedException {
        System.out.println("=================="+getClassName());
        System.out.println("pushToQueue to queue :"+ getQueueName() );
        System.out.println("queue details : " + getQueue());
        System.out.println("message :"+msg);
        System.out.println("==================");
        int retry = 0;
        while (retry < RETRY) {
            if (getQueue().size() <= getQueueSize()) {
                getQueue().add(msg);
                return true;
            }
            retry++;
            Thread.sleep(1000*10);
        }
        return false;
        

    }

    public Message pullFromQueu() throws InterruptedException {
        System.out.println("=================="+getClassName());
        System.out.println("pullFromQueu to queue :"+ getQueueName() );
        System.out.println("queue details : " + getQueue());
        
        int retry = 0;
        Message msg = null;
        while (retry < RETRY) {
            if (getQueue().size() > 0) {
                System.out.println("message :"+msg);
                msg =  (Message) getQueue().poll();
                System.out.println("==================");
                return msg;
            }
            retry++;
            Thread.sleep(1000*10);
        }
        System.out.println("message :"+msg);
        System.out.println("==================");
        return msg;
    }

    public abstract Queue getQueue();
    public int getRetry() {
        return RETRY;
    }
    
    public int getQueueSize() {
        return QUEUE_SIZE;
    }
    
    public abstract String getQueueName();
    
    public abstract String getClassName();

}
