package com.alienlab.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.ZonedDateTime;
import java.util.Date;

/**
 * Created by zhuliang on 2017/5/1.
 * 用户收藏表
 */
@Document
public class AlinewsCollect {
    @Id
    private String id;
    //收藏的报纸id
    private String paperId;
    //收藏的用户id
    private String userId;
    //收藏时间
    private Date collectTime;

    public AlinewsCollect() {
    }

    public AlinewsCollect(String id, String paperId, String userId, Date collectTime) {
        this.id = id;
        this.paperId = paperId;
        this.userId = userId;
        this.collectTime = collectTime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPaperId() {
        return paperId;
    }

    public void setPaperId(String paperId) {
        this.paperId = paperId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Date getCollectTime() {
        return collectTime;
    }

    public void setCollectTime(Date collectTime) {
        this.collectTime = collectTime;
    }
}
