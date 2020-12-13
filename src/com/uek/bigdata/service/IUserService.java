package com.uek.bigdata.service;

import com.uek.bigdata.daomain.User;

import java.util.List;

/**
 * @author 优逸客大数据研发部
 * @className: IUserService
 * @description: 用户模块业务层接口
 * @date: 2020/11/26 15:37
 * @version: 1.0
 */
public interface IUserService {

    /**
     * @Param :
     * @return List<User>
     * @description 查找所有用户
     * @author 优逸客大数据研发部
     * @date 2020/11/27 11:35
     */
    public List<User> selectAll();

    /**
     * @Param user:
     * @return void
     * @description 添加一个用户
     * @author 优逸客大数据研发部
     * @date 2020/11/27 11:36
     */
    public void add(User user);


}
