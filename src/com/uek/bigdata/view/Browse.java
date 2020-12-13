package com.uek.bigdata.view;

import com.uek.bigdata.controller.BrowseAction;
import com.uek.bigdata.controller.CartAction;
import com.uek.bigdata.daomain.CartItem;
import com.uek.bigdata.daomain.Goods;
import com.uek.bigdata.daomain.User;
import com.uek.bigdata.exception.CartyException;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

/**
 * @author 优逸客大数据研发部
 * @className: Check
 * @description: 商品列表界面
 * @date: 2020/11/26 15:37
 * @version: 1.0
 */
public class Browse extends PublicFrame {

	private JLabel lblGoodsName; // 定义商品名标签
	private JLabel lblCategory; // 定义分类标签
	private JLabel lblCart; // 定义购物车标签
	private JLabel lblName; // 定义用户名标签
	private JLabel lblCity; // 定义城市标签
	private JLabel lblQuantity; // 定义购物车数量标签
	private JLabel lblCartDetail; // 定义购物车详情
	private JTable tblGoods;// 定义表格
	private JButton btnQuery, btnBuy, btnHome; // 查询、购买按钮
	private JScrollPane scrollPane;
	private JTextField txtGoodsName; // 定义商品名文本框
	private JComboBox<String> cboCategory; // 下拉选择框

	private Browse browse;

	private User user = null;

	static CartAction cartAction = new CartAction();

	static BrowseAction browseAction = new BrowseAction();

	private List<Goods> list = browseAction.showAll(); // 获取商品列表

	/*
	 * @Param user:
	 * 
	 * @return
	 * 
	 * @description 浏览界面实现
	 * 
	 * @author 优逸客大数据研发部
	 * 
	 * @date 2020/11/27 13:43
	 */
	public Browse(User user) {

		this.setLayout(null); // 设置绝对布局
		browse = this;
		this.user = user;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // 设置默认关闭操作

		lblGoodsName = new JLabel("商品名："); // 定义商品名标签
		lblGoodsName.setBounds(10, 64, 70, 15);// 设置位置
		this.add(lblGoodsName); // 添加到界面中

		txtGoodsName = new JTextField(10); // 定义商品名输入框
		txtGoodsName.setBounds(71, 59, 159, 25);// 设置位置
		this.add(txtGoodsName);// 添加到界面中

		btnQuery = new JButton("查询"); // 定义查询标签
		btnQuery.setBounds(464, 55, 70, 32); // 设置位置
		this.add(btnQuery);// 添加到界面中
		// 查询按钮点击 - 事件处理程序
		btnQuery.addActionListener(new ActionListener() { // 查询监听事件
			public void actionPerformed(ActionEvent e) {

				String name = txtGoodsName.getText().toString(); // 获取查询的name
				Object category = cboCategory.getSelectedItem();// 获取查询选择的分类

				if (category.toString().equals("- 请选择 -")) { // 如果不选择 或者说选择的是“请选择”
					initGoodsTableModel();// 初始化表格
					showGoods(name, null); // 根据name去查询
				} else {
					initGoodsTableModel();// 初始化表格
					showGoods(name, category.toString());// 展示商品信息
				}
			}
		});
		
		lblName = new JLabel("您好,白龙马商城欢迎您！"); // 定义一个姓名标签
		lblName.setBounds(10, 10, 200, 15);// 设置位置
		this.add(lblName);// 添加到界面中

		lblQuantity = new JLabel("0件");// 设置购物车商品总数
		lblQuantity.setBounds(131, 402, 42, 15);// 设置位置
		this.add(lblQuantity);

		tblGoods = new JTable(); // 定义一个表格
		scrollPane = new JScrollPane();// 设置滚动面板
		scrollPane.setBounds(10, 97, 724, 273);// 设置表格再界面中的位置
		scrollPane.setViewportView(tblGoods); // 传递table列表到界面
		this.add(scrollPane); // 将滚动面板添加到界面

		lblCity = new JLabel("来自于："); // 定义 来自于 标签
		lblCity.setBounds(320, 10, 100, 15); // 设置位置
		this.add(lblCity); // 添加到界面

		JSeparator separator = new JSeparator(); // 垂直分割线
		separator.setBounds(10, 35, 724, 2); // 设置位置
		this.add(separator); // 将垂直分割线添加到界面

		btnBuy = new JButton("购 买"); // 定义购买按钮
		btnBuy.setBounds(564, 394, 70, 32); // 设置按钮位置
		this.add(btnBuy);// 将按钮添加到界面
		btnBuy.addActionListener(new ActionListener() { // 购买按钮监听时间
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					buy();// 购买方法
				} catch (CartyException cartyException) {
					cartyException.printStackTrace();
				}
			}
		});

		btnHome = new JButton("退出"); // 定义home按钮
		btnHome.setBounds(464, 2, 70, 32);// 设置按钮位置
		this.add(btnHome);// 添加到界面中
		btnHome.addActionListener(new ActionListener() { // home 按钮的监听事件
			@Override
			public void actionPerformed(ActionEvent e) {
				// 返回登录界面
				LoginFrame loginForm = new LoginFrame(); // 打开登录界面
				dispose();// 关闭当前界面
			}
		});

		lblCart = new JLabel("购物车商品数："); // 定义购物车商品数标签
		lblCart.setBounds(30, 402, 110, 15);// 设置位置
		this.add(lblCart);// 添加到当前界面

		lblCartDetail = new JLabel("查看详情"); // 定义查看详情标签
		lblCartDetail.setForeground(Color.BLUE); // 设置字体颜色
		lblCartDetail.setBounds(180, 402, 81, 15); // 设置位置
		this.add(lblCartDetail);// 添加到当前界面
		// 查看购物车数据详情
		lblCartDetail.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getButton() == MouseEvent.BUTTON1) {
					new CartFrame(user, browse); // 打开购物车界面
				}
			}
		});

		lblCategory = new JLabel("分类：");// 定义分类标签
		lblCategory.setBounds(240, 64, 70, 15);// 设置位置
		this.add(lblCategory);// 添加到主界面

		cboCategory = new JComboBox<String>(); // 定义下拉列表框
		cboCategory.setModel(new DefaultComboBoxModel<String>(new String[] { "- 请选择 -", "个人办公", "电子产品", "生活用品", "书籍" }));// 下拉列表属性
		cboCategory.setBounds(288, 59, 159, 25);// 设置位置
		this.add(cboCategory);// 添加带当前界面

		initDatas(); // 初始化数据
		// 显示书籍信息
		initGoodsTableModel(); // 初始化表格信息
		showGoods(null, null);// 展示表格数据

		this.setTitle("白龙马商城"); // 界面标题
		this.setSize(750, 500);// 设置界面位置大小
		this.setResizable(false);// 设置界面大小不可改变
		this.setLocationRelativeTo(null); // 设置登录界面居中
	}

	/**
	 * @return void
	 * @Param :
	 * @description 初始化表格
	 * @author 优逸客大数据研发部
	 * @date 2020/11/27 13:44
	 */
	private void initGoodsTableModel() {
		// 创建一个JTable的默认显示模式
		DefaultTableModel dt = new DefaultTableModel();
		// 设置JTable的列的个数和列的名字
		dt.setColumnIdentifiers(new Object[] { "商品编号", "商品名称", "库存", "销量", "价格", "类别", "商品产地", });

		tblGoods.setBackground(new Color(255, 255, 255));
		// 设置JTable表格对象被选中行的背景色
		tblGoods.setSelectionBackground(new Color(128, 0, 255));
		// 设置JTable表格对象被选中行的字体色
		tblGoods.setSelectionForeground(new Color(255, 255, 255));
		// 为表格设置商品信息表格模型
		tblGoods.setModel(dt);
		// tblGoods.isCellEditable(tblGoods.getSelectedRow(),
		// tblGoods.getSelectedColumn());

		// 设置表格的列
		tblGoods.getColumnModel().getColumn(0).setPreferredWidth(70);
		tblGoods.getColumnModel().getColumn(1).setPreferredWidth(100);
		tblGoods.getColumnModel().getColumn(2).setPreferredWidth(70);
		tblGoods.getColumnModel().getColumn(2).setPreferredWidth(70);
		tblGoods.getColumnModel().getColumn(3).setPreferredWidth(70);
		tblGoods.getColumnModel().getColumn(3).setPreferredWidth(70);
		tblGoods.getColumnModel().getColumn(3).setPreferredWidth(70);

	}

	/**
	 * @return void
	 * @Param name:
	 * @Param category:
	 * @description 表格展示商品数据
	 * @author 优逸客大数据研发部
	 * @date 2020/11/27 13:44
	 */
	private void showGoods(String name, String category) { // 展示所有商品信息

		List<Goods> goods = browseAction.queryGoods(name, category); // 调用查询方法

		list = goods;

		DefaultTableModel dt = (DefaultTableModel) tblGoods.getModel(); // 在表格中增加内容

		for (int i = 0; i < goods.size(); i++) { // 遍历goods 列表 将数据添加到表格中

			dt.insertRow(i, new Object[] { goods.get(i).getId(), goods.get(i).getName(), goods.get(i).getStock(), goods.get(i).getSales(), goods.get(i).getPrice(), goods.get(i).getCategory(), goods.get(i).getLocation(), });
		}
	}

	/**
	 * @return void
	 * @Param :
	 * @description 刷新界面数据
	 * @author 优逸客大数据研发部
	 * @date 2020/11/27 13:44
	 */
	public void refresh() { // 刷新界面数据
		DefaultTableModel model = (DefaultTableModel) tblGoods.getModel();

		model.setRowCount(0); // 清空表格数据
		List<Goods> list = browseAction.showAll(); // 获取所有的商品

		// 购买后获取购物车中的商品数量
		List<CartItem> goodsList = cartAction.findByUserName(user);

		int goodsQuantity = goodsList.size();
		// 显示购物车中的数据。
		lblQuantity.setText(goodsQuantity + "件");

		for (int i = 0; i < list.size(); i++) {// 遍历list
			// 重新为表格填数据
			Goods goods = (Goods) list.get(i); // 获取每个goods
			model.addRow(// 添加到表格中
					new Object[] { goods.getId(), goods.getName(), goods.getStock(), goods.getSales(), goods.getPrice(), goods.getCategory(), goods.getLocation() });
		}

	}

	/**
	 * @return void
	 * @Param :
	 * @description 购买商品方法
	 * @author 优逸客大数据研发部
	 * @date 2020/11/27 13:45
	 */
	public synchronized void buy() throws CartyException { // 购买商品的实现方法

		int selectedRow = tblGoods.getSelectedRow(); // 获取选中的列

		if (LoginFrame.isLogin() == true) { // 用户登录状态为true
			// 当用户没有选择商品时
			if (tblGoods.getSelectedRow() < 0) {
				JOptionPane.showMessageDialog(null, "请选择您需要购买的商品", "错误信息", // 提示
						JOptionPane.WARNING_MESSAGE);
				return;// 返回
			}

			Goods goods = (Goods) list.get(selectedRow); // 获取当前选中的商品
			int id = goods.getId(); // 获取id
			Goods shopgoods = browseAction.findGoodsById(id); // 通过id查找对应的商品

			if (shopgoods.getStock() >= 1) { // 判断商品库存信息

				user.getCart().buy(goods, 1, user); // 购买方法

				refresh();// 刷新界面内容

				// 增加用户体验，保持用户在表格中的选择不动。
				tblGoods.setRowSelectionInterval(selectedRow, selectedRow);
				JOptionPane.showMessageDialog(null, "购买成功，请到购物车查看所购商品");// 提示
			} else {
				JOptionPane.showMessageDialog(null, "购买失败，商品库存不足");// 提示
				refresh();// 刷新界面
			}
		} else {
			JOptionPane.showMessageDialog(null, "请先登录");// 提示
			new LoginFrame();// 打开登录界面
			dispose();// 关闭当前界面
		}

	}

	/**
	 * @return void
	 * @Param :
	 * @description 初始化界面数据
	 * @author 优逸客大数据研发部
	 * @date 2020/11/27 13:45
	 */
	private void initDatas() {
		if (user == null) {
			this.btnHome.setText("登录");
			return;
		}

		// 显示用户真实姓名 + 欢迎语
		this.lblName.setText(user.getName() + ",您好,欢迎登录白龙马");
		// 显示用户所在地
		this.lblCity.setText("来自于: " + user.getCity());

		// 获取用户 购物车列表
		List<CartItem> cartList = cartAction.findByUserName(user);

		// 购物车总数
		int goodsQuantity = cartList.size();
		// 显示购物车中的数据。
		lblQuantity.setText(goodsQuantity + "件");

	}

}
