package com.uek.bigdata.view;

import com.uek.bigdata.controller.UserAction;
import com.uek.bigdata.daomain.User;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author 优逸客大数据研发部
 * @className: LoginFrame
 * @description: 登录界面
 * @date: 2020/11/26 15:37
 * @version: 1.0
 */
public class LoginFrame extends PublicFrame {

    private JTextField tfUsername;               //定义一个用户名输入框
    private JPasswordField pfPassword;           //定义一个密码框
    private static boolean isLogin;               //判断是否登录
    private JCheckBox ckbRemember;                //是否记住密码

    private JButton btLogin;   //定义 登录按钮
    private JButton btRegister;   //定义 关闭按钮

    UserAction userAction = new UserAction();

    /**
     * @Param :
     * @return
     * @description 登录界面
     * @author 优逸客大数据研发部
     * @date 2020/11/27 13:49
     */
    public LoginFrame() {

        this.setLayout(null);  //绝对布局

        JLabel jlUser = new JLabel("登陆账号");//定义登录账号标签
        jlUser.setBounds(41, 72, 82, 15);//设置位置
        this.add(jlUser);//添加到当前界面

        tfUsername = new JTextField(); //定义用户名输入框
        tfUsername.setBounds(118, 64, 207, 30);//设置位置
        this.add(tfUsername);//添加到当前界面

        JLabel jlPassword = new JLabel("登陆密码");//定义登录密码标签
        jlPassword.setBounds(41, 116, 82, 15);//设置位置
        this.add(jlPassword);//添加到当前界面

        pfPassword = new JPasswordField();//定义密码输入框
        pfPassword.setBounds(118, 108, 207, 30);//设置位置
        this.add(pfPassword);//添加到当前界面

        ckbRemember = new JCheckBox("记住登录账号");//定义记住密码勾选框
        ckbRemember.setSelected(true);//默认勾选
        ckbRemember.setBounds(117, 151, 143, 23);//设置位置
        this.add(ckbRemember);//添加到当前界面

        btLogin = new JButton("登  录");//定义登录按钮
        btLogin.setBounds(63, 206, 93, 30);//设置位置
        btLogin.addActionListener(new ActionListener() {   // 登录按钮的监听事件
            @Override
            public void actionPerformed(ActionEvent e) {
                btLoginActionPerformed();
            }
        });
        this.add(btLogin);//添加到当前界面

        btRegister = new JButton("注   册");//定义注册按钮
        btRegister.setBounds(221, 206, 93, 30);//设置位置
        btRegister.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new RegisterFrame();//打开注册界面
                dispose();//关闭界面
            }
        });
        this.add(btRegister);//添加到当前界面

        this.setTitle("用户登录界面");
        this.setSize(400, 300);    //设置界面大小
        this.setResizable(false);                //设置界面大小不可改变
        this.setLocationRelativeTo(null);        //设置登录界面居中
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);   //设置默认关闭操作

    }

    /**
     * @Param :
     * @return void
     * @description 登录方法
     * @author 优逸客大数据研发部
     * @date 2020/11/27 13:49
     */
    public void btLoginActionPerformed() {

        //获取用户名和密码
        String username = tfUsername.getText().trim();
        String password = new String(pfPassword.getPassword()).trim();

        if (username.equals("admin") && password.equals("123456")) {
            this.dispose();
        } else {

            User user = userAction.login(username, password);//调用具体的login方法  判断用户名和密码

            if (user == null) {
                JOptionPane.showMessageDialog(this, "账号或密码不正确！");//提示
                tfUsername.requestFocus(); //获取焦点
                // 增加用户体验，选中文本框中的文字
                tfUsername.selectAll();
                return;
            } else {
                JOptionPane.showMessageDialog(this, "登陆成功！");//提示
                this.setLogin(true);//login状态为true
                // 用户信息完整，则进入商品查询界面
                new Browse(user);

            }
            this.dispose();//关闭当前界面
        }
    }

    public static boolean isLogin() {
        return isLogin;
    }

    public void setLogin(boolean login) {
        isLogin = login;
    }

}


