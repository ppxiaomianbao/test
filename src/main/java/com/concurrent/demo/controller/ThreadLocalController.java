package com.concurrent.demo.controller;

import com.concurrent.demo.common.ThreadHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @ProjectName: con_demo
 * @Package: com.concurrent.demo.controller
 * @ClassName: ThreadLocalController
 * @Author: limingxing
 * @Description: ${description}
 * @Date: 2019/9/1 17:24
 * @Version: 1.0
 */
@Component
@RequestMapping("/threadLocal/")
public class ThreadLocalController {

    @RequestMapping("test")
    @ResponseBody
    public long getSessionId(){
        return ThreadHolder.get();
    }
}
