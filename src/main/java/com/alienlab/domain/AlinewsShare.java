package com.alienlab.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.ZonedDateTime;

/**
 * Created by zhuliang on 2017/5/1.
 * 用户分享表
 */
@Document
public class AlinewsShare {
    @Id
    private String id;
    //分享用户id
    private String shareUserId;
    //分享内容
    private String shareContent;
    //分享时间
    private ZonedDateTime shareTime;

    public AlinewsShare() {
    }

    public AlinewsShare(String id, String shareUserId, String shareContent, ZonedDateTime shareTime) {
        this.id = id;
        this.shareUserId = shareUserId;
        this.shareContent = shareContent;
        this.shareTime = shareTime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getShareUserId() {
        return shareUserId;
    }

    public void setShareUserId(String shareUserId) {
        this.shareUserId = shareUserId;
    }

    public String getShareContent() {
        return shareContent;
    }

    public void setShareContent(String shareContent) {
        this.shareContent = shareContent;
    }

    public ZonedDateTime getShareTime() {
        return shareTime;
    }

    public void setShareTime(ZonedDateTime shareTime) {
        this.shareTime = shareTime;
    }
}
