package com.example.demo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class MyExceptionHandler {

    // 若要每筆 response 都去定義, 會使得程式碼不易維護
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<String> handle(RuntimeException exception) {
        // http response 503
        return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE)
                             .body("RuntimeException: " + exception.getMessage());
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handle(IllegalArgumentException exception) {
        // http response 400
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                             .body("IllegalArgumentException: " + exception.getMessage());
    }

}
