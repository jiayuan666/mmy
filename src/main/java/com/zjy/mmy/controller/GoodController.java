package com.zjy.mmy.controller;

import com.zjy.mmy.controller.request.AddGoodRequest;
import com.zjy.mmy.controller.request.SearchGoodRequest;
import com.zjy.mmy.controller.request.UpdateGoodRequest;
import com.zjy.mmy.domain.pojo.Category;
import com.zjy.mmy.domain.pojo.Good;
import com.zjy.mmy.domain.pojo.User;
import com.zjy.mmy.service.GoodService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.xml.bind.ValidationException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping(value = "good")
@Slf4j
public class GoodController {

    private GoodService goodService;

    @Autowired
    public GoodController(GoodService goodService) {
        this.goodService = goodService;
    }

    //保存用户商品
    @RequestMapping(value = "add", method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE
    )
    @ResponseBody
    public int addGood(@RequestBody AddGoodRequest request
            ,BindingResult result
    ) throws ValidationException {
        log.info("Add Good:{}", request);

        if (result.hasErrors()) {
            log.warn("Binding Errors: {}", result);
            throw new ValidationException(result.toString());
        }
        Timestamp date = new Timestamp(new Date().getTime());
        Good good = Good.builder().goodName(request.goodName)
                .category(new Category(request.categoryID, null))
                .date(date)
                .detail(request.getDetail())
                .price(request.price)
                .stock(request.stock)
                .trades(request.getTrades())
                .user(User.builder().userID(request.getUserID()).build())
                .build();

        return goodService.add(good);
    }

    //更新商品信息(商品名 价格 库存 详情 交易方式 分类)
    @RequestMapping(value = "update", method = RequestMethod.GET)
    @ResponseBody
    public int update(@Valid UpdateGoodRequest ugr
            , BindingResult result
    ) throws ValidationException {
        if(result.hasErrors()) {
            log.warn("Binding Errors: {}", result);
            throw new ValidationException(result.toString());
        }
        log.info("update good:{}", ugr);
        Good good = ugr.toGood();
        return goodService.update(good);
    }

    //获取用户的所有商品
    @RequestMapping(value = "getList", method = RequestMethod.GET,
            produces = "application/json;charset=UTF-8")
    @ResponseBody
    public List<Good> getList(Good good
            ,@RequestParam(value = "user_id", required = false)int userID
            ,@RequestParam(value = "category_id", required = false) Integer categoryID) {
        log.info("[Controller invoked-------/good/getList]");
        good.setUser(User.builder().userID(userID).build());
        good.setCategory(new Category(categoryID, null));

        return goodService.getList(good);
    }


    //删除商品
    @RequestMapping(value = "delete", method = RequestMethod.DELETE)
    @ResponseBody
    public int delete(Integer goodID) {
        if(goodID == null) {
            log.warn("goodID can't be null");
            return 0;
        }
        return goodService.delete(goodID);
    }

    //查找单个商品
    @RequestMapping(value = "get", method = RequestMethod.GET)
    @ResponseBody
    public Good get(Integer goodID) {
        if(goodID == null) {
            log.warn("goodID can't be null");
            return null;
        }
        return goodService.getByID(goodID);
    }

    //根据条件查找商品列表
    @RequestMapping(value = "search", method = RequestMethod.GET)
    @ResponseBody
    public List<Good> search(SearchGoodRequest request) {
        return goodService.search(request);
    }

    @RequestMapping(value = "test", method = RequestMethod.GET)
    @ResponseBody
    public void test1() {
        System.out.println("controller...testing...");
    }
}
