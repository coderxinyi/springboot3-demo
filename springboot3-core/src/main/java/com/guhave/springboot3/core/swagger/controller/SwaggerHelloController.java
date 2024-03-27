package com.guhave.springboot3.core.swagger.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author guxinxin@xdf.cn
 * @createTime 2024/03/24 09:27:00
 */
@RestController
public class SwaggerHelloController {

    @GetMapping("/hello/{id}")
    public String hello(@PathVariable("id") Integer id) {
        return "hello " + id;
    }
}
