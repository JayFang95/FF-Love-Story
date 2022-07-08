package com.jay.utils;

import com.jay.common.constant.ErrorCodeEnum;
import lombok.Data;

/**
 * Copyright(c),2018-2021,合肥市鼎足空间技术有限公司
 *
 * @author jing.fang
 * @date 2022/7/8 9:13
 * @description 故事响应对象
 * history
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
@Data
public class ResponseBean<T> {

    private Integer code;
    private String msg;
    private T data;

    private ResponseBean(){
        this.code = 200;
        this.msg = "哈哈，操作成功啦~";
    }

    private ResponseBean(T data){
        this.code = 200;
        this.msg = "哈哈，操作成功啦~";
        this.data = data;
    }

    private ResponseBean(String msg ,T data){
        this.code = 200;
        this.msg = msg;
        this.data = data;
    }

    private ResponseBean(Integer code, String msg){
        this.code = code;
        this.msg = msg;
    }

    private ResponseBean(Integer code, String msg ,T data){
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    /**
     * 操作成功
     */
    public static ResponseBean<Void> success(){
        return new ResponseBean<>();
    }

    public static ResponseBean<Object> success(String msg){
        return new ResponseBean<>(msg);
    }

    public static ResponseBean<Object> success(Object data){
        return new ResponseBean<>(data);
    }

    public static ResponseBean<Object> success(String msg, Object data){
        return new ResponseBean<>(msg, data);
    }

    /**
     * 失败操作
     */
    public static ResponseBean<Void> fail(){
        return new ResponseBean<>(500, "很抱歉，操作失败了呢~");
    }

    public static ResponseBean<Object> fail(String msg){
        return new ResponseBean<>(500, msg);
    }

    public static ResponseBean<Object> fail(Object data){
        return new ResponseBean<>(500, "很抱歉，操作失败了呢~", data);
    }

    public static ResponseBean<Object> fail(String msg, Object data){
        return new ResponseBean<>(500, msg, data);
    }

    /**
     * 枚举对象错误响应
     */
    public static ResponseBean<Void> fail(ErrorCodeEnum codeEnum){
        return new ResponseBean<>(codeEnum.getCode(), codeEnum.getMsg());
    }

    public static ResponseBean<Object> fail(ErrorCodeEnum codeEnum, Object data){
        return new ResponseBean<>(codeEnum.getCode(), codeEnum.getMsg(), data);
    }

}
