package org.learn.controller;

import org.learn.entity.LearnUser;
import org.learn.enums.MessageEnum;
import org.learn.pojo.Result;
import org.learn.service.LearnUserService;
import org.learn.vo.LearnUserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.Calendar;

@RequestMapping("/learnuser")
public class LearnUserController {

    @Autowired
    private LearnUserService learnUserService;

    @RequestMapping(value = "/find", method = RequestMethod.POST)
    public String findLearnUser(@RequestParam(value = "learnId") Long learnId, HttpServletRequest request) {
        LearnUserVO learnuser = learnUserService.findUserInfo(learnId);
        request.setAttribute("learnuser", learnuser);
        return "learnhub/members";
    }

    @RequestMapping(value = "/join",method = RequestMethod.POST)
    public Result join(@RequestBody @Validated LearnUser user) {
        user.setJoinTime(Calendar.getInstance().getTime().toString());
        learnUserService.add(user);
        return new Result(MessageEnum.SUCCESS);
    }
}
