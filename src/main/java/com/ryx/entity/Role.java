package com.ryx.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


/**
 * @BelongsPackage: com.ryx.entity
 * @Author: 容永轩
 * @CreateTime: 2021-06-17
 * @Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Role {

    private Integer id;
    private String name;
    private String nameZh;


}
