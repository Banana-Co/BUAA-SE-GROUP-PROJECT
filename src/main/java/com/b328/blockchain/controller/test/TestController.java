package com.b328.blockchain.controller.test;

import com.b328.blockchain.entity.User;
import com.b328.blockchain.serviceimpl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TestController {
    @Autowired
    @Qualifier("userService")
    private UserService userService;

    @GetMapping("/test")
    public String test()
    {
        return userService.selectAsaltByName("admin");
    }

    /**
     * 查询所有用户的所有信息
     * @return
     */
    @GetMapping("/getAllUser")
    public List<User> selectAllUser()
    {
        return userService.getAllUsers();
    }

    /**
     * 根据用户名查询一个用户的所有信息
     * @param username
     * @return
     */
    @GetMapping("/selectOneUserByName")
    public User selectOneUserByName(@RequestParam(name = "name", defaultValue = "") String username)
    {
        return userService.getUserByName(username);
    }

    /**
     * 用户注册
     *
     * @param user
     */
    @PostMapping("/testUserRe")
    @ResponseBody
    public String userRegister(User user)
    {
        System.out.println(user.toString());

        if(user.getSalt() == null) {
            user.setSalt("");
        }
        userService.userRegister(user);

        return user.toString();
    }
}