package org.learn.controller;

import org.learn.enums.MessageEnum;
import org.learn.exception.CustomizeException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;

@Controller
public class PageController {
    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String index(){
        return root_page("learnhub");
    }

    @RequestMapping(value = "/{pageName}",method = RequestMethod.GET)
    public String root_page(@PathVariable(value = "pageName")String pageName){
        return pageName;
    }

    @RequestMapping(value = "/group/{pageName}",method = RequestMethod.GET)
    public String group_page(@PathVariable(value = "pageName")String pageName){
        return "group/"+pageName;
    }

    @RequestMapping(value = "/learnhub/{pageName}",method = RequestMethod.GET)
    public String learnhub_page(@PathVariable(value = "pageName")String pageName){
        return "/learnhub/"+pageName;
    }


    @RequestMapping(value = "/profile/{pageName}",method = RequestMethod.GET)
    public String profile_page(@PathVariable(value = "pageName")String pageName) {
        return "/profile/" + pageName;
    }

    @RequestMapping(value = "/article/{pageName}",method = RequestMethod.GET)
    public String article_page(@PathVariable(value = "pageName")String pageName) {
        return "/article/" + pageName;
    }

    @RequestMapping(value = "/favicon.ico",method = RequestMethod.GET)
    public void ico (HttpServletResponse response) throws IOException {
        URL url = PageController.class.getResource("/static/favicon.ico");
        if (url != null) {
            FileInputStream fileInputStream = new FileInputStream(url.getFile());
            byte[] b = new byte[fileInputStream.available()];
            int readSize = fileInputStream.read(b);
            if (readSize > 0) {
                ServletOutputStream outputStream = response.getOutputStream();
                outputStream.write(b);
                outputStream.flush();
                outputStream.close();
            }
        }else {
            throw new CustomizeException(MessageEnum.FILE_NOT_FOUND.getMsg());
        }
    }
}
