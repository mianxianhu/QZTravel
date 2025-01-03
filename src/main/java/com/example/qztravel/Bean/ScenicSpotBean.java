package com.example.qztravel.Bean;

import java.io.Serializable;

public class ScenicSpotBean implements Serializable {
    private String name;
    private String description;
    private String address;
    private String openTime;

    // 无参构造函数
    public ScenicSpotBean() {
    }

    // getter 和 setter 方法
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getOpenTime() {
        return openTime;
    }

    public void setOpenTime(String openTime) {
        this.openTime = openTime;
    }
}