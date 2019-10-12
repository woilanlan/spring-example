package com.longlong;

import okhttp3.*;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.TimeUnit;

public class DownloadImg {
    public static void main(String[] args) {
//        OkHttpClient.Builder builder = new OkHttpClient.Builder();
//        builder.readTimeout(5, TimeUnit.SECONDS)
//                .connectTimeout(5, TimeUnit.SECONDS);
//        OkHttpClient okHttpClient = builder.build();
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        OkHttpClient okHttpClient = (OkHttpClient) ctx.getBean("okHttpClient");

        Request.Builder requestBuilder = new Request.Builder();
        Request request = requestBuilder.url("http://pic1.win4000.com/wallpaper/c/53cdd1f7c1f21.jpg").get().build();
        okHttpClient.newCall(request).enqueue(new Callback() {
            public void onFailure(Call call, IOException e) {

            }

            public void onResponse(Call call, Response response) throws IOException {
                if (response.isSuccessful()) {
                    //如果请求成功
                    InputStream is = response.body().byteStream();
                    FileOutputStream fos = new FileOutputStream(new File("D:\\","111.jpg"));
                    byte[] buf = new byte[1024];
                    int len = 0;
                    while ((len = is.read(buf))!=-1){
                        fos.write(buf,0,len);
                        fos.flush();
                    }
                    fos.close();
                    is.close();
                }
            }
        });
    }
}
