package org.learn.controller;

import org.learn.entity.Learnhub;
import org.learn.enums.ConstEnum;
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
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequestMapping("/learnhub")
public class LearnhubController {

    @Autowired
    LearnhubService learnhubService;
    @Value(value = "${UploadPath}") String uploadPath;
    @Autowired
    HttpRequestUtil requestUtil;

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    @ResponseBody
    public String addLearnhub(LearnhubAddVO learnhubAddVO){
        MultipartFile file = learnhubAddVO.getFile();
        String filePath = FileUtil.uploadFile(file, uploadPath, ConstEnum.LEARN_HUB_FILE_DIR.getValue());
        Learnhub learnhub = new Learnhub();
        BeanUtils.copyProperties(learnhubAddVO,learnhub);
        learnhub.setAvatar(filePath);
        learnhub.setAdmin(requestUtil.getUser().getId());
        learnhubService.addLearnhub(learnhub);
        return "/learnhub";
    }

    @RequestMapping(value = "/find", method = RequestMethod.POST)
    @ResponseBody
    public String findLearnhub(HttpServletRequest request){
        List<Learnhub> learnhub = learnhubService.findLearnhub();
        request.setAttribute("learnhub", learnhub);
        System.out.println(learnhub);
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
