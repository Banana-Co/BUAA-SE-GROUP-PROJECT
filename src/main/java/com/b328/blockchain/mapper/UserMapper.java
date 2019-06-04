package com.b328.blockchain.mapper;

import com.b328.blockchain.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface UserMapper {
    @Select("SELECT * FROM u_user")
    @Results({
            @Result(property = "user_id", column = "user_id"),
            @Result(property = "user_name", column = "user_name"),
            @Result(property = "user_password", column = "user_password")
    })
    List<User> getAllUsers();

    @Insert("INSERT INTO u_user(id, username, password) VALUES(#{user_id}, #{user_name}, #{user_password})")
    int addUser(User user);

    @Delete("DELETE FROM User WHERE id = #{user_id}")
    int deleteUser(User user);

    @Select("SELECT * FROM u_user WHERE pswd = #{user_password}")
    List<User> login(User user);

    @Select("SELECT * FROM u_user WHERE nickname = #{user_name}")
    User selectAllByName(String user_name);

    @Insert("insert into user (`name`,`password`,`salt`) values (#{nickname},#{pswd},#{salt})")
    void userRegister(User user);

    @Select("select `salt` from user where `name`=#{name}")
    String selectAsaltByName(String name);
}
