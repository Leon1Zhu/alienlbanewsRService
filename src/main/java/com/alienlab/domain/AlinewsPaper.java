package com.alienlab.domain;

import org.springframework.data.annotation.Id;

import java.time.ZonedDateTime;
import java.util.List;

/**
 * Created by zhuliang on 2017/5/1.
 * 报纸表
 */
public class AlinewsPaper {
    @Id
    private  String id;
    //报纸名称
    private  String paperName;
    //报纸地址
    private  String paperUrl;
    //报纸类别
    private AlinewsPaperType paperType;
    //报纸状态
    private String paperStatus;
    //报纸收藏人数
    private int collectCount;
    //创建时间
    private ZonedDateTime createTime;

    public AlinewsPaper() {
    }

    public AlinewsPaper(String id, String paperName, String paperUrl, AlinewsPaperType paperType, String paperStatus, int collectCount, ZonedDateTime createTime) {
        this.id = id;
        this.paperName = paperName;
        this.paperUrl = paperUrl;
        this.paperType = paperType;
        this.paperStatus = paperStatus;
        this.collectCount = collectCount;
        this.createTime = createTime;
    }

    public String getPaperName() {
        return paperName;
    }

    public void setPaperName(String paperName) {
        this.paperName = paperName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPaperUrl() {
        return paperUrl;
    }

    public void setPaperUrl(String paperUrl) {
        this.paperUrl = paperUrl;
    }

    public AlinewsPaperType getPaperType() {
        return paperType;
    }

    public void setPaperType(AlinewsPaperType paperType) {
        this.paperType = paperType;
    }

    public String getPaperStatus() {
        return paperStatus;
    }

    public void setPaperStatus(String paperStatus) {
        this.paperStatus = paperStatus;
    }

    public int getCollectCount() {
        return collectCount;
    }

    public void setCollectCount(int collectCount) {
        this.collectCount = collectCount;
    }

    public ZonedDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(ZonedDateTime createTime) {
        this.createTime = createTime;
    }
}