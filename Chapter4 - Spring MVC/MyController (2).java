package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// 當使用 @RequestMapping 時
// 必須要加上 @RestController 或是 @Controller
// 這兩類註解是 @Component 的加強版
// 將該 Class 變成 bean, 讓 Class 內的 Request 生效

@RestController
public class MyController {
    
    @Autowired
    // private Printer printer;

    // @RequestMapping 用來將 url 路徑/test 
    // 對應到 test() 上
    // 註. 預設的臨時域名為 http://localhost.8080
    
    @RequestMapping("/test")
    public String test() {
        // printer.print("Hello World");
        return "Hello World";
    }
}
