package com.funtl.myshop.plus.cloud.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @ClassName UmsAdminLoginLogDTO
 * @Description TODO
 * @Author Scorpio
 * @Date 2019/12/7 10:57
 */
@Data
public class UmsAdminLoginLogDTO implements Serializable {
    private static final long serialVersionUID = -4798414052038455596L;
    private Long id;
    private Long adminId;
    private Date createTime;
    private String ip;
    private String address;
    private String userAgent;
}
