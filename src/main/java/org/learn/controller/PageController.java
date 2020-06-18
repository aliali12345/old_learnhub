package org.learn.controller;

import org.learn.utils.FileUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

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
        return "learnhub/"+pageName;
    }


    @RequestMapping(value = "/profile/{pageName}",method = RequestMethod.GET)
    public String profile_page(@PathVariable(value = "pageName")String pageName) {
        return "profile/" + pageName;
    }

    @RequestMapping(value = "/article/{pageName}",method = RequestMethod.GET)
    public String article_page(@PathVariable(value = "pageName")String pageName) {
        return "article/" + pageName;
    }

    @RequestMapping(value = "/favicon.ico",method = RequestMethod.GET)
    public void ico (HttpServletResponse response) throws IOException {
        FileUtil.outPutFile(response, FileUtil.getUploadRootPath(),"static/favicon.ico");
    }
}
