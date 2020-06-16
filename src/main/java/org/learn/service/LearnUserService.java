package org.learn.service;

import org.learn.entity.LearnUser;
import java.util.List;
import java.util.Optional;

public interface LearnUserService {
    Optional<LearnUser> addLearnUser(LearnUser learnuser);
    List<LearnUser> findLearnUser();
    void add(LearnUser learnUser);
}
