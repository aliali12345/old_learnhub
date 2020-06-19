package org.learn.controller;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Ehcache;
import net.sf.ehcache.Element;
import org.hibernate.mapping.Array;
import org.learn.entity.Learnhub;
import org.learn.enums.ConstEnum;
import org.learn.enums.MessageEnum;
import org.learn.pojo.Result;
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

    @RequestMapping(value = "/like",method = RequestMethod.POST)
    @ResponseBody
    public Result like(Long learnId){
        CacheManager cacheManager = CacheManager.getInstance();
        Cache old = cacheManager.getCache(ConstEnum.SPACE_LIKE.getValue());
        Long id = requestUtil.getUser().getId();
        List<Long> likeUserId = null;
        if (old == null){
            Ehcache cache = new Cache(ConstEnum.SPACE_LIKE.getValue(), 5000, true, true,0,0);
            likeUserId = new ArrayList<>(1);
            likeUserId.add(id);
            Element element = new Element(learnId,likeUserId);
            cache.put(element);
        }else {
            Element element = old.get(learnId);
            likeUserId = (List<Long>)element.getObjectValue();
            if (likeUserId.contains(id)) {
                likeUserId.remove(id);
            }else{
                likeUserId.add(id);
            }
            element = new Element(learnId,likeUserId);
            old.put(element,true);
        }

        return new Result(MessageEnum.SUCCESS,likeUserId.size());
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
