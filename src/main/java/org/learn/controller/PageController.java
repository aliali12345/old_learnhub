package org.learn.controller;

import org.learn.entity.LearnUser;
import org.learn.entity.Learnhub;
import org.learn.entity.User;
import org.learn.service.LearnUserService;
import org.learn.service.LearnhubService;
import org.learn.service.UserService;
import org.learn.utils.FileUtil;
import org.learn.vo.LearnUserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class PageController {
    @Autowired
    LearnhubService learnhubService;
    LearnUserService learnuserService;
    UserService userService;

    @RequestMapping(value = "login")
    public String Login(){
        return "/login";
    }

    @RequestMapping(value = "register")
    public String Register(){
        return "/register";
    }

    @RequestMapping(value = "/favicon.ico",method = RequestMethod.GET)
    public void ico (HttpServletResponse response) throws IOException {
        FileUtil.outPutFile(response, FileUtil.getUploadRootPath(),"static/favicon.ico");
    }

    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String index(){
        return "/learnhub";
    }


    @RequestMapping(value = "/learnhub", method = RequestMethod.GET)
    public String findLearnhub(HttpServletRequest request){
        List<Learnhub> learnhub = learnhubService.findLearnhub();
        System.out.println(learnhub);
        request.setAttribute("learnhub", learnhub);
        return "/learnhub";
    }

    @RequestMapping(value = "/learnhub/index", method = RequestMethod.GET)
    public String learnIndex(long id, HttpServletRequest request){
        List<Long> ids = new ArrayList<>();
        ids.add(id);
        List<Learnhub> learnhubs = learnhubService.findLearnhubById(ids);
        Learnhub learnhub = learnhubs.get(0);
        System.out.println(learnhub);
        request.setAttribute("learnhub" , learnhub);
        return "/learnhub/index";
    }

    @RequestMapping(value = "/learnhub/resource", method = RequestMethod.GET)
    public String learnResource(long id, HttpServletRequest request){
        // List<LearnResource> learnResources = learnResourceService.findAllByLearnId(id);
        // System.out.println(learnResources.get(0));
        request.setAttribute("id", id);
        return "/learnhub/resource";
    }

    @RequestMapping(value = "learnhub/members", method = RequestMethod.GET)
    public String learnuser(long id, HttpServletRequest request){
        request.setAttribute("id", id);
        return "/learnhub/members";
    }

    @RequestMapping(value = "/article/editor", method = RequestMethod.GET)
    public String ArtcleEdit(long id, HttpServletRequest request){
        request.setAttribute("id", id);
        return "/article/editor";
    }

    @RequestMapping(value = "group", method = RequestMethod.GET)
    public String Gruop(){
        return "/group";
    }

    @RequestMapping(value = "/group/index", method = RequestMethod.GET)
    public String GroupIndex(){
        return "/group/index";
    }

    @RequestMapping(value = "/group/setting")
    public String GroupSetting(){
        return "group/setting";
    }

    @RequestMapping(value = "profile/index")
    public String profile(){
        return "/profile/index";
    }

    @RequestMapping(value = "profile/integral")
    public String integiral(){
        return "/profile/intrgral";
    }

    @RequestMapping(value = "profile/password")
    public String password(){
        return "/profile/password";
    }

    @RequestMapping(value = "forum")
    public String forum(){
        return "forum";
    }
    /*


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

     */

}
