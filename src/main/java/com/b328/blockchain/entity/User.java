package com.b328.blockchain.entity;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class User {
    private long id;
    private String nickname;
    private String pswd;
    private String salt;
    List<String> roleStrlist=new ArrayList<String>();////用户的角色集合
    List<String> perminsStrlist=new ArrayList<String>();//用户的权限集合

    public long getId() {
        return id;
    }

    public List<String> getRoleStrlist() {
        return roleStrlist;
    }

    public void setRoleStrlist(List<String> roleStrlist) {
        this.roleStrlist = roleStrlist;
    }

    public List<String> getPerminsStrlist() {
        return perminsStrlist;
    }

    public void setPerminsStrlist(List<String> perminsStrlist) {
        this.perminsStrlist = perminsStrlist;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPswd() {
        return pswd;
    }

    public void setPswd(String pswd) {
        this.pswd = pswd;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }
    @Override
    public String toString() {
        return "User{" + "id=" + id + ", name='" + nickname + '\'' + ", password='" + pswd  + '\'' + '}';
    }
}
