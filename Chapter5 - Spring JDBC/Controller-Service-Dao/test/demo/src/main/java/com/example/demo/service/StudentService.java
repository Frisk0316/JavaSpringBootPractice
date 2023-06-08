package com.example.demo.service;

import com.example.demo.Student;

// 透過 interface 快速了解哪些方法是可以被重複拿來使用的
public interface StudentService {
    
    Student getById(Integer studentId);
    
}
