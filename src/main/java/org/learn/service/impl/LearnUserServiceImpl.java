package org.learn.service.impl;

import org.learn.entity.LearnUser;
import org.learn.entity.Learnhub;
import org.learn.entity.User;
import org.learn.repo.LearnUserRepo;
import org.learn.repo.LearnhubRepo;
import org.learn.repo.UserRepo;
import org.learn.service.LearnUserService;
import org.learn.vo.LearnUserVO;

import javax.annotation.Resource;
import java.util.*;

public class LearnUserServiceImpl implements LearnUserService {
    @Resource LearnUserRepo learnUserRepo;
    @Resource
    private UserRepo userRepo;
    @Resource
    private LearnhubRepo learnhubRepo;

    @Override
    public List<LearnUser> findLearnUser() {
        return learnUserRepo.findAll();
    }

    public void add(LearnUser learnUser) {
        learnUserRepo.saveAndFlush(learnUser);
    }

    @Override
    public LearnUserVO findUserInfo(Long learnId) {
        LearnUserVO learnUserVO = new LearnUserVO();
        List<LearnUserVO.UserInfo> userInfos = new ArrayList<>();
        Optional<Learnhub> optional = learnhubRepo.findById(learnId);
        if (optional.isPresent()){
            Learnhub learnhub = optional.get();
            Long id = learnhub.getId();
            List<LearnUser> learnUsers = learnUserRepo.findAllByLearnId(id);
            List<Long> userIds = new ArrayList<>();
            Map<Long,String> map = new HashMap<>();
            learnUsers.forEach((lu) -> {map.put(lu.getUserId(),lu.getJoinTime());userIds.add(lu.getUserId());});
            List<User> users = userRepo.findAllById(userIds);
            users.forEach((u) -> {
                LearnUserVO.UserInfo userInfo = new LearnUserVO.UserInfo();
                userInfo.setUserId(u.getId());
                userInfo.setUsername(u.getUsername());
                userInfo.setAvatar(u.getAvatar());
                userInfo.setJoinTime(map.get(u.getId()));
                userInfos.add(userInfo);
            });
            learnUserVO.setLearnId(learnId);
            learnUserVO.setName(learnhub.getName());
            learnUserVO.setMemberCount(users.size());
        }

        return learnUserVO;
    }
}
