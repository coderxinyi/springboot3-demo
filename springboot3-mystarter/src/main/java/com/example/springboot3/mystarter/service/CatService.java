package com.example.springboot3.mystarter.service;

import com.example.springboot3.mystarter.properties.CatProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author guxinxin@xdf.cn
 * @createTime 2024/03/18 22:31:00
 */
@Service
public class CatService {
    @Autowired
    CatProperties properties;
    public String getCat(){
        return "name : " + properties.getName() + ", age : " + properties.getAge() + ", color : " + properties.getColor();
    }
}
