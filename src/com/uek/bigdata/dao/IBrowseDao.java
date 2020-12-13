package com.uek.bigdata.dao;

import com.uek.bigdata.daomain.Goods;

import java.util.List;

/**
 * @author 优逸客大数据研发部
 * @className: IBrowseDao
 * @description: 商品浏览模块Dao层接口
 * @date: 2020/11/26 15:37
 * @version: 1.0
 */
public interface IBrowseDao {

    /**
     * @return java.util.List<com.uek.bigdata.daomain.Goods>
     * @Param :
     * @description 查看所有商品
     * @author 优逸客大数据研发部
     * @date 2020/11/27 11:20
     */
    public List<Goods> selectAll();

    /**
     * @return
     * @Param null:
     * @description 根据id查询商品
     * @author 优逸客大数据研发部
     * @date 2020/11/27 11:21
     */
    public Goods findGoodsById(int id);

    /**
     * @Param goods:
     * @return void
     * @description 修改商品
     * @author 优逸客大数据研发部
     * @date 2020/11/27 11:21
     */
    void updateGoods(Goods goods);
}
