package com.jay.service;

import com.jay.entity.User;
import com.jay.utils.ResponseBean;

/**
 * Copyright(c),2018-2021,合肥市鼎足空间技术有限公司
 *
 * @author jing.fang
 * @date 2022/7/8 9:56
 * @description 见证接口
 * history
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
public interface IWitnessService {

    /**
     * 认证用户登陆
     *
     * @description 认证用户登陆
     * @author jing.fang
     * @date 2022/7/8 9:58
     * @param user user
     * @return com.jay.utils.ResponseBean
    **/
    ResponseBean login(User user);
}
