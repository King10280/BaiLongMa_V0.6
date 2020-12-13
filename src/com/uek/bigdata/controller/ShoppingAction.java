package com.uek.bigdata.controller;

import com.uek.bigdata.daomain.CartItem;
import com.uek.bigdata.daomain.Goods;
import com.uek.bigdata.daomain.User;
import com.uek.bigdata.exception.CartyException;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

/**
 * @author 优逸客大数据研发部
 * @className: ShoppingAction
 * @description: 购物车
 * @date: 2020/11/26 15:37
 * @version: 1.0
 */
public class ShoppingAction
        extends HashMap<Goods, Integer> {

    BrowseAction browseAction = new BrowseAction();

    private static final long serialVersionUID = 1L;

    /**
     * 将商品放入购物车
     *
     * @param goods    书籍对象
     * @param quantity 购买的数量
     * @throws
     */
    public void buy(Goods goods, Integer quantity, User user) throws CartyException {
        //判断所要购买的书籍的库存是否满足用户的购买需求，如果不满足，则抛出异常并中止购买行为。
        if (goods.getStock() < quantity)
            throw new CartyException("书籍：《" + goods.getName() + "》库存不足，无法满足您的购买需要。");
        // 如果满足购买需求，则继续处理
        // 判断用户是否已经购买了当前书籍
        Integer num = super.get(goods);

        if (num != null)
            // 购买了当前书籍，则书籍数量增加quantity
            num += quantity;
        else
            // 如果没有购买过，则书籍数量赋值为quantity
            num = quantity;

        super.put(goods, num);

        // 减去库存
        goods.setStock(goods.getStock() - 1);

        //增加销售
        goods.setSales(goods.getSales() + 1);

        CartAction cartAction = new CartAction();

        CartItem cartItem = new CartItem();//用来放购物车的数据

        cartItem.setUserId(user.getUsername());//用户id 就是用户账号
        cartItem.setId(goods.getId());
        cartItem.setName(goods.getName());
        cartItem.setCount(num);
        cartItem.setPrice(goods.getPrice());
        cartItem.setTotalPrice(num * goods.getPrice()); //计算总价

        cartAction.addItem(cartItem);   //添加方法

        browseAction.updateGoods(goods);    //修改商品方法

    }

    @Override
    public String toString() {
        StringBuffer buffer = new StringBuffer("");
        Set<Goods> keys = super.keySet();
        Iterator<Goods> looper = keys.iterator();

        // 循环显示购物车中用户购买的书籍
        while (looper.hasNext()) {
            Goods goods = looper.next();
            buffer.append(goods + " 购买了：" + super.get(goods) + "件\r\n");
        }
        return buffer.toString();
    }

}

