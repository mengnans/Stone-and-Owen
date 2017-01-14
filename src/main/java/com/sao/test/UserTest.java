package com.sao.test;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;
import com.sao.pojo.User;
import com.sao.service.IUserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})
public class UserTest {
	
	private static Logger logger = Logger.getLogger(TestMybatis.class);
	
	@Resource
	private IUserService userService = null;


	@Test
	public void test1() throws Exception {
		User user = userService.getUserByEmail("thundersmn@outlook.com");
		logger.info(JSON.toJSONString(user));
		
		
		logger.info(JSON.toJSONString(user));
	}
	
}
