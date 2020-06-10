package org.learn.controller;

import org.learn.enums.Message;
import org.learn.exception.CustomizeException;

import org.learn.pojo.Result;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URL;

@RestControllerAdvice
public class ExceptionController {
    /**
     * 已知异常
     */
    @ExceptionHandler(CustomizeException.class)
    public void checkedException(Exception ex){

    }

    /**
     * 未知错误
     * @param response
     * @return
     */
    @ExceptionHandler(Exception.class)
    public Result error(HttpServletResponse response, Exception ex) throws IOException {
        URL url = ExceptionController.class.getResource("/500.html");
        if (url != null){
            response.sendRedirect("/500");
        }
        return new Result(Message.FAIL.setMsg(ex.getMessage()));
    }
}
