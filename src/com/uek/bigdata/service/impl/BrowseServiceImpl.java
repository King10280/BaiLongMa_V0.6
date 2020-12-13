package com.uek.bigdata.service.impl;

import com.uek.bigdata.dao.IBrowseDao;
import com.uek.bigdata.dao.impl.BrowseDaoImpl;
import com.uek.bigdata.daomain.Goods;
import com.uek.bigdata.service.IBrowseService;

import java.util.Collection;
import java.util.List;

/**
 * @author 优逸客大数据研发部
 * @className: BrowseServiceImpl
 * @description:  商品浏览模块业务层接口实现类
 * @date: 2020/11/26 15:37
 * @version: 1.0
 */
public class BrowseServiceImpl implements IBrowseService {
	// 构建Dao对象，调用方法：
    IBrowseDao browseDao = new BrowseDaoImpl();

    /**
     * @Param :
     * @return java.util.List<com.uek.bigdata.daomain.Goods>
     * @description 查看所有商品
     * @author 优逸客大数据研发部
     * @date 2020/11/27 11:31
     */
    @Override
    public List<Goods> findAll() {
        List<Goods> goods = browseDao.selectAll();
        sort(goods);
        //2. 返回结果
        return goods;
    }

    /**
     * @Param id:
     * @return com.uek.bigdata.daomain.Goods
     * @description 根基id查找商品
     * @author 优逸客大数据研发部
     * @date 2020/11/27 11:31
     */
    @Override
    public Goods findGoodsById(int id) {
        Goods goods = browseDao.findGoodsById(id);
        //2. 返回结果
        return goods;
    }

    /**
     * @Param goods:
     * @return void
     * @description 修改商品信息
     * @author 优逸客大数据研发部
     * @date 2020/11/27 11:31
     */
    @Override
    public void updateGoods(Goods goods) {
        browseDao.updateGoods(goods);
    }

    /**
     * 冒泡排序
     *
     * @param c
     * @param <T>
     */
    public static <T extends Comparable<T>> void sort(Collection<T> c) {
        //1. 将容器转换为数组：
        Object arr[] = c.toArray();
        //2. 将容器清空，准备插入排好序的元素：
        c.clear();
        //3. 执行冒泡排序：
        bubblingSort(arr);
        //4. 将数组中已经排好序的元素，循环插入到容器中：
        for (int i = 0; i < arr.length; i++) {
            c.add((T) arr[i]);
        }
    }

    /**
     * 对象数组排序：冒泡排序
     */
    public static void bubblingSort(Object[] arr) {
        //1. 获取数组长度：
        int length = arr.length;
        //2. 标记：是否产生排序
        boolean sorted = true;
        //3. 控制排序次数：
        for (int j = 0; j < length - 1; j++) {
            sorted = true;
            //4. 元素两两之间比较大小：
            for (int i = 0; i < length - 1 - j; i++) {
                //5. 当满足条件时，产生位置交换：
                if (((Comparable) arr[i]).compareTo(arr[i + 1]) > 0) { //强转为Comparable接口
                    Object temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                    sorted = false;
                }
            }
            //6. 当没有发生位置交换，排序终止：
            if (sorted) {
                break;
            }
        }
    }
}
