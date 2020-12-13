package com.uek.bigdata.dao;

import com.uek.bigdata.daomain.CartItem;
import com.uek.bigdata.daomain.User;

import java.util.List;

/**
 * @author 优逸客大数据研发部
 * @className: ICartDao
 * @description: 购物车模块Dao层接口
 * @date: 2020/11/26 15:37
 * @version: 1.0
 */
public interface ICartDao {

    /**
     * @Param cartItem:
     * @return void
     * @description 购物车添加信息
     * @author 优逸客大数据研发部
     * @date 2020/11/27 11:23
     */
    public void insertItem(CartItem cartItem);

    /**
     * @Param id:
     * @return void
     * @description 根据id删除购物车内的信息
     * @author 优逸客大数据研发部
     * @date 2020/11/27 11:23
     */
    public void deleteItem(int id);

    /**
     * @Param id:
     * @return com.uek.bigdata.daomain.CartItem
     * @description 根据id查找购物车商品
     * @author 优逸客大数据研发部
     * @date 2020/11/27 11:23
     */
    public CartItem selectItemById(int id);

    /**
     * @Param :
     * @return void
     * @description 清空购物车
     * @author 优逸客大数据研发部
     * @date 2020/11/27 11:23
     */
    public void deleteAll();

    /**
     * @Param id:
     * @Param count:
     * @return void
     * @description 修改商品数量
     * @author 优逸客大数据研发部
     * @date 2020/11/27 11:24
     */
    public void updateCount(int id , int count);

    /**
     * @Param id:
     * @Param count:
     * @return void
     * @description 增加数量
     * @author 优逸客大数据研发部
     * @date 2020/11/27 11:24
     */
    public void accCount(int id , int count);

    /**
     * @Param :
     * @return java.util.List<com.uek.bigdata.daomain.CartItem>
     * @description 查看所有购物车内的商品
     * @author 优逸客大数据研发部
     * @date 2020/11/27 11:25
     */
    public List<CartItem> selectAll();

    /**
     * @Param user:
     * @return java.util.List<com.uek.bigdata.daomain.CartItem>
     * @description 根据用户名查找购物车
     * @author 优逸客大数据研发部
     * @date 2020/11/27 11:25
     */
    public List<CartItem> findByUsername(User user);

    /**
     * @Param id:
     * @Param count:
     * @Param price:
     * @return void
     * @description 修改商品总数和价格
     * @author 优逸客大数据研发部
     * @date 2020/11/27 11:25
     */
    void updateTotalPrice(Integer id, Integer count, double price);

}
