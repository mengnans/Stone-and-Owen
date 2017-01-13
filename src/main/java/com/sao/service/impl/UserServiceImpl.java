package com.sao.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.sao.dao.UserMapper;
import com.sao.pojo.User;
import com.sao.service.IUserService;

@Service("UserService")
public class UserServiceImpl implements IUserService{
	
	@Resource
	private UserMapper userDao;
	
	public User getUserById(int userId) {
		return this.userDao.selectByPrimaryKey(userId);
	}

}
