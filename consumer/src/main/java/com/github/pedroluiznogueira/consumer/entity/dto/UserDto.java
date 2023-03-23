package com.github.pedroluiznogueira.consumer.entity.dto;

import lombok.Data;

import java.util.Date;

@Data
public class UserDto {

    private String name;

    private String lastName;

    private Date registration;
}
