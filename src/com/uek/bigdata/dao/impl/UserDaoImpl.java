package com.uek.bigdata.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import com.uek.bigdata.dao.IUserDao;
import com.uek.bigdata.daomain.User;
import com.uek.bigdata.util.DBUtils;

/**
 * @author 优逸客大数据研发部
 * @className: UserDaoImpl
 * @description: 用户模块Dao层接口实现类
 * @date: 2020/11/26 15:37
 * @version: 1.0
 */
public class UserDaoImpl implements IUserDao {

	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;
	List<User> list = null;

	/**
	 * @Param user:
	 * @return void
	 * @description 添加用户
	 * @author 优逸客大数据研发部
	 * @date 2020/11/27 11:20
	 */
	@Override
	public void add(User user) {
		try {
			conn = DBUtils.getConnection();
			// 4. 定义sql；
			String sql = "insert into t_user value ('" + user.getUsername() + "','" + user.getPassword() + "','" + user.getName() + "'" + ",'" + user.getSex() + "','" + user.getAge() + "','" + user.getCity() + "')";

			// 5. 获取执行sql语句的对象 Statement；
			stmt = DBUtils.getStatement(conn);
			DBUtils.executeDMLOpertion(stmt, sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtils.closeDQLResources(conn, stmt, rs);
		}
	}

	/**
	 * @Param :
	 * @return java.util.List<com.uek.bigdata.daomain.User>
	 * @description 查找所有的用户
	 * @author 优逸客大数据研发部
	 * @date 2020/11/27 11:20
	 */
	@Override
	public List<User> selectAll() {
		try {
			conn = DBUtils.getConnection();
			// 4. 定义sql；
			String sql = "select * from t_user";

			// 5. 获取执行sql语句的对象 Statement；
			stmt = DBUtils.getStatement(conn);
			List<User> users = DBUtils.executeDQLOpertionGetMoreData(stmt, sql, User.class);
			return users;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtils.closeDQLResources(conn, stmt, rs);
		}
		return null;
	}
}
