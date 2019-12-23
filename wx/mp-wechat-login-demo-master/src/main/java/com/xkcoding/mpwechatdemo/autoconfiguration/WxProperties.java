package com.xkcoding.mpwechatdemo.autoconfiguration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "wx")
public class WxProperties {
    private String wx_token_url;
    private String wx_redirect_url;
    private String wx_openid_url;
    private String wx_userinfo_url;
    private String wx_appid;
    private String wx_secret;
}
