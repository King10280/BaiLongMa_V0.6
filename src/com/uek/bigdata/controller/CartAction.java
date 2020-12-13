package com.uek.bigdata.controller;

import com.uek.bigdata.daomain.CartItem;
import com.uek.bigdata.daomain.User;
import com.uek.bigdata.service.ICartService;
import com.uek.bigdata.service.impl.CartServiceImpl;

import java.util.List;

/**
 * @author 优逸客大数据研发部
 * @className: CartAction
 * @description: 购物车模块控制器
 * @date: 2020/11/26 15:37
 * @version: 1.0
 */
public class CartAction {

    private ICartService cartService = new CartServiceImpl();

    /**
     * @Param cartItem:
     * @return void
     * @description 购物车添加商品
     * @author 优逸客大数据研发部
     * @date 2020/11/27 11:14
     */
    public void addItem(CartItem cartItem) {
        cartService.addItem(cartItem);
    }

    /**
     * @Param user:
     * @return java.util.List<com.uek.bigdata.daomain.CartItem>
     * @description 根据用户名查找购物车
     * @author 优逸客大数据研发部
     * @date 2020/11/27 11:14
     */
    public List<CartItem> findByUserName(User user) {
        return cartService.findByUsername(user);
    }

    /**
     * @Param id:
     * @return void
     * @description 删除购物车商品
     * @author 优逸客大数据研发部
     * @date 2020/11/27 11:15
     */
    public void removeItem(int id) {
        cartService.removeItem(id);
    }

    /**
     * @Param :
     * @return void
     * @description 清空购物车
     * @author 优逸客大数据研发部
     * @date 2020/11/27 11:16
     */
    public void removeAll() {
        cartService.removeAll();
    }

    /**
     * @Param :
     * @return java.util.List<com.uek.bigdata.daomain.CartItem>
     * @description 查看购物车详情
     * @author 优逸客大数据研发部
     * @date 2020/11/27 11:16
     */
    public List<CartItem> findAll() {
        return cartService.findAll();
    }

}
