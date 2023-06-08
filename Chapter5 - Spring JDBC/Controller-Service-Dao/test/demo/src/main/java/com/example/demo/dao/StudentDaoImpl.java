package com.example.demo.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import com.example.demo.Student;
import com.example.demo.StudentRowMapper;

// 將其變成 bean 使其能被注入
@Component
public class StudentDaoImpl implements StudentDao {
    
    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public Student getById(Integer studentId) {
        // 寫出所有欲查詢的column, 盡量不要用 * 避免效率低下
        String sql = "SELECT id, name FROM student WHERE id = :studentId";
            
        Map<String, Object> map = new HashMap<>();
        map.put("studentId", studentId);
        
        List<Student> list = namedParameterJdbcTemplate.query(sql, map, new StudentRowMapper());
                
        // 先去判斷 list 裡面有無數據, 沒有的話回傳 null
        if(list.size() > 0) { return list.get(0); }
        else { return null; }
    }
}
