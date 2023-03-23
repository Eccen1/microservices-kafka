package com.github.pedroluiznogueira.consumer.service;

import com.github.pedroluiznogueira.consumer.entity.User;
import com.github.pedroluiznogueira.consumer.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void persistUser(User user) {
        User persistedUser = userRepository.save(user);
        log.info("User persisted {}", persistedUser);
    }

    public User getUser(Long id) {
        return userRepository.getById(id);
    }
}
