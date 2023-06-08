package com.example.demo.dao;

import com.example.demo.Student;

public interface StudentDao {
    
    // 開頭使用 find, query, get 都可以
    Student getById(Integer studentId);
}
