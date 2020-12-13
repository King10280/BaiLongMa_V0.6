package com.uek.bigdata.controller;

import com.uek.bigdata.daomain.Goods;
import com.uek.bigdata.service.IBrowseService;
import com.uek.bigdata.service.impl.BrowseServiceImpl;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 优逸客大数据研发部
 * @className: BrowseAction
 * @description: 商品浏览模块控制器
 * @date: 2020/11/26 15:37
 * @version: 1.0
 */
public class BrowseAction {
    //构建service对象，调用方法：
    IBrowseService browseService = new BrowseServiceImpl();

    /**
     * 显示所有商品信息
     *
     * @return
     */
    public List<Goods> showAll() {
        List<Goods> goods = browseService.findAll();
        //2. 返回结果
        return goods;
    }

    /**
     * @return com.uek.bigdata.daomain.Goods
     * @Param id:
     * @description 根据id查找对应商品
     * @author 优逸客大数据研发部
     * @date 2020/11/27 11:01
     */
    public Goods findGoodsById(int id) {
        Goods goods = browseService.findGoodsById(id);
        //2. 返回结果
        return goods;
    }

    /**
     * @return void
     * @Param goods:
     * @description 修改商品信息
     * @author 优逸客大数据研发部
     * @date 2020/11/27 11:02
     */
    public void updateGoods(Goods goods) {
        browseService.updateGoods(goods);
        //2. 返回结果
    }

    /**
     * @return java.util.List<com.uek.bigdata.daomain.Goods>
     * @Param name:
     * @Param category:
     * @description 查询商品实现方法
     * @author 优逸客大数据研发部
     * @date 2020/11/27 11:01
     */
    public List<Goods> queryGoods(String name, String category) {

        List<Goods> good = new ArrayList<>(); //定义查询列表

        String goodsName = name;
        if (goodsName == null)      //用户名为空
            goodsName = "";

        List<Goods> goodsList = this.showAll();      //获取所有的商品

        for (Goods goods : goodsList) {         //遍历所有商品
            if ((goods.getName().contains(goodsName))       //找到符合条件的
                    && (category == null || goods.getCategory().equals(category))
            ) {
                good.add(goods);        //添加到集合中
            }
        }
        //返回结果
        return good;

    }


}
