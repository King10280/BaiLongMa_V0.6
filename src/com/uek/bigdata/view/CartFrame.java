package com.uek.bigdata.view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.uek.bigdata.controller.BrowseAction;
import com.uek.bigdata.controller.CartAction;
import com.uek.bigdata.daomain.CartItem;
import com.uek.bigdata.daomain.Goods;
import com.uek.bigdata.daomain.User;

/**
 * @author 优逸客大数据研发部
 * @className: CartFrame
 * @description: 购物车界面
 * @date: 2020/11/26 15:37
 * @version: 1.0
 */
public class CartFrame extends PublicFrame {

	/*
	 * 定义购物车 欢迎 名字 查询信息等
	 */
	private JLabel lblCart, lblWelcome, lblName, lblQuantity;
	private JTable tblBooks; // 定义一个table
	private JButton btExit, btEmpty, btDeleteel; // 返回按钮
	private JScrollPane scrollPane;

	private CartFrame cartFrame;

	private User user = null;

	private CartAction cartAction = new CartAction();
	BrowseAction browseAction = new BrowseAction();

	List<Goods> list = browseAction.showAll(); // 获取商品集合

	public CartFrame getCheck() {
		return cartFrame;
	}

	/**
	 * @return
	 * @Param user:
	 * @description 购物车界面
	 * @author 优逸客大数据研发部
	 * @date 2020/11/27 13:46
	 */
	CartFrame(User user,Browse browse) {
		this.setLayout(null);
		cartFrame = this;
		this.user = user;

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		lblQuantity = new JLabel("0");
		lblQuantity.setBounds(151, 450, 48, 15);
		add(lblQuantity);

		tblBooks = new JTable();
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 45, 684, 383);
		scrollPane.setViewportView(tblBooks);
		add(scrollPane);

		// 显示书籍信息
		initBooksTableModel();
		showBooks(null);

		lblWelcome = new JLabel("您好，这里是您购买的所有商品");
		lblWelcome.setBounds(10, 10, 200, 15);
		add(lblWelcome);

		lblName = new JLabel("");
		lblName.setBounds(55, 10, 91, 15);
		add(lblName);

		JSeparator separator = new JSeparator();
		separator.setBounds(10, 35, 724, 2);
		add(separator);

		btExit = new JButton("返 回");
		btExit.setBounds(484, 444, 150, 32);
		add(btExit);
		btExit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				 // 缓存界面刷新
				browse.dispose();
				new Browse(user);
			}
		});

		btDeleteel = new JButton("删除");
		btDeleteel.setBounds(244, 444, 70, 32);
		add(btDeleteel);
		btDeleteel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				del();
			}
		});

		btEmpty = new JButton("清空购物车");
		btEmpty.setBounds(324, 444, 150, 32);
		add(btEmpty);
		btEmpty.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				empty();
			}
		});

		lblCart = new JLabel("购物车商品总价格：");
		lblCart.setBounds(30, 450, 140, 15);
		add(lblCart);
		
		this.setTitle("--购物车--");
        this.setSize(710, 550);
        this.setResizable(false);
        this.setLocationRelativeTo(null);        //设置登录界面居中
	}

	/**
	 * @return void
	 * @Param :
	 * @description 初始化购物车表格
	 * @author 优逸客大数据研发部
	 * @date 2020/11/27 13:46
	 */
	private void initBooksTableModel() {
		// 创建一个JTable的默认显示模式
		DefaultTableModel dt = new DefaultTableModel();
		// 设置JTable的列的个数和列的名字
		dt.setColumnIdentifiers(new Object[] { "书籍编号", "书籍名称", "购买数量", "价格", "总价", });

		tblBooks.setBackground(new Color(255, 255, 255));
		// 设置JTable表格对象被选中行的背景色
		tblBooks.setSelectionBackground(new Color(128, 0, 255));
		// 设置JTable表格对象被选中行的字体色
		tblBooks.setSelectionForeground(new Color(255, 255, 255));
		// 为表格设置商品信息表格模型
		tblBooks.setModel(dt);

		tblBooks.getColumnModel().getColumn(0).setPreferredWidth(70);
		tblBooks.getColumnModel().getColumn(1).setPreferredWidth(150);
		tblBooks.getColumnModel().getColumn(2).setPreferredWidth(70);
		tblBooks.getColumnModel().getColumn(3).setPreferredWidth(70);
		tblBooks.getColumnModel().getColumn(3).setPreferredWidth(70);

	}

	/**
	 * @return void
	 * @Param name:
	 * @description 展示所有购物车商品
	 * @author 优逸客大数据研发部
	 * @date 2020/11/27 13:47
	 */
	private void showBooks(String name) {

		cartAction = new CartAction();

		List<CartItem> myCart = cartAction.findByUserName(user); // 查找所有购买的商品信息

		BigDecimal total = new BigDecimal("0"); // 定义一个总价

		DefaultTableModel dt = (DefaultTableModel) tblBooks.getModel();

		for (int i = 0; i < myCart.size(); i++) {

			dt.insertRow(i, new Object[] { myCart.get(i).getId(), myCart.get(i).getName(), myCart.get(i).getCount(), myCart.get(i).getPrice(), myCart.get(i).getTotalPrice(), });

			BigDecimal price = new BigDecimal(myCart.get(i).getPrice()); // 获取商品价格
			// 获取商品的数量
			int num = myCart.get(i).getCount(); // 商品数量
			// 计算
			total = total.add(price.multiply(new BigDecimal(num)));
		}
		// 显示总价
		lblQuantity.setText(total + "");
	}

	/**
	 * @return void
	 * @Param :
	 * @description 清空购物车
	 * @author 优逸客大数据研发部
	 * @date 2020/11/27 13:47
	 */
	public void empty() {
		cartAction.removeAll();
		refresh();
		JOptionPane.showMessageDialog(null, "清空购物车成功！");

	}

	/**
	 * @return void
	 * @Param :
	 * @description 删除购物车商品
	 * @author 优逸客大数据研发部
	 * @date 2020/11/27 13:48
	 */
	public void del() {
		int selectedRow = tblBooks.getSelectedRow();
		List<CartItem> myCart = cartAction.findByUserName(user); // 查找所有购买的商品信息
		CartItem cartItem = myCart.get(selectedRow); // 获取当前选中的商品
		int id = cartItem.getId();

		cartAction.removeItem(id);
		refresh();
		JOptionPane.showMessageDialog(null, "删除商品成功！");
	}

	/**
	 * @return void
	 * @Param :
	 * @description 刷新界面方法
	 * @author 优逸客大数据研发部
	 * @date 2020/11/27 13:48
	 */
	public void refresh() {
		// 获取当前用户的购物车信息
		List<CartItem> myCart = cartAction.findAll();

		BigDecimal total = new BigDecimal("0"); // 定义一个总价

		DefaultTableModel dt = (DefaultTableModel) tblBooks.getModel();

		// 清空当前表格信息
		dt.setRowCount(0);

		for (int i = 0; i < myCart.size(); i++) {

			dt.insertRow(i, new Object[] { myCart.get(i).getId(), myCart.get(i).getName(), myCart.get(i).getCount(), myCart.get(i).getPrice(), myCart.get(i).getTotalPrice(), });

			BigDecimal price = new BigDecimal(myCart.get(i).getPrice()); // 获取商品价格
			// 获取商品的数量
			int num = myCart.get(i).getCount(); // 商品数量
			// 计算总价
			total = total.add(price.multiply(new BigDecimal(num)));
		}

		lblQuantity.setText(total + ""); // 设置购物车总数
	}

}
