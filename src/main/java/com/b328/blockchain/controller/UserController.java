package com.b328.blockchain.controller;

import com.b328.blockchain.entity.User;
import com.b328.blockchain.mapper.RoleMapper;
import com.b328.blockchain.serviceimpl.UserService;
import com.b328.blockchain.util.UserRegisteAndLogin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {
    @Autowired
    @Qualifier("userService")
    private UserService service;

    @Autowired
    private RoleMapper roleMapper;
    /**
     * 处理用户的登录请求
     */
    @RequestMapping(value = "/login")
    public String login(User user, Model model) {
        user.setPswd(UserRegisteAndLogin.getInputPasswordCiph(user.getPswd(), service.selectAsaltByName(user.getNickname())));

        return UserRegisteAndLogin.userLogin(user, model);
    }

    @RequestMapping(value="/testRegister",method= RequestMethod.POST)
    @ResponseBody
    public String submitRegister(@RequestParam(value = "nickname") String username, @RequestParam(value = "pswd") String password,Model model){
        User user  = new User();
        user.setPswd(password);
        user.setNickname(username);
        return userRegister(user,model);
    }

    /**
     * 处理用户的注册请求
     */
    @PostMapping("/userRegister")
    public String userRegister(User user, Model model) {
        String userName = user.getNickname();
        String password = user.getPswd();

        String[] saltAndCiphertext = UserRegisteAndLogin.encryptPassword(password);

        user.setSalt(saltAndCiphertext[0]);
        user.setPswd(saltAndCiphertext[1]);

        service.userRegister(user);

        return UserRegisteAndLogin.userLogin(user, model); //使用户沆注册后立马登录
    }
    
    @RequestMapping(value="/ajaxLogin",method= RequestMethod.POST)
    @ResponseBody
    public String submitLogin(@RequestParam(value = "nickname") String username, @RequestParam(value = "pswd") String password,Model model) {
        User user = new User();
        user.setNickname(username);
        user.setPswd(password);
        return login(user,model);
    }


    /*
    //登出
    @RequestMapping(value = "/logout")
    public String logout(){
        return "logout";
    }

    //错误页面展示
    @GetMapping("/403")
    public String error(){
        return "error ok!";
    }

    //管理员功能
    @RequiresRoles("admin")
    @RequiresPermissions("管理员添加")
    @RequestMapping(value = "/admin/add")
    public String create(){
        return "add success!";
    }

    //用户功能
    @RequiresRoles("user")
    @RequiresPermissions("用户查询")
    @RequestMapping(value = "/user/select")
    public String detail(){
        return "select success";
    }
    */
}