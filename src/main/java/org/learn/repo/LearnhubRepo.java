package org.learn.repo;

import org.learn.entity.Learnhub;
import org.springframework.data.jpa.repository.JpaRepository;


public interface LearnhubRepo extends JpaRepository<Learnhub, Long> {
}
