package com.b328.blockchain.serviceimpl;

import com.b328.blockchain.entity.User;
import com.b328.blockchain.mapper.UserMapper;
import com.b328.blockchain.result.Result;
import com.b328.blockchain.result.ResultFactory;
import com.b328.blockchain.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

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
        return userMapper.addUser(user);
    }

    @Override
    public int deleteUser(User user) {
        return userMapper.deleteUser(user);
    }

    @Override
    public Result login(User user) {
        List<User> list=userMapper.login(user);
        if(!list.isEmpty()){
            return ResultFactory.buildSuccessResult(list.get(0));
        }else {
            return ResultFactory.buildFailResult("登录失败！");
        }
    }

    @Override
    public User getUser(String user_name) {
        return userMapper.getUser(user_name);
    }
}
