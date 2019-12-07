package com.funtl.myshop.plus.cloud;

import com.funtl.myshop.plus.cloud.message.MessageSource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.stream.annotation.EnableBinding;

/**
 * @ClassName CloudMessageApplication
 * @Description TODO
 * @Author Scorpio
 * @Date 2019/12/7 13:11
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableBinding(MessageSource.class)
public class CloudMessageApplication {

    public static void main(String[] args) {
        SpringApplication.run(CloudMessageApplication.class,args);
    }
}
