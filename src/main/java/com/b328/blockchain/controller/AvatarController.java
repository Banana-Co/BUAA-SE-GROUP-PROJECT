package com.b328.blockchain.controller;


import com.b328.blockchain.pojo.vo.VueAvatarVo;
import com.b328.blockchain.serviceimpl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;

public class AvatarController {
    @Autowired
    UserService userService;

    @CrossOrigin
    @RequestMapping(value = "/addImage", method = RequestMethod.POST)
    @ResponseBody
    public String addImage(@RequestParam(name = "image_data", required = false)VueAvatarVo avatarVo) {
        MultipartFile file = avatarVo.getAvatar();
        //文件上传
        if (!file.isEmpty()) {
            try {
                //图片命名
                String newCompanyImageName = avatarVo.getUsername();
                String newCompanyImagepath = "D:\\"+newCompanyImageName;
                File newFile = new File(newCompanyImagepath);
                if (!newFile.exists()) {
                    newFile.createNewFile();
                }
                BufferedOutputStream out = new BufferedOutputStream(
                        new FileOutputStream(newFile));
                out.write(file.getBytes());
                out.flush();
                out.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                return "图片上传失败！";
            } catch (IOException e) {
                e.printStackTrace();
                return "图片上传失败！";
            }
        }
        return "图片上传失败！";
    }

    


}
