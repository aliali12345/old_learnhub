package org.learn.repo;

import org.learn.entity.LearnUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LearnUserRepo extends JpaRepository<LearnUser,Long> {
}
