package org.learn.repo;

import org.learn.entity.LearnUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LearnUserRepo extends JpaRepository<LearnUser,Long> {
    List<LearnUser> findAllByLearnId(long id);
}
