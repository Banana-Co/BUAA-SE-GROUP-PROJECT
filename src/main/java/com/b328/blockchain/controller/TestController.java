package com.b328.blockchain.controller;

import com.b328.blockchain.entity.User;
import com.b328.blockchain.pojo.vo.VueLoginInfoVo;
import com.b328.blockchain.pojo.vo.VueUserNameVo;
import com.b328.blockchain.result.Result;
import com.b328.blockchain.result.ResultCode;
import com.b328.blockchain.result.ResultFactory;
import com.b328.blockchain.service.IUserService;
import com.b328.blockchain.util.Md5SaltTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.naming.spi.DirStateFactory;
import javax.validation.Valid;

@RestController
public class TestController {
    @Autowired
    private IUserService userService;
    @CrossOrigin
    @RequestMapping(value = "/time", method = RequestMethod.POST, produces = "application/json; charset=UTF-8")
    public String getTime(@Valid @RequestBody VueUserNameVo vueLoginInfoVo) {
        return userService.getUser(vueLoginInfoVo.getUsername()).getRegister_time().toString();
    }
    @RequestMapping(value = "/testtime", method = RequestMethod.POST, produces = "application/json; charset=UTF-8")
    public String getTestTime(@RequestParam(value="username") String username) {
        return userService.getUser(username).getRegister_time().toString();
    }
}
