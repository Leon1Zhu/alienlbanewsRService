package com.alienlab.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.ZonedDateTime;

/**
 * Created by zhuliang on 2017/5/1.
 * 消息推送表
 */
@Document
public class AlinewsMessage {
    @Id
    private String id;
    //推送人
    private String messageOrigin;
    //推送目标用户
    private String messageTarget;
    //推送时间
    private ZonedDateTime messageTime;
    //推送内容
    private String messageContent;
    //消息状态（0未读，1已读）
    private String status;

    public AlinewsMessage() {
    }

    public AlinewsMessage(String id, String messageOrigin, String messageTarget, ZonedDateTime messageTime, String messageContent, String status) {
        this.id = id;
        this.messageOrigin = messageOrigin;
        this.messageTarget = messageTarget;
        this.messageTime = messageTime;
        this.messageContent = messageContent;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMessageOrigin() {
        return messageOrigin;
    }

    public void setMessageOrigin(String messageOrigin) {
        this.messageOrigin = messageOrigin;
    }

    public String getMessageTarget() {
        return messageTarget;
    }

    public void setMessageTarget(String messageTarget) {
        this.messageTarget = messageTarget;
    }

    public ZonedDateTime getMessageTime() {
        return messageTime;
    }

    public void setMessageTime(ZonedDateTime messageTime) {
        this.messageTime = messageTime;
    }

    public String getMessageContent() {
        return messageContent;
    }

    public void setMessageContent(String messageContent) {
        this.messageContent = messageContent;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
