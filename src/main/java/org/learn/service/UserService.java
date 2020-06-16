package org.learn.service;

import org.learn.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    Optional<User> addUser(User user);
    Optional<User> findUser(String username, String password);
    List<User> findUsersByIds(List<Long> userIds);
    void updateUser(User user);
}
