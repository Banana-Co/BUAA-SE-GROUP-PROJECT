package com.b328.blockchain.pojo.vo;

import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotNull;

public class VueAvatarVo {
    @NotNull(message="用户名不允许为空")
    private String username;

    @NotNull(message = "图片为空")
    MultipartFile avatar;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public MultipartFile getAvatar() {
        return avatar;
    }

    public void setAvatar(MultipartFile avatar) {
        this.avatar = avatar;
    }
}
