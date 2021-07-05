package com.ryx.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @BelongsPackage: com.ryx.entity
 * @Author: 容永轩
 * @CreateTime: 2021-07-05
 * @Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Menu {

    private  Integer id;
    private String pattern;

    private List<Role> roles;



}