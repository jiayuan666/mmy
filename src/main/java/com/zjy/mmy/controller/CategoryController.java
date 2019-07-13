package com.zjy.mmy.controller;

import com.zjy.mmy.domain.pojo.Category;
import com.zjy.mmy.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("category")
public class CategoryController {

    private CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }


    @RequestMapping(value = "getAll", method = RequestMethod.GET)
    public @ResponseBody
    List<Category> getAll() {
        return categoryService.getAll();
    }

}
