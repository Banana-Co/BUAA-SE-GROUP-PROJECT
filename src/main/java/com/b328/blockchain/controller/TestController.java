package com.b328.blockchain.controller;

import com.b328.blockchain.entity.User;
import com.b328.blockchain.pojo.vo.VueLoginInfoVo;
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
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

@RestController
public class TestController {
    @Autowired
    private IUserService userService;
    @CrossOrigin
    @RequestMapping(value = "/time", method = RequestMethod.POST, produces = "application/json; charset=UTF-8")
    public Result getTime(@RequestBody String username) {
        User user=userService.getUser(username);
        if (user==null){
            return ResultFactory.buildFailResult(ResultCode.NotExist);
        }else {
            return ResultFactory.buildSuccessResult(user.getRegister_time().toString());
        }
    }
}
