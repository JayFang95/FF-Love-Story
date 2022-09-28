package com.jay.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Copyright(c),2018-2021,合肥市鼎足空间技术有限公司
 *
 * @author jing.fang
 * @date 2022/9/28 13:52
 * @description 自定义security退出处理器
 * history
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
public class CustomLogoutHandler implements LogoutHandler {

    @Override
    public void logout(HttpServletRequest request, HttpServletResponse response, Authentication authentication) {
        // todo 待开发
        System.out.println("正在退出。。。");
    }

}
