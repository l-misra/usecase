package com.usecase.queue;

import java.util.Comparator;

public class MessageComparator implements Comparator<Message> {

    @Override
    public int compare(Message m1, Message m2) {

        if (m1 == m2)
            return 0;

        if (m1 != null && m2 != null) {
            if (m1.getOrderId().equals(m2.getOrderId()))
                return 0;
        }
        return 1;

    }
}
