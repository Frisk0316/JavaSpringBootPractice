package com.example.demo;

import java.util.Date;

import org.aspectj.lang.ProceedingJoinPoint;
// import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
// import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyAspect {

    /*
    
    // 切入點的方法執行「前」執行
    // ()內描述的是 HpPrinter 裡的所有方法
    @Before("execution(* com.example.demo.HpPrinter.*(..))")
    public void before() {
        System.out.println("I'm before");
    }

    // 切入點的方法執行「後」再執行
    @After("execution(* com.example.demo.HpPrinter.*(..))")
    public void after() {
        System.out.println("I'm after");
    }

     */
    
    @Around("execution(* com.example.demo.HpPrinter.*(..))")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        
        // import.java.sql.Date changed to
        // import.java.util.Date
        Date start = new Date();
        System.out.println("I'm around before");

        // 執行切入點的方法
        Object obj = pjp.proceed();

        System.out.println("I'm around after");

        Date end = new Date();
        long time = end.getTime() - start.getTime();
        System.out.println("Total processed time: " + time + " ms");
        return obj;
    }
}