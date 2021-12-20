package com.usecase.queue;

public class Message {

    private String message;
    private String token;
    private String orderId;
    private String pid;
    private String orderStatus;

    public Message(String message, String token, String orderId, String pid, String orderStatus) {
        super();
        this.message = message;
        this.token = token;
        this.orderId = orderId;
        this.pid = pid;
        this.orderStatus = orderStatus;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    @Override
    public String toString() {
        return "Message [message=" + message + ", token=" + token + ", orderId=" + orderId + ", pid=" + pid
                + ", orderStatus=" + orderStatus + "]";
    }

}
