package org.learn.controller;

import org.learn.entity.LearnUser;
import org.learn.enums.MessageEnum;
import org.learn.pojo.Result;
import org.learn.service.LearnUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Calendar;


@Controller
@RequestMapping("/user")
public class LearnUserController {
    @Autowired
    private LearnUserService learnUserService;

    @RequestMapping(value = "/join",method = RequestMethod.POST)
    public Result join(@RequestBody @Validated LearnUser user) {
        user.setJoin_time(Calendar.getInstance().getTime().toString());
        learnUserService.add(user);
        return new Result(MessageEnum.SUCCESS);
    }
}
