package com.uek.bigdata.view;

import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import java.awt.*;
import java.util.Enumeration;

/**
 * @author 优逸客大数据研发部
 * @className: PublicFrame
 * @description:  系统界面的公共资源
 * @date: 2020/11/26 15:37
 * @version: 1.0
 */
public class PublicFrame extends JFrame {

    /**
     * @return
     * @Param :
     * @description  设置基础界面
     * @author 优逸客大数据研发部
     * @date 2020/11/26 18:02
     */
    public PublicFrame() {
        //创建设置框架的图标
        Image bailongma = new JFrame().getToolkit().getImage("image/bailongma.png");
        //设置图标的图片
        this.setIconImage(bailongma);
        //设置框架可见
        this.setVisible(true);
    }

    /**
     * @return void
     * @Param font:
     * @description 设置默认字体
     * @author 优逸客大数据研发部
     * @date 2020/11/26 16:48
     */
    public static void InitGlobalFont(Font font) {
        FontUIResource fontRes = new FontUIResource(font);
        for (Enumeration<Object> keys = UIManager.getDefaults().keys();
             keys.hasMoreElements(); ) {
            Object key = keys.nextElement();
            Object value = UIManager.get(key);
            if (value instanceof FontUIResource) {
                UIManager.put(key, fontRes);
            }
        }
    }
}
