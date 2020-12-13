package com.uek.bigdata.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import com.uek.bigdata.dao.ICartDao;
import com.uek.bigdata.daomain.CartItem;
import com.uek.bigdata.daomain.User;
import com.uek.bigdata.util.DBUtils;

/**
 * @author 优逸客大数据研发部
 * @className: CartDaoImpl
 * @description: 购物车模块Dao层接口实现类
 * @date: 2020/11/26 15:37
 * @version: 1.0
 */
public class CartDaoImpl implements ICartDao {

	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;
	CartItem cartItem = null;
	List<CartItem> list = null;

	/**
	 * @Param null:
	 * @return
	 * @description 查找
	 * @author 优逸客大数据研发部
	 * @date 2020/11/27 11:13
	 */
	@Override
	public CartItem selectItemById(int id) {
		try {
			System.out.println(id);
			conn = DBUtils.getConnection();
			stmt = DBUtils.getStatement(conn);
			// 4. 定义sql；
			String sql = "select * from t_cart where id = '" + id + "'";

			// 5. 获取执行sql语句的对象 Statement；
			CartItem cart = DBUtils.executeDQLOpertionGetSingleData(stmt, sql, CartItem.class);
			return cart;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e.getMessage());
		}finally {
			DBUtils.closeDQLResources(conn, stmt, rs);
		}
		return null;
	}

	/**
	 * @Param id:
	 * @Param count:
	 * @return void
	 * @description 添加
	 * @author 优逸客大数据研发部
	 * @date 2020/11/27 11:17
	 */
	@Override
	public void accCount(int id, int count) {
		try {
			conn = DBUtils.getConnection();
			// 4. 定义sql；
			String sql = "update t_cart set count = '" + count + "' + 1 where id = '" + id + "'";
			stmt = DBUtils.getStatement(conn);
			// 5. 获取执行sql语句的对象 Statement；
			int executeDMLOpertion = DBUtils.executeDMLOpertion(stmt, sql);
			System.out.println(executeDMLOpertion);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtils.closeDQLResources(conn, stmt, rs);
		}
	}

	/**
	 * @Param id:
	 * @Param count:
	 * @Param price:
	 * @return void
	 * @description 修改商品数量
	 * @author 优逸客大数据研发部
	 * @date 2020/11/27 11:17
	 */
	@Override
	public void updateTotalPrice(Integer id, Integer count, double price) {
		try {
			conn = DBUtils.getConnection();
			// 4. 定义sql；
			String sql = "update t_cart set totalprice = '" + count * price + "' where id = '" + id + "'";

			// 5. 获取执行sql语句的对象 Statement；
			stmt = DBUtils.getStatement(conn);
			DBUtils.executeDMLOpertion(stmt, sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtils.closeDQLResources(conn, stmt, rs);
		}
	}

	/**
	 * @Param cartItem:
	 * @return void
	 * @description 购物车添加商品
	 * @author 优逸客大数据研发部
	 * @date 2020/11/27 11:18
	 */
	@Override
	public void insertItem(CartItem cartItem) {
		try {
			conn = DBUtils.getConnection();
			// 4. 定义sql；
			String sql = "insert into t_cart values('" + cartItem.getUserId() + "' ,'" + cartItem.getId() + "', '" + cartItem.getName() + "' , '" + cartItem.getCount() + "' , '" + cartItem.getPrice() + "' , '" + cartItem.getTotalPrice() + "')";

			// 5. 获取执行sql语句的对象 Statement；
			stmt = DBUtils.getStatement(conn);
			DBUtils.executeDMLOpertion(stmt, sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtils.closeDQLResources(conn, stmt, rs);
		}
	}

	/**
	 * @Param id:
	 * @return void
	 * @description 删除购物车商品
	 * @author 优逸客大数据研发部
	 * @date 2020/11/27 11:18
	 */
	@Override
	public void deleteItem(int id) {
		try {
			conn = DBUtils.getConnection();
			// 4. 定义sql；
			String sql = "delete from t_cart where id = '" + id + "'";
			// 5. 获取执行sql语句的对象 Statement；
			stmt = DBUtils.getStatement(conn);
			DBUtils.executeDMLOpertion(stmt, sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtils.closeDQLResources(conn, stmt, rs);
		}
	}

	/**
	 * @Param :
	 * @return void
	 * @description 清空购物车
	 * @author 优逸客大数据研发部
	 * @date 2020/11/27 11:18
	 */
	@Override
	public void deleteAll() {
		try {
			conn = DBUtils.getConnection();
			// 4. 定义sql；
			String sql = "delete from t_cart";
			// 5. 获取执行sql语句的对象 Statement；
			stmt = DBUtils.getStatement(conn);
			DBUtils.executeDMLOpertion(stmt, sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtils.closeDQLResources(conn, stmt, rs);
		}
	}

	/**
	 * @Param id:
	 * @Param count:
	 * @return void
	 * @description 修改商品数量
	 * @author 优逸客大数据研发部
	 * @date 2020/11/27 11:19
	 */
	@Override
	public void updateCount(int id, int count) {
		try {
			conn = DBUtils.getConnection();
			// 4. 定义sql；
			String sql = "update t_cart set count = '" + count + "' where id = '" + id + "'";
			// 5. 获取执行sql语句的对象 Statement；
			stmt = DBUtils.getStatement(conn);
			DBUtils.executeDMLOpertion(stmt, sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtils.closeDQLResources(conn, stmt, rs);
		}
	}

	/**
	 * @Param :
	 * @return java.util.List<com.uek.bigdata.daomain.CartItem>
	 * @description 查看所有购物车商品
	 * @author 优逸客大数据研发部
	 * @date 2020/11/27 11:19
	 */
	@Override
	public List<CartItem> selectAll() {
		try {
			conn = DBUtils.getConnection();
			// 4. 定义sql；
			String sql = "select * from t_cart";
			// 5. 获取执行sql语句的对象 Statement；
			stmt = DBUtils.getStatement(conn);
			List<CartItem> list2 = DBUtils.executeDQLOpertionGetMoreData(stmt, sql, CartItem.class);
			return list2;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtils.closeDQLResources(conn, stmt, rs);
		}
		return null;
	}

	/**
	 * @Param user:
	 * @return java.util.List<com.uek.bigdata.daomain.CartItem>
	 * @description 根据用户名查购物车
	 * @author 优逸客大数据研发部
	 * @date 2020/11/27 11:19
	 */
	@Override
	public List<CartItem> findByUsername(User user) {
		try {
			conn = DBUtils.getConnection();
			// 4. 定义sql；
			String sql = "select * from t_cart where userId = '" + user.getUsername() + "'";
			// 5. 获取执行sql语句的对象 Statement；
			stmt = DBUtils.getStatement(conn);
			List<CartItem> list2 = DBUtils.executeDQLOpertionGetMoreData(stmt, sql, CartItem.class);
			return list2;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtils.closeDQLResources(conn, stmt, rs);
		}
		return null;
	}
}
