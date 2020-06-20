package org.learn.controller;

import org.hibernate.mapping.Array;
import org.learn.entity.Learnhub;
import org.learn.enums.ConstEnum;
import org.learn.enums.MessageEnum;
import org.learn.pojo.Result;
import org.learn.service.LearnUserService;
import org.learn.service.LearnhubService;
import org.learn.utils.FileUtil;
import org.learn.utils.HttpRequestUtil;
import org.learn.vo.LearnhubAddVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/learnhub")
public class LearnhubController {

    @Autowired
    LearnhubService learnhubService;
    LearnUserService learnUserService;

    @Value(value = "${UploadPath}") String uploadPath;
    @Autowired
    HttpRequestUtil requestUtil;

    @RequestMapping(value = "/adda",method = RequestMethod.POST)
    @ResponseBody
    public String addLearnhubs(LearnhubAddVO learnhubAddVO){
        MultipartFile file = learnhubAddVO.getFile();
        String filePath = FileUtil.uploadFile(file, uploadPath, ConstEnum.LEARN_HUB_FILE_DIR.getValue());
        Learnhub learnhub = new Learnhub();
        BeanUtils.copyProperties(learnhubAddVO,learnhub);
        learnhub.setAvatar(filePath);
        learnhub.setAdmin(requestUtil.getUser().getId());
        learnhubService.addLearnhub(learnhub);
        return "/learnhub";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addLearnhub(Learnhub learnhub){
        System.out.println(learnhub);
        Optional<Learnhub> learnhubs = learnhubService.addLearnhub(learnhub);
        return "/learnhub";
    }
    
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    public String deleteLearnhub(long id){
        learnhubService.deleteLearnhub(id);
        System.out.println("delete");
        return "/learnhub";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    public String updateLearnhub(Learnhub learnhub){
        System.out.println(learnhub);
        learnhubService.updateLearnhub(learnhub);
        return "/learnhub";
    }
}
