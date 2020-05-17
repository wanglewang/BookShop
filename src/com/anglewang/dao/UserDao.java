package com.anglewang.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.anglewang.entity.User;

public class UserDao extends BaseDao{
	
	/**
	 * 根据用户名和密码获取用户
	 * @param userName
	 * @param pwd
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public User getUserByUserNameAndPwd(String userName,String pwd) throws ClassNotFoundException, SQLException {
		User user=null;
		//创建登录sql
		String sql = "select * from tuser where uname=? and pwd=?";
		//打开数据库
		this.openConnection();
				
		//PreparedStatement用于执行sql语句
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, userName);
		ps.setString(2, pwd);
		//返回结果集
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			user = new User();
			user.setUserName(userName);
			user.setPwd(pwd);
			user.setRole(rs.getInt("role"));
			user.setPhone(rs.getString("phone"));
			break;
		}
		rs.close();
		ps.close();
		this.closeConnection();
		return user;
	}
	/**
	 * 根据用户名获取用户
	 * @param userName
	 * @param pwd
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public User getUserByUserName(String userName) throws ClassNotFoundException, SQLException {
		User user=null;
		//创建登录sql
		String sql = "select * from tuser where uname=?";
		//打开数据库
		this.openConnection();
				
		//PreparedStatement用于执行sql语句
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, userName);
		//返回结果集
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			user = new User();
			user.setUserName(userName);
			user.setPwd(rs.getString("pwd"));
			user.setRole(rs.getInt("role"));
			user.setPhone(rs.getString("phone"));
			break;
		}
		rs.close();
		ps.close();
		return user;
	}

	/**
	 * 插入用户
	 * @param user
	 * @throws Exception
	 */
	public void insertUser(User user) throws Exception{
		String sql="insert into user values(?,?,?,?,?,?,?)";
		this.openConnection();
		PreparedStatement ps = this.conn.prepareStatement(sql);
		ps.setString(1,user.getUserId());
		ps.setString(2, user.getUserName());
		ps.setString(3, user.getPwd());
		ps.setInt(4, user.getRole());
		ps.setString(5,user.getPhone());
		Date date = new Date(System.currentTimeMillis());
		ps.setDate(6, date);
		ps.setDate(7, date);
		
		ps.executeUpdate();
		ps.close();		
	}
	
}
