package com.uek.bigdata.service;

import com.uek.bigdata.daomain.CartItem;
import com.uek.bigdata.daomain.User;

import java.util.List;

/**
 * @author 优逸客大数据研发部
 * @className: ICartService
 * @description: 购物车模块业务层接口
 * @date: 2020/11/26 15:37
 * @version: 1.0
 */
public interface ICartService {

    /**
     * @Param cartItem:  
     * @return void
     * @description 添加购物车商品
     * @author 优逸客大数据研发部
     * @date 2020/11/27 11:36 
     */
    public void addItem(CartItem cartItem);

    /**
     * @Param id:  
     * @return void
     * @description 根据id删除商品
     * @author 优逸客大数据研发部
     * @date 2020/11/27 11:36 
     */
    public void removeItem(int id);

    /**
     * @Param :  
     * @return void
     * @description 清空购物车
     * @author 优逸客大数据研发部
     * @date 2020/11/27 11:37 
     */
    public void removeAll();

    /**
     * @Param id: 
     * @Param count:  
     * @return void
     * @description 修改数量
     * @author 优逸客大数据研发部
     * @date 2020/11/27 11:37 
     */
    public void modifyCount(int id, int count);

    /**
     * @Param :
     * @return java.util.List<com.uek.bigdata.daomain.CartItem>
     * @description 查找所有的商品
     * @author 优逸客大数据研发部
     * @date 2020/11/27 11:37
     */
    public List<CartItem> findAll();

    /**
     * @Param user:
     * @return java.util.List<com.uek.bigdata.daomain.CartItem>
     * @description 根据用户名查找购物车商品
     * @author 优逸客大数据研发部
     * @date 2020/11/27 11:37
     */
    public List<CartItem> findByUsername(User user);

}
