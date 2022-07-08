package com.jay;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Copyright(c),2018-2021,合肥市鼎足空间技术有限公司
 *
 * @author jing.fang
 * @date 2022/7/7 20:38
 * @description 见证启动类
 * history
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
@SpringBootApplication
@MapperScan(basePackages = {"com.jay.mapper"})
public class WitnessApplication {

    public static void main(String[] args) {
        SpringApplication.run(WitnessApplication.class, args);
    }

}
