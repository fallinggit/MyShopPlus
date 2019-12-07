package com.funtl.myshop.plus.message;

import com.funtl.myshop.plus.message.sink.AdminLoginLogSink;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;

/**
 * @ClassName MessageAdminLoginLogApplication
 * @Description TODO
 * @Author Scorpio
 * @Date 2019/12/7 13:53
 */
@SpringBootApplication
@EnableBinding({AdminLoginLogSink.class})
public class MessageAdminLoginLogApplication {

    public static void main(String[] args) {
        SpringApplication.run(MessageAdminLoginLogApplication.class,args);
    }
}
