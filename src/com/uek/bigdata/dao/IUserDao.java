package com.uek.bigdata.dao;

import com.uek.bigdata.daomain.User;

import java.util.List;

/**
 * @author 优逸客大数据研发部
 * @className: IUserDao
 * @description: 用户模块Dao层接口
 * @date: 2020/11/26 15:37
 * @version: 1.0
 */
public interface IUserDao {

   /**
    * @Param user:
    * @return void
    * @description 用户添加
    * @author 优逸客大数据研发部
    * @date 2020/11/27 11:22
    */
    public void add(User user);

    /**
     * @Param :
     * @return java.util.List<com.uek.bigdata.daomain.User>
     * @description 查找所有用户
     * @author 优逸客大数据研发部
     * @date 2020/11/27 11:22
     */
    public List<User> selectAll();
}
