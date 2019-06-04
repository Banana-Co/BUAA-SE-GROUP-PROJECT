package com.b328.blockchain.controller;

import com.b328.blockchain.entity.User;
import com.b328.blockchain.serviceimpl.UserService;
import com.b328.blockchain.util.UserRegisteAndLogin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {
    @Autowired
    @Qualifier("userService")
    private UserService service;

    /**
     * 处理用户的登录请求
     */
    @PostMapping("/userLogin")
    public String userLogin(User user, Model model) {
        user.setPswd(UserRegisteAndLogin.getInputPasswordCiph(user.getPswd(), service.selectAsaltByName(user.getNickname())));

        return UserRegisteAndLogin.userLogin(user, model);
    }

    /**
     * 处理用户的注册请求
     * @param user
     * @return
     */
    @PostMapping("/userRegister")
    public String userRegister(User user, Model model)
    {
        String userName = user.getNickname();
        String password = user.getPswd();

        String[] saltAndCiphertext = UserRegisteAndLogin.encryptPassword(password);

        user.setSalt(saltAndCiphertext[0]);
        user.setPswd(saltAndCiphertext[1]);

        service.userRegister(user);

        return UserRegisteAndLogin.userLogin(user, model); //使用户沆注册后立马登录
    }
}