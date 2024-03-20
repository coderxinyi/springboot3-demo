package com.guhave.springboot3.core.menshen.config;

import cn.xdf.arch.menshen.MenShenClient;
import lombok.Data;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author guxinxin@xdf.cn
 * @createTime 2024/03/19 19:00:00
 */
@Configuration
@Data
public class MenShenConfig {

    String baseUrl = "http://menshen.test.xdf.cn";
    String token = "11b7e75af17647df95a1b56446cb8f2d";

    @Bean
    MenShenClient menShenClient(){
        return MenShenClient.builder().host(baseUrl).token(token).build();
    }
}
