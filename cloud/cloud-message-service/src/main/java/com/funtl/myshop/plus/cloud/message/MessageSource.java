package com.funtl.myshop.plus.cloud.message;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

/**
 * @ClassName MessageSource
 * @Description TODO
 * @Author Scorpio
 * @Date 2019/12/7 13:21
 */
public interface MessageSource {

    @Output("admin-login-log-topic")
    MessageChannel adminLoginLog();
}
