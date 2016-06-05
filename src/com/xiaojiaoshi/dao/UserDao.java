package com.xiaojiaoshi.dao;

import org.springframework.stereotype.Repository;

import com.xiaojiaoshi.model.User;

@Repository("userDao")
public class UserDao extends BaseDao<User> implements IUserDao
{

}
