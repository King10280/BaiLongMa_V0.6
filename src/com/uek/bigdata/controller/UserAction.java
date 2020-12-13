package com.uek.bigdata.controller;

import com.uek.bigdata.daomain.User;
import com.uek.bigdata.service.IUserService;
import com.uek.bigdata.service.impl.UserServiceImpl;

import java.util.List;

/**
 * @author 优逸客大数据研发部
 * @className: UserAction
 * @description: 用户模块控制器
 * @date: 2020/11/26 15:37
 * @version: 1.0
 */
public class UserAction {
	private IUserService userService = new UserServiceImpl();

	/**
	 * @Param username:
	 * @Param password:
	 * @return com.uek.bigdata.daomain.User
	 * @description 登录方法
	 * @author 优逸客大数据研发部
	 * @date 2020/11/27 11:06
	 */
	public User login(String username, String password) {
		// 获取用户列表
		List<User> users = userService.selectAll();

		// 循环判断用户输入的账号和密码在数据集合中是否存在。
		for (int i = 0; i < users.size(); i++) {
			User user = users.get(i);
			if (user.getUsername().equals(username) && user.getPassword().equals(password))
				return user;
		}
		// 无对应用户数据返回null
		return null;
	}

}
