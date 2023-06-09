package com.example.json.resttemplate;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@RestController
public class RestTemplateController {
    
    @GetMapping("/getForObject")
    public String getForObject() {

        RestTemplate restTemplate = new RestTemplate();

        // postxxx: 發起 post 請求
        // getxxxx: 發起 get 請求
        Student student = restTemplate.getForObject(
            "https://mocki.io/v1/785df26f-66d4-48bd-9f7f-e737a2d7b50b", 
            Student.class);

        // Result: 
        // Student's ID: 123
        // Student's name: Allen
        // Student's phone number: 0800-092-000
        System.out.println("Student's ID: " + student.getId());
        System.out.println("Student's name: " + student.getName());
        System.out.println("Student's phone number: " + student.getContactPhone());

        return "getForObject success";
    }

    @GetMapping("/getForObjectWithParam")
    public String getForObjectWithParam() {

        RestTemplate restTemplate = new RestTemplate();

        Map<String, Object> queryParamMap = new HashMap<>();

        queryParamMap.put("graduate", true);

        Student student = restTemplate.getForObject(
                "https://mocki.io/v1/77f69435-224e-4c90-b7cd-53f07bbf5604",
                Student.class,
                queryParamMap
        );

        return "getForObjectWithParam success";
    }

    @GetMapping("/getForEntity")
    public String getForEntity() {
        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<Student> studentEntity = restTemplate.getForEntity(
                "https://mocki.io/v1/b7a68eb2-f77c-43cf-bffe-8c647e9a2514",
                Student.class
        );

        System.out.println("http 狀態碼為: " + studentEntity.getStatusCode());

        Student student = studentEntity.getBody();

        System.out.println("student 的 id 值為: " + student.getId());
        System.out.println("student 的 name 值為: " + student.getName());
        System.out.println("student 的 phone 值為: " + student.getContactPhone());

        return "getForEntity success";
    }


    @GetMapping("/postForObject")
    public String postForObject() {
        RestTemplate restTemplate = new RestTemplate();

        Student studentRequestBody = new Student();
        studentRequestBody.setName("John");

        Student result = restTemplate.postForObject(
                "https://mocki.io/v1/b7a68eb2-f77c-43cf-bffe-8c647e9a2514",
                studentRequestBody,
                Student.class
        );

        return "postForObject success";
    }

    @GetMapping("/postForEntity")
    public String postForEntity() {
        RestTemplate restTemplate = new RestTemplate();

        Student studentRequestBody = new Student();
        studentRequestBody.setName("John");

        ResponseEntity<Student> responseEntity = restTemplate.postForEntity(
                "https://mocki.io/v1/b7a68eb2-f77c-43cf-bffe-8c647e9a2514",
                studentRequestBody,
                Student.class
        );

        return "postForEntity success";
    }


    @GetMapping("/exchange")
    public String exchange() {

        RestTemplate restTemplate = new RestTemplate();

        // 使用 exchange 發起 GET 請求
        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.set("header1", "123");

        HttpEntity requestEntity = new HttpEntity(requestHeaders);

        Map<String, Object> queryParamMap = new HashMap<>();
        queryParamMap.put("graduate", true);

        ResponseEntity<Student> getStudentEntity = restTemplate.exchange(
                "https://mocki.io/v1/b7a68eb2-f77c-43cf-bffe-8c647e9a2514",
                HttpMethod.GET,
                requestEntity,
                Student.class,
                queryParamMap
        );



        // 使用 exchange 發起 POST 請求
        HttpHeaders requestHeaders2 = new HttpHeaders();
        requestHeaders2.set("header2", "456");
        requestHeaders2.setContentType(MediaType.APPLICATION_JSON);

        Student studentRequestBody = new Student();
        studentRequestBody.setName("John");

        HttpEntity requestEntity2 = new HttpEntity(studentRequestBody, requestHeaders2);

        ResponseEntity<Student> postStudentEntity = restTemplate.exchange(
                "https://mocki.io/v1/b7a68eb2-f77c-43cf-bffe-8c647e9a2514",
                HttpMethod.POST,
                requestEntity2,
                Student.class
        );

        return "exchange success";
    }

}

