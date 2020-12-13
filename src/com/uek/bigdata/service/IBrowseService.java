package com.uek.bigdata.service;

import com.uek.bigdata.daomain.Goods;

import java.util.List;

/**
 * @author 优逸客大数据研发部
 * @className: IBrowseService
 * @description:  商品浏览模块业务层接口
 * @date: 2020/11/26 15:37
 * @version: 1.0
 */
public interface IBrowseService {

    /**
     * 显示所有商品信息
     */
    public List<Goods> findAll();

    /*
     *根据id找到符合商品
     * */
    public Goods findGoodsById(int id);

    /*
    * 修改商品信息
    * */
    public void updateGoods(Goods goods);

}
