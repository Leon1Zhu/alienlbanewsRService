package com.alienlab.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.ZonedDateTime;
import java.util.Date;

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
    private String updateTime;
    //版面地址
    private String htmlUrl;
    //创建时间
    private Date createTime;

    public AlinewsPaperInfo() {
    }

    public AlinewsPaperInfo(String id, String paperId, String updateTime, String htmlUrl, Date createTime) {
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

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public String getHtmlUrl() {
        return htmlUrl;
    }

    public void setHtmlUrl(String htmlUrl) {
        this.htmlUrl = htmlUrl;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
