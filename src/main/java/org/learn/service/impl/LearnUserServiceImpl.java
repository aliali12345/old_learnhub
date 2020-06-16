package org.learn.service.impl;

import org.learn.entity.LearnUser;
import org.learn.repo.LearnUserRepo;
import org.learn.service.LearnUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LearnUserServiceImpl implements LearnUserService {

    @Autowired
    private LearnUserRepo learnUserRepo;

    @Override
    public void add(LearnUser learnUser) {
        learnUserRepo.saveAndFlush(learnUser);
    }
}
