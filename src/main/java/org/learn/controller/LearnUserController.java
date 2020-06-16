package org.learn.controller;

import org.learn.entity.LearnUser;
import org.learn.enums.MessageEnum;
import org.learn.pojo.Result;
import org.learn.service.LearnUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Calendar;
import java.util.List;

@RequestMapping("/learnuser")
public class LearnUserController {

    @Autowired
    private LearnUserService learnUserService;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addLearnUser(LearnUser learnUser){
        System.out.println("----------------");
        learnUserService.addLearnUser(learnUser);
        return "add learnuser";
    }

    @RequestMapping(value = "/find", method = RequestMethod.POST)
    public String findLearnUser(HttpServletRequest request, HttpServletResponse response) {
        List<LearnUser> learnuser = learnUserService.findLearnUser();
        System.out.println(learnuser);
        request.setAttribute("learnuser", learnuser);
        return "learnhub/members";
    }

    @RequestMapping(value = "/join",method = RequestMethod.POST)
    public Result join(@RequestBody @Validated LearnUser user) {
        user.setJoin_time(Calendar.getInstance().getTime().toString());
        learnUserService.add(user);
        return new Result(MessageEnum.SUCCESS);
    }
}
