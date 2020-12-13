package com.uek.bigdata;

import com.uek.bigdata.view.LoginFrame;

import java.awt.*;

import static com.uek.bigdata.view.PublicFrame.InitGlobalFont;

/**
 * @author 优逸客大数据研发部
 * @className: BootStrap 引导程序
 * @description: 项目启动
 * @date: 2020/11/26 17:01
 * @version: 1.0
 */
public class BootStrap {

    public static void main(String[] args) {
        InitGlobalFont(new Font("微软雅黑", Font.PLAIN,14));    //设置默认字体
        for (int i = 0; i < 2; i++) { //启动两个线程
            new ExtendsThread().start();
        }

    }

    /**
     * @author 优逸客大数据研发部
     * @Param null:
     * @return
     * @description 启动方法
     * @date 2020/11/27 11:43
     */
    static class ExtendsThread extends Thread {
        @Override
        public void run() {
        	/**
        	 * 打开loging界面
        	 */
            new LoginFrame(); 
        }
    }

}
