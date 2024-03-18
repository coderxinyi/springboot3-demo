package com.example.springboot3.mystarter.annotation;

import com.example.springboot3.mystarter.CatAutoConfiguration;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @author guxinxin@xdf.cn
 * @createTime 2024/03/18 22:54:00
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
@Import(CatAutoConfiguration.class)
public @interface EnableCat {
}
