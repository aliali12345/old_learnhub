package main.org.learn.service;

import main.org.learn.entity.User;

import java.util.Optional;

public interface UserService {
    void addUser(User user);
    Optional<User> findUser(String username, String password);
}
