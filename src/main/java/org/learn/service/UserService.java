package org.learn.service;

import org.learn.entity.User;
import org.learn.vo.UserAddVO;

import java.util.List;
import java.util.Optional;

public interface UserService {
    Optional<User> addUser(UserAddVO userAddVO);
    Optional<User> findUser(String username, String password);
    List<User> findUsersByIds(List<Long> userIds);
    void updateUser(User user);
    void updAvatar(Long userId, String filePath);
}
