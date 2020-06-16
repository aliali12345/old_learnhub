package org.learn.controller;

import org.learn.entity.LearnUser;
import org.learn.service.LearnUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RequestMapping("/learnuser")
public class LearnUserController {

    @Autowired
    LearnUserService learnuserService;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addLearnUser(LearnUser learnUser){
        System.out.println("----------------");
        learnuserService.addLearnUser(learnUser);
        return "add learnuser";
    }

    @RequestMapping(value = "/find", method = RequestMethod.POST)
    public String findLearnUser(HttpServletRequest request, HttpServletResponse response){
        List<LearnUser> learnuser = learnuserService.findLearnUser();
        System.out.println(learnuser);
        request.setAttribute("learnuser",learnuser);
        return "find learnuser";
    }
}
