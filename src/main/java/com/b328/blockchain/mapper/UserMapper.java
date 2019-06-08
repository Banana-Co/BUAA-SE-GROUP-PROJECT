package com.b328.blockchain.mapper;

import com.b328.blockchain.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface UserMapper {
    @Select("SELECT * FROM User")
    @Results({
            @Result(property = "user_id", column = "user_id"),
            @Result(property = "user_name", column = "user_name"),
            @Result(property = "user_password", column = "user_password")
    })
    List<User> getAllUsers();

    @Insert("INSERT INTO User(user_name,user_password,register_time) VALUES(#{user_name}, #{user_password}, #{register_time})")
    int addUser(User user);

    @Select("SELECT * FROM User WHERE user_name = #{user_name}")
    User getUser(String user_name);

    @Update("UPDATE User SET user_password = #{user_password} where user_name = #{user_name}")
    int changePswd(User user);
}
