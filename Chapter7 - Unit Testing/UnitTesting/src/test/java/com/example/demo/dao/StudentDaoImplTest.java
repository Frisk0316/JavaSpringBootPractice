package com.example.demo.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.Student;

@SpringBootTest
public class StudentDaoImplTest {

    @Autowired
    private StudentDao studentDao;

    // 若 @Transactional 在 main 資料夾
    // 程式運行中途發生錯誤的話才 rollback

    // 若 @Transactional 在 test 資料夾：
    // 在 testDeleteById 的測試中將 id = 1 的欄目給刪除
    // 因此需要加上 @Transactional 使單元測試結束後
    // 強制 rollback 所有執行的資料庫操作
    @Transactional
    @Test
    void testDeleteById() {
        studentDao.deleteById(3);

        Student student = studentDao.getById(3);
        assertNull(student);
    }
    
    @Test
    void testGetById() {
        Student student = studentDao.getById(5);
        
        assertNotNull(student);
        assertEquals("Amy", student.getName());
        assertEquals(90.3, student.getScore());
        assertTrue(student.isGraduate());
        assertNotNull(student.getCreateDate());
        
    }

    @Transactional
    @Test
    void testInsert() {
        Student student = new Student();
        student.setName("Kevin");
        student.setScore(66.2);
        student.setGraduate(true);

        Integer studentId = studentDao.insert(student);

        Student result = studentDao.getById(studentId);
        assertNotNull(result);
        assertEquals("Kevin", result.getName());
        assertEquals(66.2, result.getScore());
        assertTrue(result.isGraduate());
        assertNotNull(result.getCreateDate());

    }

    @Transactional
    @Test
    void testUpdate() {
        Student student = studentDao.getById(3);
        student.setName("Jon Moxley");

        studentDao.update(student);

        Student result = studentDao.getById(3);
        assertNotNull(result);
        assertEquals("Jon Moxley",result.getName());
   
    }
}
