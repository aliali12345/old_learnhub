package main.org.learn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {
    @RequestMapping("/")
    public String index(){
        return "learnhub";
    }

    @RequestMapping("/learnhub")
    public String learnhub(){
        return "learnhub";
    }

    @RequestMapping("/group")
    public String group(){
        return "group";
    }

    @RequestMapping("/login")
    public String login(){
        return "login";
    }

    @RequestMapping("/forum")
    public String forum(){
        return "forum";
    }

    @RequestMapping("/register")
    public String register(){
        return "register";
    }

    @RequestMapping("/profile")
    public String profile(){
        return "profile";
    }

    @RequestMapping("/resource")
    public String resource(){
        return "resource";
    }

    @RequestMapping("/group/index")
    public String group_index(){
        return "group/index";
    }

    @RequestMapping("/learnhub/index")
    public String learnhub_index(){
        return "/learnhub/index";
    }

    @RequestMapping("/learnhub/issues")
    public String learnhub_issues(){
        return "/learnhub/issues";
    }
}
