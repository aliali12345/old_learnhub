package org.learn.controller;

import org.learn.entity.User;
import org.learn.enums.ConstEnum;
import org.learn.enums.MessageEnum;
import org.learn.pojo.Result;
import org.learn.utils.FileUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

/**
 * 文件相关操作
 */
@Controller
@RequestMapping("/file")
public class FileController {
    @RequestMapping(value = "/upload",method = RequestMethod.POST)
    public Result upload(MultipartFile multipartFile, HttpServletRequest request) {
        User user = (User)request.getSession().getAttribute(ConstEnum.USER_INFO.getValue());
        String filePath = FileUtil.uploadFile(multipartFile, user.getEmail());
        return new Result(MessageEnum.SUCCESS);
    }
}
