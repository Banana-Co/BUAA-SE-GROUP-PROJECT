package com.b328.blockchain.mapper;

import com.b328.blockchain.entity.Role;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface RoleMapper {
    @Select("SELECT * FROM Role")
    @Results({
            @Result(property = "role_id", column = "role_id"),
            @Result(property = "role_name", column = "role_name"),
            @Result(property = "role_type", column = "role_type")
    })
    List<Role> getAllUsers();

    @Insert("INSERT INTO Role(role_id, role_name, role_type) VALUES(#{role_id}, #{role_name}, #{role_type})")
    int addUser(Role role);

    @Select("SELECT id,name,type FROM u_role,u_user_role WHERE uid = #{user_id} and rid = id")
    List<Role> findRoleByUid(long user_id);

    @Select("SELECT * FROM u_role WHERE id = #{role_id}" )
    Role findRoleByRid(long role_id);

    @Select("SELECT * FROM u_role WHERE name = #{name}" )
    Long findRoleByName(String name);
}
