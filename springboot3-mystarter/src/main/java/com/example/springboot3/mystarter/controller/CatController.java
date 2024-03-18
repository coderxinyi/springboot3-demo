package com.example.springboot3.mystarter.controller;

import com.example.springboot3.mystarter.service.CatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author guxinxin@xdf.cn
 * @createTime 2024/03/18 22:33:00
 */
@RestController
public class CatController {
    @Autowired
    CatService catService;
    @GetMapping("/cat")
    public String getCat() {
        return catService.getCat();
    }
}
