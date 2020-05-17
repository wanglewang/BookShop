package com.anglewang.service;

import java.sql.SQLException;

import com.anglewang.dao.UserDao;
import com.anglewang.entity.User;
import com.anglewang.exception.InputEmptyException;
import com.anglewang.exception.UserVoilateExceptoin;

public class UserServiceImpl implements UserService{

	public boolean validUserName(String userName) throws InputEmptyException,Exception{
		if(userName==null || userName.equals("")) {
			throw new InputEmptyException("�û�������Ϊ��");
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
			throw new InputEmptyException("�û���β���Ϊ��");
		}
		UserDao dao = new UserDao();
		try {
			//��ѯһ���û����Ƿ��ظ�
			User userInSQL = dao.getUserByUserName(user.getUserName());
			//�������û�
			if(userInSQL!=null) {				
				System.out.println("�û����ظ�....");
				throw new UserVoilateExceptoin("�û����ظ�������������...");
			}else {
				//���ظ�
				dao.insertUser(user);
			}	
		} finally {
			dao.closeConnection();
		}
	}
	@Override
	public User login(String userName, String pwd) throws ClassNotFoundException, SQLException {
		//�ж��û��������벻��Ϊ��
		if(userName == null || pwd == null || userName.trim().equals("") || pwd.trim().equals("")) {
			throw new InputEmptyException("�û���������Ϊ��,���޸� ...");
		}
	    UserDao dao = new UserDao();
	    try {
	    	return dao.getUserByUserNameAndPwd(userName, pwd);
		} finally {
			dao.closeConnection();
		}   
	}
	
}
