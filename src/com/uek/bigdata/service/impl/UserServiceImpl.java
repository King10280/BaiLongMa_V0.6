package com.uek.bigdata.service.impl;

import com.uek.bigdata.dao.IUserDao;
import com.uek.bigdata.dao.impl.UserDaoImpl;
import com.uek.bigdata.daomain.User;
import com.uek.bigdata.service.IUserService;

import java.util.List;

/**
 * @author 优逸客大数据研发部
 * @className: UserServiceImpl
 * @description: 用户浏览模块业务层接口实现类
 * @date: 2020/11/26 15:37
 * @version: 1.0
 */
public class UserServiceImpl implements IUserService {

    IUserDao userDao = new UserDaoImpl();
    /**
     * @Param null:
     * @return
     * @description 查看所有用户
     * @author 优逸客大数据研发部
     * @date 2020/11/27 11:34
     */
    @Override
    public List<User> selectAll() {
        return userDao.selectAll();
    }

    /**
     * @Param user:
     * @return void
     * @description 添加用户
     * @author 优逸客大数据研发部
     * @date 2020/11/27 11:34
     */
    @Override
    public void add(User user) {
        userDao.add(user);
    }
}
