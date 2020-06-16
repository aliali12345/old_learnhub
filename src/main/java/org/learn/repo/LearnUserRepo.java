package org.learn.repo;

import org.learn.entity.LearnUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LearnUserRepo extends JpaRepository<LearnUser, Long> {
}
