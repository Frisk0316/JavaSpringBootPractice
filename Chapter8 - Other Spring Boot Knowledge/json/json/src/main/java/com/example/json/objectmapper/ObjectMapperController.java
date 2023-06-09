package com.example.json.objectmapper;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class ObjectMapperController {
    
    // convert java object to json string
    @GetMapping("/convert")
    public String Convert() throws JsonProcessingException {
        User user = new User();
        user.setId(27);
        user.setName("T1_Faker");
        user.setContactEmail("hello@gmail.com");

        // convert User to json string
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonResult = objectMapper.writeValueAsString(user);

        System.out.println("json's value: " + jsonResult);

        // convert json string to User
        String json ="{" +
                    "\"id\":19," +
                    "\"name\":\"T1_Gumayusi\"," +
                    "\"age\": 20," +
                    "\"contact_email\": \"hello@test.com\"}";
        User userResult = objectMapper.readValue(json, User.class);

        System.out.println("User's id value: " + userResult.getId());
        System.out.println("User's name value: " + userResult.getName());
        System.out.println("User's contact Email: " + userResult.getContactEmail());
        return "convert success";
    }
}
