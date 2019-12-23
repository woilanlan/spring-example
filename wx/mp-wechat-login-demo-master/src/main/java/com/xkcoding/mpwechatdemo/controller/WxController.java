package com.xkcoding.mpwechatdemo.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.xkcoding.mpwechatdemo.autoconfiguration.WxProperties;
import com.xkcoding.mpwechatdemo.utils.CheckUtil;
import com.xkcoding.mpwechatdemo.utils.HttpClientUtil;
import com.xkcoding.mpwechatdemo.utils.MessageUtil;
import com.xkcoding.mpwechatdemo.utils.TextMessageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.Map;
import java.util.function.Predicate;

@Controller
@RequestMapping("/wx")
public class WxController {

    @Autowired
    WxProperties wxProperties;

    @RequestMapping("/login")
    public void wxLogin(HttpServletResponse response) throws IOException {
        //请求获取code的回调地址
        //用线上环境的域名或者用内网穿透，不能用ip
//        String callBack = "http://你的域名/wxAuth/callBack";
        String callBack = "http://woilanlan.51vip.biz/wx/callBack";

        //请求地址
        String url = "https://open.weixin.qq.com/connect/oauth2/authorize" +
                "?appid=" + "wx5c5335fd456fb22d" +
                "&redirect_uri=" + URLEncoder.encode(callBack,"utf-8") +
                "&response_type=code" +
                "&scope=snsapi_userinfo" +
                "&state=STATE#wechat_redirect";
        //重定向
        response.sendRedirect(url);
    }

    //	回调方法
    @RequestMapping("/callBack")
    public void wxCallBack(HttpServletRequest request,HttpServletResponse response) throws IOException {
        String code = request.getParameter("code");

        //获取access_token
        String url = "https://api.weixin.qq.com/sns/oauth2/access_token" +
                "?appid=" + "wx5c5335fd456fb22d" +
                "&secret=" + "0e24ba1bfd63fac5179b554b833b8c6e" +
                "&code=" + code +
                "&grant_type=authorization_code";

        String result = HttpClientUtil.doGet(url);

        System.out.println("请求获取access_token:" + result);
        //返回结果的json对象
        JSONObject resultObject = JSON.parseObject(result);

        //请求获取userInfo
        String infoUrl = "https://api.weixin.qq.com/sns/userinfo" +
                "?access_token=" + resultObject.getString("access_token") +
                "&openid=" + resultObject.getString("openid") +
                "&lang=zh_CN";

        String resultInfo = HttpClientUtil.doGet(infoUrl);

        //此时已获取到userInfo，再根据业务进行处理
        System.out.println("请求获取userInfo:" + resultInfo);
    }

    /*
    接入微信公众号
     */
    @RequestMapping(value = "/Handle",method = RequestMethod.GET)
    public void WxAccess(HttpServletRequest req, HttpServletResponse resp){
        System.out.println("checkSignature");
        String signature = req.getParameter("signature");
        String timestamp = req.getParameter("timestamp");
        String nonce = req.getParameter("nonce");
        String echostr = req.getParameter("echostr");
        PrintWriter out = null;
        try {
            out = resp.getWriter();
            if (CheckUtil.checkSignature(signature,timestamp,nonce)){
                System.out.println(echostr);
                out.write(echostr);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            out.close();
        }
    }

    /*
    接收普通消息
    微信服务器在五秒内收不到响应会断掉连接，并且重新发起请求，总共重试三次。假如服务器无法保证在五秒内处理并回复，可以直接回复空串。
     */
    @RequestMapping(value = "/Handle",method=RequestMethod.POST)
    public void getWxMessage(HttpServletRequest request,HttpServletResponse response){
        response.setCharacterEncoding("utf-8");
        PrintWriter out = null;

        //将微信请求xml转为map格式，获取所需的参数
        Map<String,String> map = MessageUtil.xmlToMap(request);

        String ToUserName = map.get("ToUserName");
        String FromUserName = map.get("FromUserName");
        String MsgType = map.get("MsgType");
        String Content = map.get("Content");
        String message = null;

        //处理文本类型，实现输入1，回复相应的封装的内容
        if("text".equals(MsgType)){
            TextMessageUtil textMessage = new TextMessageUtil();
            if(Content.equals("login")){
                message = textMessage.initMessage(FromUserName, ToUserName,"http://woilanlan.51vip.biz/wx/login");
            }else{
                message = textMessage.initMessage(FromUserName, ToUserName,Content);
            }
        }
        try {
            out = response.getWriter();
            out.write(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
        out.close();
    }
}
