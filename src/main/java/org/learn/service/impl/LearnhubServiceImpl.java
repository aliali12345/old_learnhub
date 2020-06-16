package org.learn.service.impl;

import org.learn.entity.Learnhub;
import org.learn.repo.LearnhubRepo;
import org.learn.service.LearnhubService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

@Service
public class LearnhubServiceImpl implements LearnhubService {

    @Resource
    private LearnhubRepo learnhubRepo;

    @Override
    public Optional<Learnhub> addLearnhub(Learnhub learnhub) {
        return Optional.of(learnhubRepo.saveAndFlush(learnhub));
    }

    @Override
    public List<Learnhub> findLearnhub() {
        return learnhubRepo.findAll();
    }

    @Override
    public void deleteLearnhub(long id) {
        learnhubRepo.deleteById(id);
    }

    @Override
    public Optional<Learnhub> updateLearnhub(Learnhub learnhub) {
        return Optional.of(learnhubRepo.saveAndFlush(learnhub));
    }


}
