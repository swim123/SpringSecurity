package com.ryx.mapper;


import com.ryx.entity.Role;
import com.ryx.entity.User;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @BelongsPackage: com.ryx.mapper
 * @Author: 容永轩
 * @CreateTime: 2021-06-18
 * @Description:
 */
public interface UserMapper {

    User loadUserByUsername(String username);

    List<Role> getUserRolesById(Integer id);


}
