package com.asianrapid.talin.services.pay;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.util.HashMap;

/**
 * @ClassName PayTest
 * @desc 接口单元测试
 * @Author Nio
 * @Date 2019/9/17 0017
 * @Version V1.0
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class PayTest {

    //配置MockMvc
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void TestXXX() throws Exception {
        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
        map.add("customerId", "12");
        map.add("amount", "69");
        map.add("orderId", "201909171500");

        MvcResult result = mockMvc.perform(
                MockMvcRequestBuilders.get("/pay/getPayToken")
                        .contentType(MediaType.APPLICATION_JSON_UTF8)
                        .header("Authorization", "Bearer 6eb8e05b-b382-4d63-a9d5-541c18dbd9bd")
                .params(map)
        )
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();

    }
}
