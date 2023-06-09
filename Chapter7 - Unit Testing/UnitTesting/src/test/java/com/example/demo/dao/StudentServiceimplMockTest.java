package com.example.demo.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.example.demo.model.Student;
import com.example.demo.service.StudentService;

@SpringBootTest
public class StudentServiceimplMockTest {
    
    // 注入 bean
    @Autowired
    private StudentService studentService;

    @MockBean
    private StudentDao studentDao;

    @Test
    public void getById() {

        Student mockStudent = new Student();
        mockStudent.setId(100);
        mockStudent.setName("I'm Mock");

        // 當 when 的條件發生時, return mockStudent 的值
        Mockito.when(studentDao.getById(Mockito.any())).thenReturn(mockStudent);

        // 模擬噴出 Exception
        // Mockito.when().thenThrow();

        // 紀錄方法使用次數, 順序
        // Mockito.verify(studentDao, Mockito.times(2).getById(Mockito.any()));

        // 限制：不能 mock static, private, final class 這三種方法
        Student student = studentService.getById(3);

        assertNotNull(student);
        assertEquals(100, student.getId());
        assertEquals("I'm Mock", student.getName());
    }
}

// @MockBean vs @SpyBean
// @SpyBean: Spring 容器中的 bean 仍舊是正常的 bean, 只替換其中幾個方法