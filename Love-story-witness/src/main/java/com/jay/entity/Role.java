package com.jay.entity;

import lombok.Data;

import java.sql.Date;

/**
 * Copyright(c),2018-2021,合肥市鼎足空间技术有限公司
 *
 * @author jing.fang
 * @date 2022/7/8 9:11
 * @description 故事角色对象
 * history
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
@Data
public class Role {

    private Integer id;
    private String name;
    private String note;
    private Date createTime;

}
