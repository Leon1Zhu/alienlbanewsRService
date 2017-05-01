package com.alienlab.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.ZonedDateTime;

/**
 * Created by zhuliang on 2017/5/1.
 * 报刊详情表
 */
@Document
public class AlinewsPaperInfo {
    @Id
    private String id;
    //报刊id；
    private String paperId;
    //更新时间（精确到天）
    private ZonedDateTime updateTime;
    //版面地址
    private String htmlUrl;
    //创建时间
    private ZonedDateTime createTime;

    public AlinewsPaperInfo() {
    }

    public AlinewsPaperInfo(String id, String paperId, ZonedDateTime updateTime, String htmlUrl, ZonedDateTime createTime) {
        this.id = id;
        this.paperId = paperId;
        this.updateTime = updateTime;
        this.htmlUrl = htmlUrl;
        this.createTime = createTime;
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

    public ZonedDateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(ZonedDateTime updateTime) {
        this.updateTime = updateTime;
    }

    public String getHtmlUrl() {
        return htmlUrl;
    }

    public void setHtmlUrl(String htmlUrl) {
        this.htmlUrl = htmlUrl;
    }

    public ZonedDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(ZonedDateTime createTime) {
        this.createTime = createTime;
    }
}
