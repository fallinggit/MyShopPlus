package com.funtl.myshop.plus.cloud.producer;

import com.funtl.myshop.plus.cloud.api.MessageService;
import com.funtl.myshop.plus.cloud.dto.UmsAdminLoginLogDTO;
import com.funtl.myshop.plus.cloud.message.MessageSource;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @ClassName MessageProducer
 * @Description TODO
 * @Author Scorpio
 * @Date 2019/12/7 13:23
 */
@Component
@Service(version = "1.0.0")
public class MessageProducer implements MessageService {

    @Resource
    private MessageSource source;

    /**
     * 管理登录日志
     *
     * @param dto {@link UmsAdminLoginLogDTO}
     * @return {@code boolean}
     */
    public boolean sendAdminLoginLog(UmsAdminLoginLogDTO dto) {
        return source.adminLoginLog().send(MessageBuilder.withPayload(dto).build());
    }
}
