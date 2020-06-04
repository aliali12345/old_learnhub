package main.org.learn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Demo {
    @RequestMapping("/page/{pageName}")
    public String gotoPage(@PathVariable(value = "pageName")String pageName){
        return pageName;
    }
}
