package com.xkcoding.mpwechatdemo.utils;

public interface BaseMessageUtil <T> {
    //将回复的信息对象转xml格式给微信
    public  abstract  String messageToxml(T t);

    //回复的信息封装
    public abstract  String initMessage(String FromUserName,String ToUserName);
}
