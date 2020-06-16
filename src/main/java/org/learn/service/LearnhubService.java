package org.learn.service;

import org.learn.entity.Learnhub;
import org.learn.entity.User;

import java.util.List;
import java.util.Optional;

public interface LearnhubService {
    Optional<Learnhub> addLearnhub(Learnhub learnhub);
    List<Learnhub> findLearnhub();
    void deleteLearnhub(long id);
    Optional<Learnhub> updateLearnhub(Learnhub learnhub);
}
