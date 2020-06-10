package org.learn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;

@Controller
public class PageController {
    @RequestMapping("/")
    public String index(){
        return root_page("learnhub");
    }

    @RequestMapping("/favicon.ico")
    public void ico (HttpServletResponse response) throws IOException {
        URL url = PageController.class.getResource("/static/favicon.ico");
        FileInputStream fileInputStream = new FileInputStream(url.getFile());
        byte[] b = new byte[fileInputStream.available()];
        fileInputStream.read(b);
        ServletOutputStream outputStream = response.getOutputStream();
        outputStream.write(b);
        outputStream.flush();
        outputStream.close();
    }

    @RequestMapping("/{pageName}")
    public String root_page(@PathVariable(value = "pageName")String pageName){
        return pageName;
    }

    @RequestMapping("/group/{pageName}")
    public String group_page(@PathVariable(value = "pageName")String pageName){
        return "group/"+pageName;
    }

    @RequestMapping("/learnhub/{pageName}")
    public String learnhub_page(@PathVariable(value = "pageName")String pageName){
        return "/learnhub/"+pageName;
    }

    @RequestMapping("/profile/{pageName}")
    public String profile_page(@PathVariable(value = "pageName")String pageName){
        return "/profile/"+pageName;
    }
}
