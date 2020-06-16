package org.learn.service.impl;

import org.learn.entity.LearnUser;
import org.learn.repo.LearnUserRepo;
import org.learn.service.LearnUserService;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

public class LearnUserServiceImpl implements LearnUserService {
    @Resource LearnUserRepo learnUserRepo;

    @Override
    public Optional<LearnUser> addLearnUser(LearnUser learnuser) {
        return Optional.of(learnUserRepo.saveAndFlush(learnuser));
    }

    @Override
    public List<LearnUser> findLearnUser() {
        return learnUserRepo.findAll();
    }
}
