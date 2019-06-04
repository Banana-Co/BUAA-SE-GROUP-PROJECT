package com.b328.blockchain.service;

import com.b328.blockchain.entity.User;
import com.b328.blockchain.result.Result;

import java.util.List;

public interface IUserService {
    List<User> getAllUsers();

    User getUserByName(String user_name);

    public void userRegister(User user);

    String selectAsaltByName(String name);
}
