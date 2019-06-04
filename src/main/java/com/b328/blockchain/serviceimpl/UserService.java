package com.b328.blockchain.serviceimpl;

import com.b328.blockchain.entity.User;
import com.b328.blockchain.mapper.UserMapper;
import com.b328.blockchain.result.Result;
import com.b328.blockchain.result.ResultFactory;
import com.b328.blockchain.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

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
    public User getUserByName(String user_name) {
        return userMapper.selectAllByName(user_name);
    }

    @Override
    public void userRegister(User user) {
        if(userMapper.selectAllByName(user.getNickname()) == null) {
            userMapper.userRegister(user);
            
        }
    }

    @Override
    public String selectAsaltByName(String name) {
        return userMapper.selectAsaltByName(name);
    }

}
