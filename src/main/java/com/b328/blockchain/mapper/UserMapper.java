package com.b328.blockchain.mapper;

import com.b328.blockchain.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface UserMapper {
    @Select("SELECT * FROM User")
    @Results({
            @Result(property = "id", column = "user_id"),
            @Result(property = "name", column = "user_name"),
            @Result(property = "sex", column = "user_sex")
    })
    List<User> getAllUsers();

    @Insert("INSERT INTO User(user_id, user_name, user_sex) VALUES(#{id}, #{name}, #{sex})")
    int addUser(User user);

    @Delete("DELETE FROM User WHERE user_id = #{id}")
    int deleteUser(User user);
}
