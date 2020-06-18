package org.learn.controller;

import org.learn.enums.MessageEnum;
import org.learn.exception.CustomizeException;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.net.URL;

@Controller
@ControllerAdvice
public class ExceptionController implements ErrorController {
    /**
     * 已知异常
     */
    @ExceptionHandler(CustomizeException.class)
    @ResponseBody
    public String checkedException(Exception ex){
        return ex.getMessage();
    }

    /**
     * 未知异常
     * @return
     */
    @ExceptionHandler(Exception.class)
    public String unknownException() {
        URL url = ExceptionController.class.getResource("/templates/500.html");
        if (url != null){
            return "/500";
        }
        throw new CustomizeException(MessageEnum.FAIL);
    }

    @RequestMapping(value = "/error")
    @ResponseBody
    public String error() {
        throw new CustomizeException(MessageEnum.PAGE_NOT_FOUND);
    }

    /**
     * 有404页面则进入404页面 无404页面则返回json信息
     * @return
     */
    @RequestMapping(value = "/error",produces = {"text/html"})
    public String errorHtml(){
        URL url = ExceptionController.class.getResource("/templates/404.html");
        if (url != null){
            return "/404";
        }
        return error();
    }

    @Override
    public String getErrorPath() {
        return null;
    }
}
