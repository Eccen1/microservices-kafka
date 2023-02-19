package com.consumer.serialization;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.consumer.entity.User;

import java.io.IOException;

public class CustomUserSerializer extends JsonSerializer<User> {

    @Override
    public void serialize(User user, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {

        jsonGenerator.writeStartObject();
        jsonGenerator.writeObjectFieldStart("User");
        jsonGenerator.writeObjectField("name", user.getName());
        jsonGenerator.writeObjectField("lastName", user.getLastName());
        jsonGenerator.writeEndObject();
    }
}
