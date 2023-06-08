package com.example.demo;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MyTest {
    
    // 在全部 test case 前執行
    @BeforeAll
    public static void beforeAll() {
        System.out.println("執行 @BeforeAll");
    }

    // 在每個 test case 前執行
    @BeforeEach
    public void beforeEach() {
        System.out.println("執行 @BeforeEach");
    }

    // 在每個 test case 後執行
    @AfterEach
    public void afterEach() {
        System.out.println("執行 @AfterEach");
    }

    // 在全部 test case 後執行
    @AfterAll
    public static void afterAll() {
        System.out.println("執行 @AfterAll");
    }
    
    @Test
    public void test1() {
        // 訊息會出現在 vs code 的 DEBUG CONSOLE 中
        System.out.println("執行 Test 1");
    }

    @Test
    public void test2() {
        System.out.println("執行 Test 2");
    }

    /*
    @BeforeAll 與 @AfterAll 需要為 static void
    (較少用, 因為無法存取 spring 中的 bean)

    DEBUG CONSOLE output: 

        執行 @BeforeAll
        執行 @BeforeEach
        執行 Test 1
        執行 @AfterEach
        執行 @BeforeEach
        執行 Test 2
        執行 @AfterEach
        執行 @AfterAll

     */

}
