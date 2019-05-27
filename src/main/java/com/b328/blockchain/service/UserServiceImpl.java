package com.b328.blockchain.service;

import com.b328.blockchain.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("UserService1")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
}
