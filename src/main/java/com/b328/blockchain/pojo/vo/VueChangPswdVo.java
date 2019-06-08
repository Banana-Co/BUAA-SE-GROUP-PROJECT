package com.b328.blockchain.pojo.vo;

import javax.validation.constraints.NotNull;

public class VueChangPswdVo {
    @NotNull(message="用户名不允许为空")
    private String username;

    @NotNull(message="密码不允许为空")
    private String old_password;

    @NotNull(message="密码不允许为空")
    private String new_password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getOld_password() {
        return old_password;
    }

    public void setOld_password(String old_password) {
        this.old_password = old_password;
    }

    public String getNew_password() {
        return new_password;
    }

    public void setNew_password(String new_password) {
        this.new_password = new_password;
    }
}
