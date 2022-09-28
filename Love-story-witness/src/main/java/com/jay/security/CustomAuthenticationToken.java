package com.jay.security;

import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.SpringSecurityCoreVersion;


/**
 * Copyright(c),2018-2021,合肥市鼎足空间技术有限公司
 *
 * @author jing.fang
 * @date 2022/9/28 15:33
 * @description 自定义认证token
 * history
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
public class CustomAuthenticationToken extends AbstractAuthenticationToken {

    private static final long serialVersionUID = SpringSecurityCoreVersion.SERIAL_VERSION_UID;

    private final CustomUserDetail userDetails;

    public CustomAuthenticationToken(CustomUserDetail userDetails) {
        super(null);
        this.userDetails = userDetails;
        super.setAuthenticated(true);
    }

    @Override
    public Object getCredentials() {
        return this.userDetails.getPassword();
    }

    @Override
    public Object getPrincipal() {
        return userDetails;
    }

}
