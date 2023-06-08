package com.example.demo;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {
    
    // url路徑: http://localhost:8080/test1?id=123&name=abc
    @RequestMapping("/test1")
    public String test1(@RequestParam(defaultValue = "456") Integer id, 
                        @RequestParam(required = false) String name) {
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        return "This is test1, your ID is: " + id + "\n"
             + "Your name is: " + name;
    }

    @RequestMapping("/test2")
    public String test2(@RequestBody Student student) {

        System.out.println("Student ID: " + student.getId());
        System.out.println("Student Name: " + student.getName());
        return "This is test2";
    }

    // @RequestHeader("Content-Type")
    // 如此即可取得中間有 - 的名稱
    @RequestMapping("/test3")
    public String test3(@RequestHeader String info) {
        System.out.println("The info is " + info);
        return "This is test3";
    }

    // url路徑: http://localhost:8080/test4/{userId}/{name}
    // {userId} 對應 () 中 userId
    // { name } 對應 () 中 name
    @RequestMapping("/test4/{userId}/{name}")
    public String test4(@PathVariable Integer userId, 
                        @PathVariable String name) {
        System.out.println("Path userId is: " + userId);
        System.out.println("Your name is: " + name);
        return "This is test4";
    }

}
