package com.example.demo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {
    
    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    // 一次插入一筆資料進入student
    @PostMapping("/students")
    public String insert(@RequestBody Student student) {

        String sql = "Insert INTO student(name) VALUE (:studentName)";
        
        Map<String, Object> map = new HashMap<>();
        map.put("studentName", student.getName());

        KeyHolder keyHolder = new GeneratedKeyHolder();

        namedParameterJdbcTemplate.update(sql, new MapSqlParameterSource(map), keyHolder);
        
        int id = keyHolder.getKey().intValue();
        System.out.println("mysql auto generated ID is: " + id);
        return "INSERT sql.";
    }

    // 使用 List 接住從前端傳送來的名字
    // 並將 .json 格式的資料輸入至 student table 中 
    // 僅需編譯一次 SQL 字串即可輸入所有資料
    @PostMapping("/students/batch")
    public String insertList(@RequestBody List<Student> studentList) {
        String sql = "INSERT INTO student(name) VALUE (:studentName)";

        MapSqlParameterSource[] parameterSources = new MapSqlParameterSource[studentList.size()];

        for(int i = 0; i < studentList.size(); i++) {
            Student student = studentList.get(i);
            parameterSources[i] = new MapSqlParameterSource();
            parameterSources[i].addValue("studentName", student.getName());
        }

        namedParameterJdbcTemplate.batchUpdate(sql, parameterSources);
        return "INSERT List of sql.";
    }

    // 一次刪除一筆資料
    @DeleteMapping("/students/{studentId}")
    public String delete(@PathVariable Integer studentId) {
        
        String sql = "DELETE FROM student WHERE id = :studentId";
        
        Map<String, Object> map = new HashMap<>();

        map.put("studentId", studentId);

        namedParameterJdbcTemplate.update(sql, map);
        return "DELETE sql.";
    }

    /*
     *  // 使用 GET 獲取所有 SQL 資料表中學生的 id, name
     *  @GetMapping("/students")
     *  public List<Student> select() {
     *   
        *  // 寫出所有欲查詢的column, 盡量不要用 * 避免效率低下
        *  String sql = "SELECT id, name FROM student";
        *       
        *  Map<String, Object> map = new HashMap<>();
        *       
        *  List<Student> list = namedParameterJdbcTemplate.query(sql, map, new StudentRowMapper());
        *  return list;
     *  }
     *
    */
    
    // 使用 GET 獲取單一筆學生的 id, name
    @GetMapping("/students/{studentId}")
    public Student select(@PathVariable Integer studentId) {
    
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
