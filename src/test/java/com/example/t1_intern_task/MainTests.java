package com.example.t1_intern_task;

import com.example.t1_intern_task.service.MainService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
public class MainTests {

    @Autowired
    MainService mainService;

    @Autowired
    private MockMvc mvc;

    @Test
    public void getNumOfCharsTest() {
        String request = "aaaaabcccc";
        String expectedResponse = "\"a\":5, \"c\":4, \"b\":1";
        Assertions.assertEquals(expectedResponse, mainService.getNumOfChars(request));
    }

    @Test
    public void mainControllerTest() throws Exception {
        String expectedResponse = "\"a\":5, \"c\":4, \"b\":1";
        mvc.perform(MockMvcRequestBuilders.get("/num?s=aaaaabcccc"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(expectedResponse));
    }
}
