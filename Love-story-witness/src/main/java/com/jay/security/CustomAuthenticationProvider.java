package com.jay.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.common.exceptions.OAuth2Exception;
import org.springframework.stereotype.Component;

/**
 * Copyright(c),2018-2021,合肥市鼎足空间技术有限公司
 *
 * @author jing.fang
 * @date 2022/9/28 15:32
 * @description 自定义认证管理器
 * history
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

    private final Logger logger = LoggerFactory.getLogger(CustomAuthenticationProvider.class);

    /**
     * 认证流程
     */
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        Object principal = authentication.getPrincipal();
        Object credentials = authentication.getCredentials();
        String name = authentication.getName();
        Object details = authentication.getDetails();
        logger.info("principal:{},credentials:{},name:{},details:{}", principal, credentials, name, details);
        CustomUserDetail userDetail = new CustomUserDetail();
        userDetail.setUsername("admin");
        userDetail.setPassword(new BCryptPasswordEncoder().encode("123456"));
        if ("admin".equals(name)){
            OAuth2Exception auth2Exception = new OAuth2Exception("用户名和密码错误");
            auth2Exception.addAdditionalInformation("code","10001");
            throw auth2Exception;
        }
        return new CustomAuthenticationToken(userDetail);
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return true;
    }

}
