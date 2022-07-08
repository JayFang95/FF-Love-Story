package com.jay.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.jay.common.constant.ErrorCodeEnum;
import com.jay.entity.User;
import com.jay.service.IUserService;
import com.jay.service.IWitnessService;
import com.jay.utils.ResponseBean;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

/**
 * Copyright(c),2018-2021,合肥市鼎足空间技术有限公司
 *
 * @author jing.fang
 * @date 2022/7/8 9:57
 * @description 认证服务实现
 * history
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
@Service
public class WitnessServiceImpl implements IWitnessService {

    @Autowired
    private IUserService userService;

    @Override
    public ResponseBean login(User user) {
        if (StringUtils.isEmpty(user.getUsername()) || StringUtils.isEmpty(user.getPassword()))
        {
            return ResponseBean.fail(ErrorCodeEnum.LOGIN_PARAM_ERROR);
        }
        // 查询验证用户信息
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(User::getUsername, user.getUsername());
        List<User> users = userService.list(wrapper);
        HashMap<String, Object> map = new HashMap<>(16);
        map.put("token","模拟生成的token");
        map.put("refreshToken","模拟生成的refreshToken");
        map.put("info",users.size() > 0 ? users.get(0) : "模拟查询的用户信息");
        return ResponseBean.success(map);
    }

}
