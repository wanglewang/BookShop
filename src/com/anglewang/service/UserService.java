package com.anglewang.service;

import java.sql.SQLException;

import com.anglewang.entity.User;
import com.anglewang.exception.InputEmptyException;

public interface UserService {
	/**
	 * У���û����Ƿ��ͻ
	 * @param uname
	 * @return
	 * @throws InputEmptyException
	 * @throws Exception
	 */
	public boolean validUserName(String uname) throws InputEmptyException,Exception;
	/**
	 * �û�ע��
	 * @param user
	 * @throws Exception
	 */
	void register(User user) throws Exception;
	/**
	 * �û���¼
	 * @param userName
	 * @param pwd
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	User login(String userName,String pwd) throws ClassNotFoundException, SQLException;
}
