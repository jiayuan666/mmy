package com.zjy.mmy.controller;

import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;


@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = {"classpath*:spring/*.xml"})
public class GoodControllerTest {

    @Autowired
    public WebApplicationContext wac;

    private MockMvc mockMvc;

    @Before
    public void load() {
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }

    @Test
    @Transactional
    public void addTest() throws Exception {
        /**
         * {
         * 	"goodName":"洛丽塔123",
         * 	"userID":16,
         * 	"price":200.00,
         * 	"stock":1,
         * 	"detail":"穿过一次",
         * 	"trade":["自提","面交"],
         * 	"categoryID":5
         * }
         */
        MvcResult result = mockMvc.perform(
                MockMvcRequestBuilders.post("/good/add")
            .contentType(MediaType.APPLICATION_JSON_VALUE)
            .param("goodName", "长长长长长长长长长裙")
            .param("userID","16")
            .param("price","1290.00")
            .param("stock","2")
            .param("detail", "好看好看好看")
            .param("trades","自提","上门")
            .param("categoryID","5")
        )
        .andReturn();
        System.out.println(result.getResponse().getContentAsString());
    }

    @Test
    @Transactional
    public void updateTest() throws Exception {
        MvcResult result = mockMvc.perform(
                MockMvcRequestBuilders.get("/good/update")
                .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
                .param("goodID", "28")
                .param("goodName","不是很长裙")
        ).andReturn();
        log.info("response:\n status:{},\ncontent:{}",
                result.getResponse().getStatus(),
                result.getResponse().getContentAsString());

    }

    @Test
    public void getGoodTest() throws Exception {
        MvcResult result = mockMvc.perform(
                MockMvcRequestBuilders.get("/good/get")
                .param("goodID", "17")
        ).andReturn();
        log.info("response:\n status:{},\ncontent:{}",
                result.getResponse().getStatus(),
                result.getResponse().getContentAsString());
    }

    @Test
    public void searchGoodTest() throws Exception{
        /**
         * public class SearchGoodRequest {
         *     private String nameLike;
         *     private Integer categoryID;
         *     private Integer priceLt;
         *     private Integer priceMt;
         *     private List<String> trades;
         * }
         */
        MvcResult result = mockMvc.perform(
                MockMvcRequestBuilders.get("/good/search")
                .param("nameLike", "裙")
                .param("priceMt","200")
                .param("priceLt","1000")
                .param("categoryID","5")
                .param("trades","上门", "自提")
        ).andReturn();
        log.info("response:\n status:{},\ncontent:{}",
                result.getResponse().getStatus(),
                result.getResponse().getContentAsString());
    }
}
