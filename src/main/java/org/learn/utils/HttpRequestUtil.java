package org.learn.utils;

import org.learn.enums.ConstEnum;
import org.learn.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Component
public class HttpRequestUtil {
    @Autowired
    private HttpServletRequest request;

    public UserVO getUser(){
        HttpSession session = request.getSession();
        return (UserVO)session.getAttribute(ConstEnum.USER_INFO.getValue());
    }
}
