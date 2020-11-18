package com.jwj.study.spring.application.transaction.cas;

import javafx.application.Application;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author jwj
 * @date 2020/11/18 16:05
 * @description CAS实现启动类
 * @since 1.0
 */
@SpringBootApplication
public class CASApplication {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
