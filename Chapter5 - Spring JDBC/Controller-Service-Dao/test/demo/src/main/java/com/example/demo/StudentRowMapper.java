package com.example.demo;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class StudentRowMapper implements RowMapper<Student> {

    @Override
    public Student mapRow(ResultSet resultSet, int i) throws SQLException {
        
        Student student = new Student();

        // "id" 盡量別寫數字, 以防 database column 變化造成的錯誤
        student.setId(resultSet.getInt("id"));
        student.setName(resultSet.getString("name"));
        student.setAge(resultSet.getLong("age"));
        student.setHeight(resultSet.getDouble("height"));
        student.setWeight(resultSet.getFloat("weight"));
        student.setCreateDate(resultSet.getTimestamp("create_date"));
        student.setEducated(resultSet.getBoolean("educated"));

        return student;
    }
    
}
