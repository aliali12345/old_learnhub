package org.learn.filter;

import org.learn.enums.ConstEnum;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.annotation.Order;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(urlPatterns="/*")
@Order(1)
public class SessionFilter implements Filter {

    @Value(value = "${FilterURI}")
    private String filterURI;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("filter init");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletResponse response = (HttpServletResponse)servletResponse;
        HttpServletRequest request = (HttpServletRequest)servletRequest;
        HttpSession httpSession = request.getSession();
        // 需要登录的请求 没登陆直接跳转到登录页面
        if (request.getRequestURI().contains(filterURI) && httpSession.getAttribute(ConstEnum.USER_INFO.name()) == null){
            response.sendRedirect("/login");
        }
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {
        System.out.println("filter destroy");
    }
}
