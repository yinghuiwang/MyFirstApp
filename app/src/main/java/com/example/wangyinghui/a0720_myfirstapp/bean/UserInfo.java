package com.example.wangyinghui.a0720_myfirstapp.bean;

/**
 * Created by wangyinghui on 2018/7/25.
 */

public class UserInfo extends BaseBean {

    public String updatedAt;
    public String createdAt;
    public String id;
    public String ttl;
    public String userId;

    public String getUpdatedAt() {
        return updatedAt;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public String getId() {
        return id;
    }

    public String getTtl() {
        return ttl;
    }

    public String getUserId() {
        return userId;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setTtl(String ttl) {
        this.ttl = ttl;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
