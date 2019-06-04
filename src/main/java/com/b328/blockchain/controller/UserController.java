package com.b328.blockchain.controller;

import com.b328.blockchain.entity.User;
import com.b328.blockchain.mapper.RoleMapper;
import com.b328.blockchain.serviceimpl.UserService;
import com.b328.blockchain.util.UserRegisteAndLogin;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController {
    @Autowired
    @Qualifier("userService")
    private UserService service;

    @Autowired
    private RoleMapper roleMapper;

    //跳转到登录表单页面
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        return "need login";
    }

    //登录成功后，跳转的页面
    @RequestMapping("/success")
    public String index(Model model) {
        return "success";
    }

    //未登录，可以访问的页面
    @RequestMapping("/index")
    public String list(Model model) {
        return "index";
    }


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
}