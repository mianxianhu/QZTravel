package com.example.qztravel.Bean;

import java.io.Serializable;


public class TicketOrderBean implements Serializable {
    private int orderId;
    private String userId;
    private String scenicSpotId;
    private String orderTime;
    private int quantity;


   // 无参构造函数
    public TicketOrderBean() {
    }


    // getter 和 setter 方法
    public int getOrderId() {
        return orderId;
    }


    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }


    public String getUserId() {
        return userId;
    }


    public void setUserId(String userId) {
        this.userId = userId;
    }


    public String getScenicSpotId() {
        return scenicSpotId;
    }


    public void setScenicSpotId(String scenicSpotId) {
        this.scenicSpotId = scenicSpotId;
    }


    public String getOrderTime() {
        return orderTime;
    }


    public void setOrderTime(String orderTime) {
        this.orderTime = orderTime;
    }


    public int getQuantity() {
        return quantity;
    }


    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}

