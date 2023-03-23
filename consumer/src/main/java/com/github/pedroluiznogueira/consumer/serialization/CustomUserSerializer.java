package com.github.pedroluiznogueira.consumer.serialization;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.github.pedroluiznogueira.consumer.entity.User;

import java.io.IOException;
import java.text.SimpleDateFormat;

public class CustomUserSerializer extends JsonSerializer<User> {

    private final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");

    @Override
    public void serialize(User user, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {

        jsonGenerator.writeStartObject();
        jsonGenerator.writeObjectFieldStart("User");
        jsonGenerator.writeObjectField("name", user.getName());
        jsonGenerator.writeObjectField("lastName", user.getLastName());
        jsonGenerator.writeFieldName("registration");
        jsonGenerator.writeString(simpleDateFormat.format(user.getRegistration()));
        jsonGenerator.writeEndObject();
    }
}
