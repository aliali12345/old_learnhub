package org.learn.service;

import org.learn.entity.User;

import java.util.Optional;

public interface UserService {
    void addUser(User user);
    Optional<User> findUser(String username, String password);
}
