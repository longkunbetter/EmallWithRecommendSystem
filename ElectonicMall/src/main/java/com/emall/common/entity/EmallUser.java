package com.emall.common.entity;

public class EmallUser {
    private Integer id;

    private String username;

    private String password;

    private String tel;

    private String email;

    private Integer gender;

    private String registerGender;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getRegisterGender() {
        return registerGender;
    }

    public void setRegisterGender(String registerGender) {
        this.registerGender = registerGender;
    }
}