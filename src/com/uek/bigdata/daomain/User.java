package com.uek.bigdata.daomain;

import com.uek.bigdata.controller.ShoppingAction;

/**
 * @author 优逸客大数据研发部
 * @className: User
 * @description: 用户JavaBean实体类
 * @date: 2020/11/26 12:38
 * @version: 1.0
 */
public class User {

    private String username;        //账号
    private String password;        //密码
    private String name;            //真实姓名
    private String sex;             //性别
    private int age;                //年龄
    private String city;            //城市

    private ShoppingAction cart = null; // 每个用户都有一个专属的购物车

    public User() {
        cart = new ShoppingAction();
    }

    public ShoppingAction getCart() {
        return cart;
    }

    public User(String username, String password, String name, String sex, int age, String city) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.city = city;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                ", city='" + city + '\'' +
                '}';
    }
}