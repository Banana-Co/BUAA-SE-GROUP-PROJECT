package com.b328.blockchain.service;

import com.b328.blockchain.entity.User;

import java.util.List;

public interface IUserService {
    List<User> getAllUsers();

    int addUser(User user);

    int deleteUser(User user);
}
