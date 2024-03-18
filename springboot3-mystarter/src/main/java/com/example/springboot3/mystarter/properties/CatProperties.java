package com.example.springboot3.mystarter.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author guxinxin@xdf.cn
 * @createTime 2024/03/18 22:18:00
 */
@ConfigurationProperties(prefix = "cat")
@Component
@Data
public class CatProperties {
    private String name;
    private String color;
    private Long age;
}
