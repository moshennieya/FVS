package com.lhf.sysfvscommon.util;

/**
 * <p></p>
 *
 * @author lhf
 * @since 2020/9/15 15:17
 */
public enum Status {

    /**
     * 成功
     */
    SUCCESS(200, "请求成功"),
    FAILURE(500, "请求失败"),
    AUTHENTICATION_FAILURE(480, "未登录"),
    UNO_PERMISSION(490, "无权访问"),
    ;

    public int code;
    public String mes;


    Status(int code, String mes) {
        this.code = code;
        this.mes = mes;
    }

}
