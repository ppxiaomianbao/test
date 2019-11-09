package com.concurrent.demo;

import com.concurrent.demo.configs.HttpFilter;
import com.concurrent.demo.configs.ThreadInterceptor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@SpringBootApplication
public class DemoApplication  extends WebMvcConfigurationSupport {


    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    /**
     * @Method
     * @Author limingxing
     * @Version  1.0
     * @Description
     * @param null
     * @Return
     * @Exception todo 注册过滤器
     * @Date 2019/9/1 17:35
     */
    @Bean
    public FilterRegistrationBean getRegistrationBean(){

        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        //设置自定义过滤器
        registrationBean.setFilter(getHttpFilter());
        //设置过滤器名称
        registrationBean.setName("testFilter");
        //设置拦截url
        registrationBean.addUrlPatterns("/threadLocal/*");
        return registrationBean;
    }

    @Bean
    public HttpFilter getHttpFilter(){
        return new HttpFilter();
    }

    /**
     * @Method 
     * @Author limingxing
     * @Version  1.0
     * @Description
     * @param null
     * @Return 
     * @Exception todo 注册自定义拦截器，注意，要继承WebMvcConfigurationSupport，因为这是个重写方法
     * @Date 2019/9/1 17:37
     */
    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        //指定自定义拦截器及拦截的url
        registry.addInterceptor(new ThreadInterceptor()).addPathPatterns("/**");
    }
}
