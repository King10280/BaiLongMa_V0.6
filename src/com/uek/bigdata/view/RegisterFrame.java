package com.uek.bigdata.view;

import com.uek.bigdata.daomain.User;
import com.uek.bigdata.service.IUserService;
import com.uek.bigdata.service.impl.UserServiceImpl;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

/**
 * @author 优逸客大数据研发部
 * @className: RegisterFrame
 * @description: 注册界面
 * @date: 2020/11/26 15:37
 * @version: 1.0
 */
public class RegisterFrame extends PublicFrame {

    private JTextField tfUsername;         //定义注册用户名
    private JPasswordField pfPassword;    //定义输入密码框
    private JPasswordField pfRePassword;    //定义确认密码框
    private JTextField tfName;

    private JButton btRegister;            //定义注册按钮
    private JButton btBack;                //定义返回按钮

    private JLabel lblCity, lblSex;         //定义城市和性别
    private JRadioButton rdoMale, rdoFemale;    //定义性别选择
    private JComboBox<String> cboCity;      //定义城市的多选框

    IUserService userService = new UserServiceImpl();

    /**
     * @return
     * @Param :
     * @description 注册界面
     * @author 优逸客大数据研发部
     * @date 2020/11/27 13:49
     */
    RegisterFrame() {

        this.setLayout(null);       //绝对布局

        JLabel jlUser = new JLabel("用户名"); //定义用户名文本标签
        jlUser.setBounds(20, 42, 74, 15);  //设置标签文职
        this.add(jlUser);//添加到本界面

        tfUsername = new JTextField();     //定义一个文本输入框
        tfUsername.setBounds(104, 40, 148, 25);    //设置位置
        this.add(tfUsername);//添加到本界面

        JLabel jlPass = new JLabel("输入密码");   //定义密码文本标签
        jlPass.setBounds(20, 99, 74, 15); //设置标签位置
        this.add(jlPass); //添加到本界面

        pfPassword = new JPasswordField();    //定义密码1 输入框
        pfPassword.setBounds(104, 94, 148, 25);//设置输入框位置
        this.add(pfPassword);  //添加到本界面

        JLabel jlRePass = new JLabel("再次输入密码");//定义密码2标签
        jlRePass.setBounds(20, 156, 74, 15);//设置位置
        this.add(jlRePass);//添加到本界面

        pfRePassword = new JPasswordField();    //定义一个密码2输入框
        pfRePassword.setBounds(104, 152, 148, 25);//密码输入框位置
        this.add(pfRePassword); //添加到本界面

        JLabel jlName = new JLabel("姓名");  //定义一个姓名的文本标签
        jlName.setBounds(20, 208, 74, 15); //设置位置
        this.add(jlName);//添加到本界面

        tfName = new JTextField(10);   //定义一个姓名输入框
        tfName.setBounds(104, 204, 148, 25);   //设置位置
        this.add(tfName);  //添加到本界面

        lblSex = new JLabel("性别："); //定义一个性别文本标签
        lblSex.setBounds(20, 260, 74, 15);//设置位置
        this.add(lblSex);    //添加到本界面

        rdoMale = new JRadioButton("男");    //定义性别选择框
        rdoMale.setSelected(true);  //设置默认选中
        rdoMale.setBounds(104, 256, 50, 25);//设置位置
        this.add(rdoMale);//添加到本界面

        rdoFemale = new JRadioButton("女");  //定义女行选择框
        rdoFemale.setBounds(173, 256, 50, 25);//设置位置
        this.add(rdoFemale);//添加到本界面

        ButtonGroup group = new ButtonGroup();  //
        group.add(rdoMale); //将男行选择框添加到group中
        group.add(rdoFemale);//将女性选择框添加到group中

        lblCity = new JLabel("所在地：");   //定义一个所在地 文本标签
        lblCity.setBounds(20, 312, 74, 15); ////设置位置
        this.add(lblCity);   //添加到本界面

        cboCity = new JComboBox<String>(); //定义一个城市选择框
        cboCity.setModel(new DefaultComboBoxModel<String>(new String[]{
                "北京", "上海", "广州", "太原", "西安", "武汉"}));
        cboCity.setBounds(104, 308, 122, 25);//设置位置
        this.add(cboCity); //添加到本界面中

        btRegister = new JButton("注 册");   //注册按钮
        btRegister.setBounds(33, 360, 90, 35);//设置位置
        btRegister.addActionListener(new ActionListener() {    //添加监听事件
            @Override
            public void actionPerformed(ActionEvent e) {
                btRegisterActionPerformed(); //注册方法
            }
        });
        this.add(btRegister);//将注册按钮添加到界面

        btBack = new JButton("返 回");   //定义一个返回按钮
        btBack.setBounds(160, 360, 90, 35);
        btBack.addActionListener(new ActionListener() {    //返回按钮的监听方法
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); //关闭界面
            }
        });
        this.add(btBack); //将返回按钮添加到界面

        this.setTitle("白龙马商城注册界面");
        this.setSize(338, 464);    //设置界面大小
        this.setResizable(false);                //设置界面大小不可改变
        this.setLocationRelativeTo(null);        //设置登录界面居中
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);   //设置默认关闭操作

    }

    /**
     * @return void
     * @Param :
     * @description 注册方法
     * @author 优逸客大数据研发部
     * @date 2020/11/27 13:50
     */
    public void btRegisterActionPerformed() { //注册方法实现

        String username = tfUsername.getText().trim();     //获取username的值
        String name = tfName.getText().trim();             //获取用户名

        String pass = new String(pfPassword.getPassword()).trim();   //获取第一次输入的密码
        String rePass = new String(pfRePassword.getPassword()).trim();   //获取第二次输入的密码

        //获取所有的用户列表
        List<User> userList = userService.selectAll();

        for (User user : userList) {       //遍历
            if (!user.getUsername().equals(username)) { //校验 username 唯一
                if (pass.equals(rePass)) {
                    User users = new User();
                    users.setUsername(username);
                    users.setPassword(pass);
                    users.setName(name);
                    users.setSex(String.valueOf(rdoMale.isSelected() ? 1 : 0));   //获取性别   1 是男 0是女
                    users.setCity(cboCity.getSelectedItem().toString());    //获取城市

                    userService.add(users); //调用添加用户方法

                    JOptionPane.showMessageDialog(this, "注册成功！");   //提示
                    this.dispose();//关闭当前页面
                    new LoginFrame();   //打开登录页面
                    break;
                } else {
                    JOptionPane.showMessageDialog(this, "密码不一致请重新输入！");//提示
                }

            } else {
                JOptionPane.showMessageDialog(null, "用户名已存在,请重新输入！");//提示
                break;
            }
        }

    }

}
