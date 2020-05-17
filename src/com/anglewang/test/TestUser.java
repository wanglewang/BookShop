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
				//��¼ʧ��
				System.out.println("��¼ʧ�ܣ�����������");
			}else {
				if(user.getRole()==IRole.ADMIN) {
					System.out.println("����Ա��ã����½�ɹ���");
				}
			}
		} catch(InputEmptyException ie) {
			System.out.println("�û���������Ϊ�գ����޸�");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
