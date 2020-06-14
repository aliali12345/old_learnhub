package org.learn.controller;

import org.learn.enums.Message;
import org.learn.exception.CustomizeException;

import org.learn.pojo.Result;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
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
     * 未知错误
     * @param response
     * @return
     */
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Result error(HttpServletResponse response, Exception ex) throws IOException {
        URL url = ExceptionController.class.getResource("/500.html");
        if (url != null){
            response.sendRedirect("/500");
        }
        return new Result(Message.FAIL.setMsg(ex.getMessage()));
    }

    @RequestMapping(value = "/error")
    @ResponseBody
    public String error() {
        throw new CustomizeException(Message.PAGE_NOT_FOUND);
    }

    /**
     * 有404页面则进入404页面 无404页面则返回json信息
     * @param response
     * @return
     */
    @RequestMapping(value = "/error",produces = {"text/html"})
    public String errorHtml(HttpServletResponse response){
        URL url = ExceptionController.class.getResource("/404.html");
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
