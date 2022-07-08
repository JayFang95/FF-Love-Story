package com.jay.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * Copyright(c),2018-2021,合肥市鼎足空间技术有限公司
 *
 * @author jing.fang
 * @date 2022/7/8 9:06
 * @description 故事人员对象
 * history
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
@Data
@Accessors(chain = true)
public class User implements Serializable {

    private Integer id;
    private Integer roleId;
    private String username;
    private String password;
    private String name;
    private String phone;
    private String note;
    private Date createTime;
    private Boolean deleteFlg;

}
