package com.github.pedroluiznogueira.consumer.repository;

import com.github.pedroluiznogueira.consumer.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
