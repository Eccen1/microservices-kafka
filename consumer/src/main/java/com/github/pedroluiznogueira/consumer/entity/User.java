package com.github.pedroluiznogueira.consumer.entity;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.github.pedroluiznogueira.consumer.serialization.CustomUserSerializer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@JsonSerialize(using = CustomUserSerializer.class)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String lastName;

    private Date registration;
}
