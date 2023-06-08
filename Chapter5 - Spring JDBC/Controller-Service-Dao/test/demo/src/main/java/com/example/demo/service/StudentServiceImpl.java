package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.Student;
import com.example.demo.dao.StudentDao;

// 變成 bean 讓其可以被別的程式注入
@Component
public class StudentServiceImpl implements StudentService{

    // Autowired 會根據變數的類型去尋找適合的 bean
    @Autowired
    private StudentDao studentDao;

    @Override
    public Student getById(Integer studentId) {
        return studentDao.getById(studentId);
    }
    
}
