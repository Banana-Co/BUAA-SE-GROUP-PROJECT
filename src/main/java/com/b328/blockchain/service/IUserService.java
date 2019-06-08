package com.b328.blockchain.service;

import com.b328.blockchain.entity.User;
import com.b328.blockchain.result.Result;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface IUserService {
    List<User> getAllUsers();
    int addUser(User user);
    public void changePswd(User user);
    User getUser(String user_name);
}
