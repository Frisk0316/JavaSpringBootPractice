package com.example.demo;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
public class StudentController {
    
    // default http method is "POST"
    // add @RequestBody attribute
    
    // Front-end can only use POST method to create 
    // @RequestMapping(value  = "/students", 
    //                method = RequestMethod.POST)
    
    // 簡易寫法, 兩者效果相同
    @PostMapping("/students")
    public String create(@RequestBody @Valid Student student) {
        
        return "Executing the create operation on the database.";
    }

    @GetMapping("/students/{studentId}")
    public String read(@PathVariable Integer studentId) {
        return "Executing the read operation on the database.";
    }

    @PutMapping("/students/{studentId}")
    public String update(@PathVariable Integer studentId,
                         @RequestBody Student student) {
        return "Executing the update operation on the database.";
    }

    @DeleteMapping("/students/{studentId}")
    public String delete(@PathVariable Integer studentId) {
        return "Executing the delete operation on the database.";
    }

}
