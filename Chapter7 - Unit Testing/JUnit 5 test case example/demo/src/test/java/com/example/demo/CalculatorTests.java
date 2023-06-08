package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CalculatorTests {

    // 只能在 test 資料夾底下使用 @Test
    // 加上 @Test 後，該方法即變為可執行的 test case (測項)
    // vs code 可以藉由欲測試程式生成相對應的 test 方法
    // 如: add -> testAdd
    // @Disabled: 略過某個 test case
    @Disabled
    @Test
    public void testAdd() {
        Calculator calculator = new Calculator();
        int result = calculator.add(1, 2);

        // 斷言 result 不為 null
        assertNotNull(result);

        // assert: 斷言, 斷言(result = 3)
        // 期望結果為 3, 實際結果為 result
        assertEquals(3, result);
    }

    @DisplayName("Test divide function")
    @Test
    public void testDivide() {
        Calculator calculator = new Calculator();

        // 斷言執行 method 時，會噴出 expection
        // 由於輸入與輸出皆為 int，因此碰到 1/0 時會出現錯誤
        assertThrows(ArithmeticException.class, () -> {
            calculator.divide(1, 0);
        });
    }

}
