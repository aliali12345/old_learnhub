package org.learn.service.impl;

import org.learn.entity.User;
import org.learn.repo.UserRepo;
import org.learn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserRepo userRepo;


    @Override
    public Optional<User> addUser(User user) {
        return Optional.of(userRepo.saveAndFlush(user));
    }

    @Override
    public Optional<User> findUser(String username, String password) {
       return userRepo.findByUsernameAndPassword(username, password);
    }


}
