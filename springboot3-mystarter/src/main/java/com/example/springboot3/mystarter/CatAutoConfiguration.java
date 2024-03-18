package com.example.springboot3.mystarter;

import com.example.springboot3.mystarter.controller.CatController;
import com.example.springboot3.mystarter.properties.CatProperties;
import com.example.springboot3.mystarter.service.CatService;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author guxinxin@xdf.cn
 * @createTime 2024/03/18 22:48:00
 */
@Configuration
@Import({CatProperties.class, CatService.class, CatController.class})
public class CatAutoConfiguration {
}
