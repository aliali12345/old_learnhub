package org.learn.service;

import org.learn.entity.LearnUser;
import org.learn.vo.LearnUserVO;

import java.util.List;

public interface LearnUserService {
    List<LearnUser> findLearnUser();
    void add(LearnUser learnUser);
    LearnUserVO findUserInfo(Long learnId);
}
