package com.alienlab.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.ZonedDateTime;

/**
 * Created by zhuliang on 2017/5/1.
 * 报纸类别表
 */
@Document
public class AlinewsPaperType {
    @Id
    private  String id;
    //类别名称
    private String typeName;
    //创建时间
    private ZonedDateTime createTime;
    //类别状态
    private String stauts;

    public AlinewsPaperType() {
    }

    public AlinewsPaperType(String id, String typeName, ZonedDateTime createTime, String stauts) {
        this.id = id;
        this.typeName = typeName;
        this.createTime = createTime;
        this.stauts = stauts;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public ZonedDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(ZonedDateTime createTime) {
        this.createTime = createTime;
    }

    public String getStauts() {
        return stauts;
    }

    public void setStauts(String stauts) {
        this.stauts = stauts;
    }
}
