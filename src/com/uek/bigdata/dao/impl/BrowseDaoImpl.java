package com.uek.bigdata.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import com.uek.bigdata.dao.IBrowseDao;
import com.uek.bigdata.daomain.Goods;
import com.uek.bigdata.util.DBUtils;

/**
 * @author 优逸客大数据研发部
 * @className: BrowseDaoImpl
 * @description: 商品浏览模块Dao层接口实现类
 * @date: 2020/11/26 15:37
 * @version: 1.0
 */
public class BrowseDaoImpl implements IBrowseDao {

	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;
	List<Goods> list = null;

	/**
	 * @return java.util.List<com.uek.bigdata.daomain.Goods>
	 * @Param :
	 * @description 查找所有的商品
	 * @author 优逸客大数据研发部
	 * @date 2020/11/27 11:10
	 */
	@Override
	public List<Goods> selectAll() {
		try {
			conn = DBUtils.getConnection();
			// 4. 定义sql；
			String sql = "select * from t_goods";

			// 5. 获取执行sql语句的对象 Statement；
			stmt = DBUtils.getStatement(conn);
			list = DBUtils.executeDQLOpertionGetMoreData(stmt, sql, Goods.class);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtils.closeDQLResources(conn, stmt, rs);
		}
		return list;
	}

	/**
	 * @Param id:
	 * @return com.uek.bigdata.daomain.Goods
	 * @description 根据id查找商品
	 * @author 优逸客大数据研发部
	 * @date 2020/11/27 11:11
	 */
	@Override
	public Goods findGoodsById(int id) {
		try {
			conn = DBUtils.getConnection();
			// 4. 定义sql；
			String sql = "select * from t_goods where id =  '" + id + "'";

			// 5. 获取执行sql语句的对象 Statement；
			stmt = DBUtils.getStatement(conn);
			Goods good = DBUtils.executeDQLOpertionGetSingleData(stmt, sql, Goods.class);
			return good;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtils.closeDQLResources(conn, stmt, rs);
		}
		return null;
	}

	/**
	 * @Param goods:
	 * @return void
	 * @description 修改商品信息
	 * @author 优逸客大数据研发部
	 * @date 2020/11/27 11:12
	 */
	@Override
	public void updateGoods(Goods goods) {
		try {
			conn = DBUtils.getConnection();
			// 4. 定义sql；
			String sql = "update t_goods set stock = '" + goods.getStock() + "' , sales = '" + goods.getSales() + "'   where id = '" + goods.getId() + "'";
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

}
