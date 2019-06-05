package com.b328.blockchain.controller;

import com.b328.blockchain.entity.User;
import com.b328.blockchain.pojo.vo.VueLoginInfoVo;
import com.b328.blockchain.result.Result;
import com.b328.blockchain.result.ResultCode;
import com.b328.blockchain.result.ResultFactory;
import com.b328.blockchain.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.naming.spi.DirStateFactory;
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
        if (user==null){
            return ResultFactory.buildFailResult(ResultCode.NotExist);
        }else if (!user.getUser_password().equals(loginInfoVo.getPassword())){
            return ResultFactory.buildFailResult(ResultCode.FAIL);
        }
        return ResultFactory.buildSuccessResult("登陆成功。");
    }
    @CrossOrigin
    @RequestMapping(value = "register", method = RequestMethod.POST, produces = "application/json; charset=UTF-8")
    public Result register(@Valid @RequestBody VueLoginInfoVo loginInfoVo, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            String message = String.format("注册失败，详细信息[%s]。", bindingResult.getFieldError().getDefaultMessage());
            return ResultFactory.buildFailResult(message);
        }
        User user=userService.getUser(loginInfoVo.getUsername());
        if (user!=null){
            return ResultFactory.buildFailResult(ResultCode.HaveExist);
        }else if (loginInfoVo.getUsername().equals("")||loginInfoVo.getPassword().equals("")){
            return ResultFactory.buildFailResult(ResultCode.FAIL);
        }
        User user1=new User();
        user1.setUser_name(loginInfoVo.getUsername());
        user1.setUser_password(loginInfoVo.getPassword());
        userService.addUser(user1);
        return ResultFactory.buildSuccessResult("注册成功。");
    }
    @CrossOrigin
    @RequestMapping(value = "testregister", method = RequestMethod.POST, produces = "application/json; charset=UTF-8")
    public Result testregister(@RequestParam(value="username") String username, @RequestParam(value="password") String password) {
        User user=userService.getUser(username);
        if (user!=null){
            return ResultFactory.buildFailResult(ResultCode.HaveExist);
        }else if (username.equals("")||password.equals("")){
            return ResultFactory.buildFailResult(ResultCode.FAIL);
        }
        User user1=new User();
        user1.setUser_name(username);
        user1.setUser_password(password);
        userService.addUser(user1);
        return ResultFactory.buildSuccessResult("注册成功。");
    }
    @RequestMapping("/greeting")
    public String hello() {
        return "hello";
    }

    @RequestMapping("/bye")
    public String bye() {
        return "bye";
    }

    @RequestMapping(value = "/user", method = RequestMethod.GET)
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
