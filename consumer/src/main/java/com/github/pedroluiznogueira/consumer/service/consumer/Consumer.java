package com.github.pedroluiznogueira.consumer.service.consumer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pedroluiznogueira.consumer.entity.User;
import com.github.pedroluiznogueira.consumer.entity.dto.UserDto;
import com.github.pedroluiznogueira.consumer.service.UserService;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class Consumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(Consumer.class);

    private final ModelMapper modelMapper;

    private final ObjectMapper objectMapper;

    private final UserService userService;

    @Autowired
    public Consumer(ModelMapper modelMapper, ObjectMapper objectMapper, UserService userService) {
        this.modelMapper = modelMapper;
        this.objectMapper = objectMapper;
        this.userService = userService;
    }

    @KafkaListener(topics = "test_topic", groupId = "myIdGroup")
    public void consumeMessage(String message) throws JsonProcessingException {
        UserDto userDto = objectMapper.readValue(message, UserDto.class);
        LOGGER.info(String.format("Message consumed %s", userDto));

        User user = modelMapper.map(userDto, User.class);
        userService.persistUser(user);
    }

}
