package com.anglewang.test;

import com.anglewang.constant.IRole;
import com.anglewang.entity.User;
import com.anglewang.exception.InputEmptyException;
import com.anglewang.service.UserService;
import com.anglewang.service.UserServiceImpl;

public class TestUser {
	public static void main(String[] args) {
		UserService userService=new UserServiceImpl();
		String userName="anglewang";
		String pwd="982205";
		try {
			User user=userService.login(userName, pwd);
			if(user.getUserName()==null) {
				//登录失败
				System.out.println("登录失败，请重新输入");
			}else {
				if(user.getRole()==IRole.ADMIN) {
					System.out.println("管理员你好，你登陆成功了");
				}
			}
		} catch(InputEmptyException ie) {
			System.out.println("用户名或密码为空，请修改");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
