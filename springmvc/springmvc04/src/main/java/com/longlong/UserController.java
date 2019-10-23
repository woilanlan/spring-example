package com.longlong;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.UUID;

/**
 * 集合类型
 */
@Controller
public class UserController {

    @GetMapping("/reg")
    public String reg(){
        return "reg";
    }

//    直接使用数组接收参数
    @PostMapping("/doReg1")
    @ResponseBody
    public void doReg1(String username,String password,String[] favorites){
        System.out.println(username+">>>"+password+">>>"+ Arrays.toString(favorites));
    }

    /*
    这里的参数类型，只能使用数组，不能使用集合
    如果非要用集合，可以自定义参数类型转换
     */
    @PostMapping("/doReg2")
    @ResponseBody
    public void doReg2(String username, String password, ArrayList<String> favorites){
        System.out.println(username+">>>"+password+">>>"+ favorites);
    }

    /*
    如果想要使用集合去接收参数，也可以将集合放到一个包装类中，
    集合中可以放对象，此时表单的写法：books[0].name

    Map类型也要使用一个对象包装起来,此时表单的写法为 map['address']

    文件上传：单独写一个接口处理文件上传，如果没有上传文件，则会保存失败。
     */
    @PostMapping("/doReg")
    @ResponseBody
    public void doReg(User user, MultipartFile userface, HttpServletRequest req) throws IOException {
        System.out.println(user);

//        userface.transferTo(new File("D:\\uploadFiles\\","123.png"));
        String realPath = req.getSession().getServletContext().getRealPath("/img");     //获取应用所在路径
        SimpleDateFormat sdf = new SimpleDateFormat("/yyyy/MM/dd/");    // 日期前后加斜杠
        String format = sdf.format(new Date());
        File folder = new File(realPath + format);  //文件夹路径
        if(!folder.exists()){
            folder.mkdirs();
        }
        //避免文件重名或包含空格保存失败
        String oldName = userface.getOriginalFilename();    //获取原来文件名称
        String uuid = UUID.randomUUID().toString().replace("-", "");    //获取 uuid
        String suffix = oldName.substring(oldName.lastIndexOf("."), oldName.length());  //获取文件后缀
        String newName = uuid + suffix;
        userface.transferTo(new File(folder,newName));  //保存文件

        //文件访问路径
        String url = req.getScheme() + "://" + req.getServerName() + ":" + req.getServerPort() +"/"+ req.getContextPath()+ "/img" + format + newName;
        System.out.println(url);
    }

}
