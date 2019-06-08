package com.b328.blockchain.serviceimpl;

import com.b328.blockchain.entity.User;
import com.b328.blockchain.mapper.UserMapper;
import com.b328.blockchain.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Service
@Primary
public class UserService implements IUserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> getAllUsers() {
        return userMapper.getAllUsers();
    }

    @Override
    public int addUser(User user) {
        user.setRegister_time(new Timestamp(new Date().getTime()));
        return userMapper.addUser(user);
    }
    public void changePswd(User user){
        userMapper.changePswd(user);
    }

    @Override
    public User getUser(String user_name) {
        return userMapper.getUser(user_name);
    }



}
