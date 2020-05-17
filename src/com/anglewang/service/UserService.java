package com.anglewang.service;

import java.sql.SQLException;

import com.anglewang.entity.User;
import com.anglewang.exception.InputEmptyException;

public interface UserService {
	/**
	 * 校验用户名是否冲突
	 * @param uname
	 * @return
	 * @throws InputEmptyException
	 * @throws Exception
	 */
	public boolean validUserName(String uname) throws InputEmptyException,Exception;
	/**
	 * 用户注册
	 * @param user
	 * @throws Exception
	 */
	void register(User user) throws Exception;
	/**
	 * 用户登录
	 * @param userName
	 * @param pwd
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	User login(String userName,String pwd) throws ClassNotFoundException, SQLException;
}
