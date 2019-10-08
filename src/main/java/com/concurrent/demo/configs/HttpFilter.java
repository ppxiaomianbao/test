package com.concurrent.demo.configs;

import com.concurrent.demo.common.ThreadHolder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @ProjectName: con_demo
 * @Package: com.concurrent.demo.configs
 * @ClassName: HttpFilter
 * @Author: limingxing
 * @Description: todo 自定义过滤器，在每期请求到达的时候将数据保存在threadLocal中
 * @Date: 2019/9/1 16:55
 * @Version: 1.0
 */
public class HttpFilter implements Filter {
    private final static Logger LOGGER = LoggerFactory.getLogger(HttpFilter.class);
    private FilterConfig filterConfig = null;
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.filterConfig = filterConfig;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpSession session = req.getSession();
        String servletPath = req.getServletPath();
        LOGGER.info("do filter!!! servletPath : {} " ,servletPath);
        // todo 向threadlocal里存入数据
        ThreadHolder.set(Thread.currentThread().getId());
        chain.doFilter(request,response);
    }

    @Override
    public void destroy() {
        filterConfig = null;
    }
}
