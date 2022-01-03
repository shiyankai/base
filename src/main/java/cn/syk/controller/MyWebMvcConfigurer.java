package cn.syk.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

/**
 * @Author syk
 * @date 2021/12/27 16:21
 **/
public class MyWebMvcConfigurer implements WebMvcConfigurer {
    private Logger logger = LoggerFactory.getLogger(MyWebMvcConfigurer.class);

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {

    }
}
