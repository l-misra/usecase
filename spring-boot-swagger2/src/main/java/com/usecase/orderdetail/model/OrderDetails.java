package com.usecase.orderdetail.model;

import java.util.Date;

public class OrderDetails {

    String orderId;
    String orderDetails;
    String orderStatus;
    Date createDate;
    Date lastUpdatedDate;
    String pid;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(String orderDetails) {
        this.orderDetails = orderDetails;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getLastUpdatedDate() {
        return lastUpdatedDate;
    }

    public void setLastUpdatedDate(Date lastUpdatedDate) {
        this.lastUpdatedDate = lastUpdatedDate;
    }
    

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }


    public OrderDetails(String orderId, String orderDetails, String orderStatus, Date createDate, Date lastUpdatedDate,
            String pid) {
        super();
        this.orderId = orderId;
        this.orderDetails = orderDetails;
        this.orderStatus = orderStatus;
        this.createDate = createDate;
        this.lastUpdatedDate = lastUpdatedDate;
        this.pid = pid;
    }

    @Override
    public String toString() {
        return "OrderDetails [orderId=" + orderId + ", orderDetails=" + orderDetails + ", orderStatus=" + orderStatus
                + ", createDate=" + createDate + ", lastUpdatedDate=" + lastUpdatedDate + ", pid=" + pid + "]";
    }


}
