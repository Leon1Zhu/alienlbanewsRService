package com.alienlab.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by zhuliang on 2017/4/30.
 */
@Document
public class AlinewsUsers {
    @Id
    private String id;
    private String userName;
    private String userPassword;
    private String tel;
    private String email;
    private String source;

    public AlinewsUsers() {
    }

    public AlinewsUsers(String userName, String userPassword, String tel, String email, String source) {
        this.userName = userName;
        this.userPassword = userPassword;
        this.tel = tel;
        this.email = email;
        this.source = source;
    }

    public AlinewsUsers(String id, String userName, String userPassword, String tel, String email, String source) {
        this.id = id;
        this.userName = userName;
        this.userPassword = userPassword;
        this.tel = tel;
        this.email = email;
        this.source = source;
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
