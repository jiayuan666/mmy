package com.zjy.mmy.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.zjy.mmy.controller.request.AddOrderRequest;
import com.zjy.mmy.controller.request.UpdateOrderRequest;
import com.zjy.mmy.domain.OrderState;
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

import java.sql.Timestamp;
import java.util.Date;

@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = {"classpath*:spring/*.xml"})
public class OrderControllerTest {
    @Autowired
    public WebApplicationContext wac;

    private MockMvc mockMvc;
    private ObjectWriter objectWriter;
    @Before
    public void load() {
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
        objectWriter = new ObjectMapper().writer();
    }

    @Test
    @Transactional
    public void addTest() throws Exception {
        /**
         *private Integer userID;
         *private Integer goodID;
         *private String addr;
         *private String trade;
         */
        AddOrderRequest request = AddOrderRequest.builder()
                .goodID(15).userID(16).addr("西二001").trade("自提").build();
        String content = objectWriter.writeValueAsString(request);
        MvcResult result = mockMvc.perform(
            MockMvcRequestBuilders.post("/order/add")
            .contentType(MediaType.APPLICATION_JSON_VALUE)
            .content(content)
        ).andReturn();
        log.info("response:\n status:{},\ncontent:{}",
                result.getResponse().getStatus(),
                result.getResponse().getContentAsString());
    }

    @Test
    @Transactional
    public void updateTest() throws Exception {
        /**
         *private Integer orderID;
         *private OrderState orderState;
         *private Timestamp finishedDate;
         */
        UpdateOrderRequest request = UpdateOrderRequest.builder()
                .orderID(5)
                .orderState(OrderState.COMPLETED)
                .finishDate(new Timestamp(new Date().getTime()))
                .build();
        String content = objectWriter.writeValueAsString(request);
        MvcResult result = mockMvc.perform(
                MockMvcRequestBuilders.post("/order/update")
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .content(content)
        ).andReturn();
        log.info("response:\n status:{},\ncontent:{}",
                result.getResponse().getStatus(),
                result.getResponse().getContentAsString());
    }

    @Test
    public void getByIDTest() throws Exception {
        /**
         *userID
         *orderState
         */
        MvcResult result = mockMvc.perform(
                MockMvcRequestBuilders.get("/order/getByID")
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .param("orderID","2")
        ).andReturn();
        log.info("response:\n status:{},\ncontent:{}",
                result.getResponse().getStatus(),
                result.getResponse().getContentAsString());
    }

    @Test
    public void getByUserTest() throws Exception {
        /**
         *userID
         *orderState
         */
        MvcResult result = mockMvc.perform(
                MockMvcRequestBuilders.get("/order/getByUser")
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .param("userID","16")
//                        .param("orderState", OrderState.UNACCEPTED.getDesc())
        ).andReturn();
        log.info("response:\n status:{},\ncontent:{}",
                result.getResponse().getStatus(),
                result.getResponse().getContentAsString());
    }
}
