package com.github.pedroluiznogueira.producer.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.github.pedroluiznogueira.producer.entity.User;
import com.github.pedroluiznogueira.producer.service.producer.Producer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UserService {

    private final Producer producer;

    @Autowired
    public UserService(Producer producer) {
        this.producer = producer;
    }

    public void createUser(User user) {
        producer.sendMessage(user);
    }
}
