package com.sao.service;

import com.sao.pojo.User;

public interface IUserService {
	
	public User getUserByEmail(String userEmail);
	public void newUser(User record);
	public User getUserByName(String userName);
}
