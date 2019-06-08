package com.b328.blockchain.pojo.vo;

import javax.validation.constraints.NotNull;

public class VueUserNameVo {
    @NotNull(message="用户名不允许为空")
    private String username;


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
