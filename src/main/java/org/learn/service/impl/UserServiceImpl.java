package org.learn.service.impl;

import org.learn.entity.User;
import org.learn.repo.UserRepo;
import org.learn.service.UserService;
import org.learn.vo.UserAddVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserRepo userRepo;


    @Override
    public Optional<User> addUser(UserAddVO userAddVO) {
        User user = new User();
        user.setUsername(userAddVO.getUsername());
        user.setPassword(userAddVO.getPassword());
        return Optional.of(userRepo.saveAndFlush(user));
    }

    @Override
    public Optional<User> findUser(String username, String password) {
       return userRepo.findByUsernameAndPassword(username, password);
    }

    @Override
    public List<User> findUsersByIds(List<Long> userIds) {
        return userRepo.findAllById(userIds);
    }

    @Override
    public void updateUser(User user) {
        userRepo.saveAndFlush(user);
    }


}
