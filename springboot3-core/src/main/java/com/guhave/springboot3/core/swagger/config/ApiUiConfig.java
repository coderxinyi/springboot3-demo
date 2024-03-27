package com.guhave.springboot3.core.swagger.config;

import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author guxinxin@xdf.cn
 * @createTime 2024/03/24 09:36:00
 */
@Configuration
public class ApiUiConfig {
    /**
     * 定义swagger分组
     *
     * @return
     */
    @Bean
    public GroupedOpenApi empApi() {
        return GroupedOpenApi.builder().group("员工管理")
                             .pathsToMatch("/emp/**", "/employee").build();
    }
}
