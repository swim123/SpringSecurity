package com.ryx.service;

import com.ryx.entity.Role;
import com.ryx.entity.User;
import com.ryx.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


import java.util.List;

/**
 * @BelongsPackage: com.ryx.service
 * @Author: 容永轩
 * @CreateTime: 2021-06-18
 * @Description:
 */
@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userMapper.loadUserByUsername(username);
        if (user == null){
            throw new UsernameNotFoundException("user is no exist!");
        }

        List<Role> userRolesById = userMapper.getUserRolesById(user.getId());
        user.setRoles(userRolesById);

        return user;
    }
}
