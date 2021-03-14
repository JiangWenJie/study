package com.jwj.study.spring.application.transaction.cas;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author jwj
 * @date 2020/11/18 16:05
 * @description CAS实现启动类
 * @since 1.0
 */
@SpringBootApplication
@EnableTransactionManagement
@MapperScan("com.jwj.study.spring.application.transaction.cas")
public class CASApplication {

    public static void main(String[] args) {
        SpringApplication.run(CASApplication.class, args);
    }
}
