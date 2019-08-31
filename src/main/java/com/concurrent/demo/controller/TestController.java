package com.concurrent.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @ProjectName: con_demo
 * @Package: com.concurrent.demo
 * @ClassName: TestController
 * @Author: limingxing
 * @Description: ${description}
 * @Date: 2019/8/27 9:09
 * @Version: 1.0
 */
@RequestMapping("/test/")
@RestController
public class TestController {
    @Autowired
    private final static Logger logger = LoggerFactory.getLogger(TestController.class);

    @RequestMapping("testOne")
    public String testOne(){
        logger.info("tsetOne run !!!");
        return "testOne";
    }
}
