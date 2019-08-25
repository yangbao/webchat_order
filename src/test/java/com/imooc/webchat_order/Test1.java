package com.imooc.webchat_order;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class Test1 {

    @Test
    public void test() {
        log.info("aaaaaaaaaa");
        log.debug("ccccccccccc");
        log.warn("bbbbbbbb  ");
        log.error("33333333333333");
        log.error("33333333333333");
        log.error("33333333333333");
        log.error("33333333333333");
    }
}
