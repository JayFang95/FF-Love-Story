package com.jay.common.constant;

/**
 * Copyright(c),2018-2021,合肥市鼎足空间技术有限公司
 *
 * @author jing.fang
 * @date 2022/7/8 9:15
 * @description 故事错误响应枚举类
 * history
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
public enum ErrorCodeEnum {

    //HTTP错误定义
    INTERNAL_SERVER_ERROR(500,"恋爱系统奔溃了嘛~~~"),
    //权限认证错误
    UN_AUTHENTICATION_ERROR(401,"你还没有进行验证呢，请先登陆去呢~"),
    UN_AUTHORIZATION_ERROR(403,"你好像有这个权限哟，快去联系芳芳给你开通吧，嘻嘻~"),

    //共通错误代码定义
    COMMON_REPEAT(1001, "数据好像重复啦，检查下吧~"),
    COMMON_REQUIRED(1002, "有需要必填字段呢~"),
    COMMON_NUMBER(1003, "要输入有效数字哟~"),
    COMMON_DIGITS(1004,"有必须数字要亲输入呢~"),
    COMMON_DATE(1005,"亲爱的朋友，日期要输入正确哟~"),
    COMMON_EMAIL(1006, "邮件地址好像出问题啦~"),
    COMMON_ERROR(5000,"很抱歉，恋爱故事系统异出现常了呢~"),

    //登陆验证错误代码定义
    LOGIN_TIMEOUT_ERROR(4000,"哎呀，登录超时了~"),
    SESSION_TIMEOUT_ERROR(4001,"多久没看啦，我们已经下线了哟~"),
    LOGIN_NAME_ERROR(40012, "是你吗是你吗，我没有验证出来呢~"),
    LOGIN_PASSWORD_ERROR(4003, "仔细一点呀，密码好像不对了~"),
    LOGIN_PARAM_ERROR(4003, "咦，登陆信息不完整呢~");

    private Integer code;
    private String msg;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    ErrorCodeEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
