package com.jay.controller;

import com.jay.entity.User;
import com.jay.service.IWitnessService;
import com.jay.utils.ResponseBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Copyright(c),2018-2021,合肥市鼎足空间技术有限公司
 *
 * @author jing.fang
 * @date 2022/7/7 21:36
 * @description 见证者控制器
 * history
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
@RestController
@RequestMapping("/love/witness")
public class WitnessController {

    @Autowired
    private IWitnessService witnessService;

    @PostMapping("login")
    public ResponseBean login(@RequestBody User user){
        return witnessService.login(user);
    }
}
