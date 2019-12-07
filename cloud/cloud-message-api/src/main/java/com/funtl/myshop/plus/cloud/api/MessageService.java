package com.funtl.myshop.plus.cloud.api;

import com.funtl.myshop.plus.cloud.dto.UmsAdminLoginLogDTO;

/**
 * @ClassName MessageService
 * @Description TODO
 * @Author Scorpio
 * @Date 2019/12/7 14:44
 */
public interface MessageService {

    boolean sendAdminLoginLog(UmsAdminLoginLogDTO dto);
}
