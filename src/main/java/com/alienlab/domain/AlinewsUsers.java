package com.alienlab.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.ZonedDateTime;

/**
 * Created by zhuliang on 2017/4/30.
 * 系统用户表
 */
@Document
public class AlinewsUsers {
    @Id
    private String id;
    //用户名
    private String userName;
    //密码
    private String userPassword;
    //电话
    private String tel;
    //email
    private String email;
    //用户来源
    private String source;
    //创建时间
    private ZonedDateTime  createTime;

    public AlinewsUsers() {
    }

    public AlinewsUsers(String userName, String userPassword, String tel, String email, String source,ZonedDateTime zonedDateTime) {
        this.userName = userName;
        this.userPassword = userPassword;
        this.tel = tel;
        this.email = email;
        this.source = source;
        this.createTime=zonedDateTime;
    }

    public AlinewsUsers(String id, String userName, String userPassword, String tel, String email, String source,ZonedDateTime zonedDateTime) {
        this.id = id;
        this.userName = userName;
        this.userPassword = userPassword;
        this.tel = tel;
        this.email = email;
        this.source = source;
        this.createTime=zonedDateTime;
    }

    public ZonedDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(ZonedDateTime createTime) {
        this.createTime = createTime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }
}
