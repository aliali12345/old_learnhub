package org.learn.controller;

import org.learn.enums.ConstEnum;
import org.learn.enums.MessageEnum;
import org.learn.pojo.Result;
import org.learn.service.UserService;
import org.learn.entity.User;
import org.learn.utils.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

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

    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public Result register(@RequestBody User user, HttpServletResponse response) throws IOException {
        Optional<User> optional = userService.addUser(user);
        if (optional.isPresent()){
            response.sendRedirect("/login");
        }
        return new Result(MessageEnum.LOGIN_FAIL);
    }

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ResponseBody
    public Result login(@RequestParam(value = "username") String username, @RequestParam(value = "password") String password, HttpServletRequest request, HttpServletResponse response) throws IOException {
        Optional<User> user = userService.findUser(username, password);
        if (user.isPresent()){
            HttpSession httpSession = request.getSession();
            httpSession.setAttribute(ConstEnum.USER_INFO.getValue(), user.get());
            response.sendRedirect("/learnhub");
        }
        return new Result(MessageEnum.LOGIN_FAIL);
    }

    @RequestMapping(value = "/upload",method = RequestMethod.POST)
    @ResponseBody
    public Result photo(@RequestParam("file")MultipartFile multipartFile, HttpServletRequest request){
        User user = (User)request.getSession().getAttribute(ConstEnum.USER_INFO.getValue());
        String filePath = FileUtil.uploadFile(multipartFile, user.getEmail());
        user.setAvatar(filePath);
        userService.updateUser(user);
        return new Result(MessageEnum.SUCCESS,filePath);
    }
}
