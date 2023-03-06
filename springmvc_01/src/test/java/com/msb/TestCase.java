package com.msb;

import com.example.pojo.Pet;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

public class TestCase {
    @Test
    public void testA() throws JsonProcessingException {
        Pet pet = new Pet("Tom","cat");
        ObjectMapper objectMapper = new ObjectMapper();
        String value = objectMapper.writeValueAsString(pet);
        System.out.println(value);
    }
}
