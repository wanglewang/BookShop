package com.anglewang.service;

import java.sql.SQLException;

import com.anglewang.dao.UserDao;
import com.anglewang.entity.User;
import com.anglewang.exception.InputEmptyException;
import com.anglewang.exception.UserVoilateExceptoin;

public class UserServiceImpl implements UserService{

	public boolean validUserName(String userName) throws InputEmptyException,Exception{
		if(userName==null || userName.equals("")) {
			throw new InputEmptyException("用户名不能为空");
		}
		UserDao dao = new UserDao();
		try {
			User user=dao.getUserByUserName(userName);
			if(user!=null) {
				return true;
			}else {
				return false;
			}
		} finally {
			dao.closeConnection();
		}
		
	}
	@Override
	public void register(User user) throws Exception {
		if(user == null ) {
			throw new InputEmptyException("用户入参不能为空");
		}
		UserDao dao = new UserDao();
		try {
			//查询一下用户名是否重复
			User userInSQL = dao.getUserByUserName(user.getUserName());
			//插入新用户
			if(userInSQL!=null) {				
				System.out.println("用户名重复....");
				throw new UserVoilateExceptoin("用户名重复，请重新输入...");
			}else {
				//无重复
				dao.insertUser(user);
			}	
		} finally {
			dao.closeConnection();
		}
	}
	@Override
	public User login(String userName, String pwd) throws ClassNotFoundException, SQLException {
		//判断用户名、密码不能为空
		if(userName == null || pwd == null || userName.trim().equals("") || pwd.trim().equals("")) {
			throw new InputEmptyException("用户名或密码为空,请修改 ...");
		}
	    UserDao dao = new UserDao();
	    try {
	    	return dao.getUserByUserNameAndPwd(userName, pwd);
		} finally {
			dao.closeConnection();
		}   
	}
	
}
