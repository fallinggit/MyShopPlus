package com.funtl.myshop.plus.configuration;

import com.funtl.myshop.plus.interceptor.FeignRequestInterceptor;
import feign.RequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName FeignRequestConfiguration
 * @Description TODO
 * @Author Scorpio
 * @Date 2019/11/30 19:31
 */
@Configuration
public class FeignRequestConfiguration {

    @Bean
    public RequestInterceptor requestInterceptor() {
        return new FeignRequestInterceptor();
    }
}
