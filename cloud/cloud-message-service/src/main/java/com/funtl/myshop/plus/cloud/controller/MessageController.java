package com.funtl.myshop.plus.cloud.controller;

import com.funtl.myshop.plus.cloud.dto.UmsAdminLoginLogDTO;
import com.funtl.myshop.plus.cloud.message.MessageSource;
import com.funtl.myshop.plus.cloud.producer.MessageProducer;
import com.funtl.myshop.plus.commons.dto.ResponseResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @ClassName MessageController
 * @Description TODO
 * @Author Scorpio
 * @Date 2019/12/7 13:27
 */
@RestController
@RequestMapping(value = "message")
public class MessageController {

    @Resource
    private MessageProducer messageProducer;

}
