package com.sao.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.sao.dao.IUser_tDao;
import com.sao.pojo.User_t;
import com.sao.service.IUser_tService;

@Service("user_tService")
public class User_tServiceImpl implements IUser_tService{
	
	@Resource
	private IUser_tDao userDao;
	
	public User_t getUserById(int userId) {
		return this.userDao.selectByPrimaryKey(userId);
	}

}
