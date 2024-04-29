package com.ssafy.spring.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@MapperScan("com.ssafy.spring.model.dao")
@Configuration
public class MyBatisConfig {
}