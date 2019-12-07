package com.funtl.myshop.plus.cloud.feign;

import com.funtl.myshop.plus.cloud.feign.fallback.MessageFeignFallback;
import com.funtl.myshop.plus.configuration.FeignRequestConfiguration;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * @ClassName MessageFeign
 * @Description TODO
 * @Author Scorpio
 * @Date 2019/12/7 13:00
 */
@FeignClient(value = "cloud-message",path = "message",configuration = FeignRequestConfiguration.class,fallback = MessageFeignFallback.class)
public interface MessageFeign {

}
