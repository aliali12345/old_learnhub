package org.learn.filter;

import org.learn.utils.FileUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.annotation.Order;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(urlPatterns = "/getFile/*")
@Order(2)
public class FileFilter implements Filter {

    @Value(value = "${UploadPath}") String uploadPath;

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        String filePath = request.getServletPath().replace("/getFile","");
        FileUtil.outPutFile(response,uploadPath, filePath);
    }
}
