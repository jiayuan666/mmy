package com.zjy.mmy.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.zjy.mmy.controller.request.AddUserRequest;
import com.zjy.mmy.controller.request.UpdateUserRequest;
import com.zjy.mmy.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = {"classpath*:spring/*.xml"})
public class UserControllerTest {
    @Autowired
    private WebApplicationContext wac;

    @Autowired
    private UserController userController;

    private MockMvc mockMvc;
    private ObjectWriter objectWriter;
    @Before
    public void load() {
        mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
        objectWriter = new ObjectMapper().writer();
    }

    @Test
    @Transactional
    public void addTest() throws Exception {
        /**
         * nickname:渣渣
         * //phone:
         * userID:16
         */
        AddUserRequest aur = AddUserRequest.builder()
                .nickname("测试1号")
                .openID("111111 ")
                .phone("666999666")
                .build();
        String content = objectWriter.writeValueAsString(aur);
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/user/add")
                .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
                .content(content)
        ).andReturn();
        log.info("response:\n status:{},\ncontent:{}",
                result.getResponse().getStatus(),
                result.getResponse().getContentAsString());
    }

    @Test
    public void getTest() throws Exception {
        MvcResult result = mockMvc.perform(
                MockMvcRequestBuilders.get("/user/get")
                .param("openID", "11111")
                .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
        ).andReturn();
        log.info("response:\n status:{},\ncontent:{}",
                result.getResponse().getStatus(),
                result.getResponse().getContentAsString());
    }

    @Test
    public void updateTest() throws Exception {
        UpdateUserRequest uur = UpdateUserRequest.builder()
                .userID(15)
                .nickname("玉树临风")
                .phone("15016522411")
                .build();
        String content = objectWriter.writeValueAsString(uur);
        MvcResult result = mockMvc.perform(
                MockMvcRequestBuilders.post("/user/update")
                        .content(content)
                        .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
        ).andReturn();
        log.info("response:\n status:{},\ncontent:{}",
                result.getResponse().getStatus(),
                result.getResponse().getContentAsString());
    }
}
