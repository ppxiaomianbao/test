package com.concurrent.demo.configs;

import com.concurrent.demo.common.ThreadHolder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @ProjectName: con_demo
 * @Package: com.concurrent.demo.configs
 * @ClassName: ThreadInterceptor
 * @Author: limingxing
 * @Description: todo 自定义拦截器
 * @Date: 2019/9/1 17:16
 * @Version: 1.0
 */
public class ThreadInterceptor implements HandlerInterceptor {
    private final static Logger LOGGER = LoggerFactory.getLogger(ThreadInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        ThreadHolder.remove();
        Long aLong = ThreadHolder.get();
        LOGGER.info("threadINterceptor----aftercompletion!!!");
    }
}
