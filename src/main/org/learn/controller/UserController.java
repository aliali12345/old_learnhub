package main.org.learn.controller;

import main.org.learn.entity.User;
import main.org.learn.service.UserService;
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
    public String register(@RequestBody User user){
        userService.addUser(user);
        return "redirect:login";
    }

    @RequestMapping("login")
//    @ResponseBody
    public void login(@RequestParam(value = "username") String username, @RequestParam(value = "password") String password, HttpServletRequest request, HttpServletResponse response) {
        Optional<User> user = userService.findUser(username, password);
        if (user.isPresent()){
            HttpSession httpSession = request.getSession();
            httpSession.setAttribute("username", user.get().getUsername());
            httpSession.setMaxInactiveInterval(60);
            try {
                response.sendRedirect("/page/learnhub");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
