package com.sao.dao;

import com.sao.pojo.User_t;

public interface IUser_tDao {
    int deleteByPrimaryKey(Integer id);

    int insert(User_t record);

    int insertSelective(User_t record);

    User_t selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User_t record);

    int updateByPrimaryKey(User_t record);
}