package top.woilanlan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import top.woilanlan.service.BookService;

@Controller
public class HelloController {
    @Autowired
    BookService bookService;

    @GetMapping("/index")
    public String index(Model model){
        model.addAttribute("bs",bookService.getAllBooks());
        return "index";
    }
}
