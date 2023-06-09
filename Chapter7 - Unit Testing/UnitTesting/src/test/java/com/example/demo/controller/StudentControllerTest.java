package com.example.demo.controller;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

// 若想測試 Controller, 不可以使用 "注入 bean" 的方式測試
// 而是應該要直接模擬真實的 API Call
// 因此, 我們需要使用 @MockMvc 進行測試

@SpringBootTest
@AutoConfigureMockMvc
public class StudentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    // Unhandled exception type Exception
    // 要加上 throws Expection
    @Test
    void testCreate() throws Exception {
        RequestBuilder requestBuilder = MockMvcRequestBuilders
            .post("/students")
            .contentType(MediaType.APPLICATION_JSON)
            .content("{\n" +
                    "  \"name\": \"Hank\", \n" +
                    "  \"score\": 14.6, \n" + 
                    "  \"graduate\": false\n" +
                    "}");
        
        mockMvc.perform(requestBuilder)
               .andExpect(status().is(201));
    }

    @Test
    void testDelete() {

    }

    @Test
    void testRead() throws Exception{
        // RequestBuilder: Create Http request, set url path, 請求參數與 header
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                                     .get("/students/{studnetId}", 3)
                                     .header("headerName", "headerValue")
                                     .param("graduate", "true");

        // perform Http request and deal with it
        // 可以在上面 import 相對應的檔案, 如此一來就不用在前面加上 MockMvcRequestBuilders
        MvcResult mvcResult = mockMvc.perform(requestBuilder)
                                     .andDo(print())
                                     .andExpect(status().is(200))
                                     .andExpect(jsonPath("$.id", equalTo(3)))
                                     .andExpect(jsonPath("$.name", notNullValue()))
                                     .andReturn();

        String body = mvcResult.getResponse().getContentAsString();
        System.out.println("Return response body is: " + body);
    }

    @Test
    void testUpdate() {

    }
}
