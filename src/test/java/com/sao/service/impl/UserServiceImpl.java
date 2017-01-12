package com.sao.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.sao.dao.IUserDao;
import com.sao.pojo.User;
import com.sao.service.IUserService;

@Service("userService")
public class UserServiceImpl implements IUserService{
	
	@Resource
	private IUserDao userDao;
	
	public User getUserById(int userId) {
		return this.userDao.selectByPrimaryKey(userId);
	}

}
