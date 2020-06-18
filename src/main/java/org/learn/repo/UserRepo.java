package org.learn.repo;

import org.learn.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User,Long> {
    Optional<User> findByUsernameAndPassword(String username, String password);
    @Query(value = "UPDATE User SET avatar = ?2 WHERE id = ?1")
    @Modifying
    void updateAvatar(Long userId, String filePath);
}
