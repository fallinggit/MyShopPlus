package com.funtl.myshop.plus.business;
/**
 * 全局业务异常
 * <p>
 * Description:
 * </p>
 *
 * @author Lusifer
 * @version v1.0.0
 * @date 2019-10-24 01:21:25
 * @see com.funtl.myshop.plus.business
 */
public class BusinessException extends RuntimeException {
    private static final long serialVersionUID = -9097263846040722319L;

    private Integer code;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public BusinessException() {
    }

    public BusinessException(BusinessStatus status) {
        super(status.getMessage());
        this.code = status.getCode();
    }
}