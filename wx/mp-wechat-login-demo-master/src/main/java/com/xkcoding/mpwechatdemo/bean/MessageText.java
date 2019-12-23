package com.xkcoding.mpwechatdemo.bean;

public class MessageText extends BaseMessage {
    private String Content;
    private String MsgId;

    public MessageText() {
    }

    public MessageText(String ToUserName,String FromUserName,long CreateTime,String MsgType,String Content,String MsgId){
        super();
        ToUserName = ToUserName;
        FromUserName = FromUserName;
        CreateTime = CreateTime;
        MsgType = MsgType;
        Content = Content;
        MsgId = MsgId;
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }

    public String getMsgId() {
        return MsgId;
    }

    public void setMsgId(String msgId) {
        MsgId = msgId;
    }
}
