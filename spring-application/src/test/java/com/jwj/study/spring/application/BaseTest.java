package com.jwj.study.spring.application;

import com.jwj.study.spring.application.transaction.cas.CASApplication;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * @author jwj
 * @date 2020/11/18 17:42
 * @description 基本测试类
 * @since 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = CASApplication.class)
@WebAppConfiguration
@ActiveProfiles
public class BaseTest {
}
