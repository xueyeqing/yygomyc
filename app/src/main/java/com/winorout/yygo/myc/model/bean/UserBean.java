package com.winorout.yygo.myc.model.bean;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * @Description: 用户实体类
 * @Author: zyzhang
 * @Date: 17/11/3 下午4:52
 */
public class UserBean implements Serializable {

    //token	string	用户登录生成的token
    //uid	string	用户Id
    @SerializedName("token")
    private String token;
    @SerializedName("uid")
    private String uid;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }
}
