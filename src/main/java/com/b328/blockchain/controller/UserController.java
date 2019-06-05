package com.b328.blockchain.controller;

import com.b328.blockchain.entity.User;
import com.b328.blockchain.pojo.vo.VueLoginInfoVo;
import com.b328.blockchain.result.Result;
import com.b328.blockchain.result.ResultFactory;
import com.b328.blockchain.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class UserController {
    @Autowired
    private IUserService userService;
    @CrossOrigin
    @RequestMapping(value = "login", method = RequestMethod.POST, produces = "application/json; charset=UTF-8")
    public Result login(@Valid @RequestBody VueLoginInfoVo loginInfoVo, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            String message = String.format("登陆失败，详细信息[%s]。", bindingResult.getFieldError().getDefaultMessage());
            return ResultFactory.buildFailResult(message);
        }
        User user=userService.getUser(loginInfoVo.getUsername());
        if (user==null||!user.getUser_password().equals(loginInfoVo.getPassword())){
            String message = String.format("登陆失败，详细信息[用户名、密码信息不正确]。");
            return ResultFactory.buildFailResult(message);
        }
        return ResultFactory.buildSuccessResult("登陆成功。");
    }

    @RequestMapping("/greeting")
    public String hello() {
        return "hello";
    }

    @RequestMapping("/bye")
    public String bye() {
        return "bye";
    }

    @RequestMapping(value = "/getAllUsers", method = RequestMethod.GET)
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public int addUser(@RequestBody User user) {
        return userService.addUser(user);
    }

    @RequestMapping(value = "/deleteUser", method = RequestMethod.POST)
    public int deleteUser(@RequestBody User user) {
        return userService.deleteUser(user);
    }
}
