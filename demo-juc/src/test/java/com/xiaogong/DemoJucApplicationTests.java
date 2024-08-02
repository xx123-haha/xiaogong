package com.xiaogong;

import com.xiaogong.demo03.HttpUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoJucApplicationTests {

    @Autowired
    private HttpUtils httpUtils;

    @Test
    void contextLoads() {
        String sign = httpUtils.getSign("getSign", "", "provinceId=1");
        System.out.println("sign: "+sign);
    }

}
