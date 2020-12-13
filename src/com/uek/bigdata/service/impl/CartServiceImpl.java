package com.uek.bigdata.service.impl;

import com.uek.bigdata.dao.ICartDao;
import com.uek.bigdata.dao.impl.CartDaoImpl;
import com.uek.bigdata.daomain.CartItem;
import com.uek.bigdata.daomain.User;
import com.uek.bigdata.service.ICartService;

import java.util.List;

/**
 * @author 优逸客大数据研发部
 * @className: CartServiceImpl
 * @description: 购物车浏览模块业务层接口实现类
 * @date: 2020/11/26 15:37
 * @version: 1.0
 */
public class CartServiceImpl implements ICartService {

    ICartDao cartDao = new CartDaoImpl();

    /**
     * @return void
     * @Param cartItem:
     * @description 添加信息到购物车
     * @author 优逸客大数据研发部
     * @date 2020/11/27 11:32
     */
    @Override
    public void addItem(CartItem cartItem) {
        /**
         * 先查看购物车中是否已经添加过此商品，如果已添加，则数量累加，总金额更新，如果没有添加过，直接放到集合中即可
         */
        //1. 根据id查找购物车中的商品
        CartItem item = cartDao.selectItemById(cartItem.getId());
        if (item != null) {
            //2. 购物车已存在当前商品：
            //2.1 商品数量累加：
            cartDao.accCount(item.getId(), item.getCount());
            //2.2 总金额更新:
            item = cartDao.selectItemById(cartItem.getId());
            cartDao.updateTotalPrice(item.getId(), item.getCount(), item.getPrice());
        } else {
            //3. 购物车没有当前商品：
            cartDao.insertItem(cartItem);
        }
    }

    /**
     * @return void
     * @Param id:
     * @description 根据id查找购物车中的商品
     * @author 优逸客大数据研发部
     * @date 2020/11/27 11:32
     */
    @Override
    public void removeItem(int id) {
        cartDao.deleteItem(id);
    }

    /**
     * @return void
     * @Param :
     * @description 清空购物车
     * @author 优逸客大数据研发部
     * @date 2020/11/27 11:33
     */
    @Override
    public void removeAll() {
        cartDao.deleteAll();
    }

    /**
     * @return void
     * @Param id:
     * @Param count:
     * @description 修改购物车商品数量
     * @author 优逸客大数据研发部
     * @date 2020/11/27 11:33
     */
    @Override
    public void modifyCount(int id, int count) {

        cartDao.updateCount(id, count);

        CartItem item = cartDao.selectItemById(id);
        cartDao.updateTotalPrice(item.getId(), item.getCount(), item.getPrice());
    }

    /**
     * @return java.util.List<com.uek.bigdata.daomain.CartItem>
     * @Param :
     * @description 查找所有
     * @author 优逸客大数据研发部
     * @date 2020/11/27 11:33
     */
    @Override
    public List<CartItem> findAll() {
        return cartDao.selectAll();
    }

    /**
     * @return
     * @Param null:
     * @description 根据用户查找购物车信息
     * @author 优逸客大数据研发部
     * @date 2020/11/27 14:45
     */
    @Override
    public List<CartItem> findByUsername(User user) {
        return cartDao.findByUsername(user);
    }
}
