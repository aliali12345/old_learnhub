package org.learn.controller;

import org.learn.enums.ConstEnum;
import org.learn.enums.Message;
import org.learn.pojo.Result;
import org.learn.service.UserService;
import org.learn.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Optional;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/register")
    public Result register(@RequestBody User user, HttpServletResponse response) throws IOException {
        Optional<User> optional = userService.addUser(user);
        if (optional.isPresent()){
            response.sendRedirect("/login");
        }
        return new Result(Message.LOGIN_FAIL);
    }

    @RequestMapping("/login")
    @ResponseBody
    public Result login(@RequestParam(value = "username") String username, @RequestParam(value = "password") String password, HttpServletRequest request, HttpServletResponse response) throws IOException {
        Optional<User> user = userService.findUser(username, password);
        if (user.isPresent()){
            HttpSession httpSession = request.getSession();
            httpSession.setAttribute(ConstEnum.USER_INFO.name(), user.get());
            response.sendRedirect("/learnhub");
        }
        return new Result(Message.LOGIN_FAIL);
    }
}
