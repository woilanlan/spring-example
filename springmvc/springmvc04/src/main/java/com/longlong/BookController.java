package com.longlong;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class BookController {

    @GetMapping("/book")
    @ResponseBody
    public void addBook(@Validated Book book, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            //如果Book校验失败
            List<ObjectError> allErrors = bindingResult.getAllErrors();
            for (ObjectError error : allErrors) {
                System.out.println(error.getDefaultMessage());
            }
        }
        System.out.println(book);
    }
}
