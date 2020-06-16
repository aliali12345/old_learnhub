package org.learn.controller;

import org.learn.entity.Learnhub;
import org.learn.service.LearnhubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/learnhub")
public class LearnhubController {

    @Autowired
    LearnhubService learnhubService;

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    @ResponseBody
    public String addLearnhub(Learnhub learnhub){
        System.out.println(learnhub);
        learnhubService.addLearnhub(learnhub);
        return "/learnhub";
    }

    @RequestMapping(value = "/find", method = RequestMethod.POST)
    @ResponseBody
    public String findLearnhub(HttpServletRequest request, HttpServletResponse response){
        List<Learnhub> learnhub = learnhubService.findLearnhub();
        request.setAttribute("learnhub", learnhub);
        System.out.println(learnhub);
        return "/learnhub";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    public String deleteLearnhub(long id){
        learnhubService.deleteLearnhub(id);
        System.out.println("delete");
        return "/learnhub";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    public String updateLearnhub(Learnhub learnhub){
        System.out.println(learnhub);
        learnhubService.updateLearnhub(learnhub);
        return "/learnhub";
    }
}
