package com.b328.blockchain.serviceimpl;

import com.b328.blockchain.entity.Role;
import com.b328.blockchain.entity.User;
import com.b328.blockchain.mapper.RoleMapper;
import com.b328.blockchain.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class LoginService {
    @Autowired
    UserMapper userMapper;
    @Autowired
    RoleMapper roleMapper;

    public User getUserByName(String user_name){
        return userMapper.selectAllByName(user_name);
    }

    public String getRolesById(long role_id){
        return roleMapper.findRoleByRid(role_id).getName();
    }
    public Long getRolesByName(String name){
        return  roleMapper.findRoleByName(name);
    }

}
