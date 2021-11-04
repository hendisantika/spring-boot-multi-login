package com.hendisantika;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
class SpringBootMultiLoginApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testIfRegularHomePageIsSecured() throws Exception {
        final ResultActions resultActions = mockMvc.perform(get("/regular/home"));
        resultActions
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("http://localhost/regular/login"));
    }

    @Test
    public void testIfSpecialHomePageIsSecured() throws Exception {
        final ResultActions resultActions = mockMvc.perform(get("/special/home"));
        resultActions
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("http://localhost/special/login"));
    }


}
