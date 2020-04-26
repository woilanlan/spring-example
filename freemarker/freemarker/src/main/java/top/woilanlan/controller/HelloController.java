package top.woilanlan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import top.woilanlan.Book;

import java.util.*;

@Controller
public class HelloController {

    @GetMapping("/hello")
    public String hello(Model model) {
        model.addAttribute("name","张三");
        model.addAttribute("age",99);
        model.addAttribute("birthday",new Date());
        model.addAttribute("enabled",true);

        List<String> bs = new ArrayList<String>();
        for (int i = 0; i < 5; i++) {
            bs.add("三国演义："+i);
        }
        model.addAttribute("bs",bs);

        Book book = new Book(1,"红楼梦","曹雪芹");
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("name", book.getName());
        map.put("author",book.getAuthor());
        map.put("id",book.getId());
        Book book2 = new Book(2,"西游记","吴承恩");
        map.put("book2",book2);
        model.addAttribute("books",map);
        return "index";
    }

    @GetMapping("/index2")
    public String index2(Model model) {
        model.addAttribute("name","张三");
        model.addAttribute("hello","hello freemarker ONE");

        List<String> bs = new ArrayList<String>();
        for (int i = 0; i < 3; i++) {
            bs.add("三国演义："+i);
        }
        model.addAttribute("bs",bs);
        List<String> bs2 = new ArrayList<String>();
        for (int i = 0; i < 3; i++) {
            bs2.add("水浒传："+i);
        }
        model.addAttribute("bs2",bs2);

        model.addAttribute("myhtml","<h1>hello freemarker</h1>");

        model.addAttribute("mylist",null);
        model.addAttribute("var1",null);
        return "index2";
    }

    @GetMapping("/index3")
    public String index3(Model model) {
        List<Integer> genders = new ArrayList<Integer>();
        genders.add(1);
        genders.add(0);
        genders.add(-1);
        model.addAttribute("gs",genders);

        model.addAttribute("myhtml","<h1>hello freemarker</h1>");
        model.addAttribute("myhtml2","<h2>hello freemarker</h2>");
        return "index3";
    }

    @GetMapping("/01")
    public String index(Model model) {

        return "01";
    }
}
