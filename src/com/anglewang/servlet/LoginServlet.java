package com.anglewang.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.anglewang.constant.IRole;
import com.anglewang.entity.User;
import com.anglewang.exception.InputEmptyException;
import com.anglewang.service.UserService;
import com.anglewang.service.UserServiceImpl;
import com.anglewang.util.Log;

@WebServlet(urlPatterns="/login",loadOnStartup=1)
public class LoginServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	/**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        Log.logger.info("UserServlet��ʼ��..............");
    }

	/**
	 * �������ַ�����͵�������get
	 * GET����ת���¼ҳ
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			   throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/main/login.jsp").forward(request, response);
	}

	/**
	 * ���ύһ����post����
	 * ��post�����з������ݿ⣬���е�¼У��
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String uname = request.getParameter("uname");
		String pwd = request.getParameter("pwd");
		UserService userService = new UserServiceImpl();
		PrintWriter out=response.getWriter();
		try {
			User user = userService.login(uname, pwd);
			if(user != null) {
				//��ʾ��¼�ɹ���ת�������ҳ				
//				if(user.getRole() == IRole.ADMIN) {
//					request.setAttribute("msg", uname + "��¼�ɹ������ǹ���Ա");
//				}else if(user.getRole() == IRole.VIP_USER) {
//					request.setAttribute("msg", uname + "��¼�ɹ�������VIP�û�");
//				}else if(user.getRole() == IRole.CUSER) {
//					request.setAttribute("msg",uname + "��¼�ɹ���������ͨ�û�");
//				}else {					
//					request.setAttribute("msg",uname + "��¼�ɹ�������쳣");
//				}
//				request.getRequestDispatcher("/WEB-INF/main/main.jsp").forward(request, response);
				request.getSession().setAttribute("usr", user);
				request.getSession().setAttribute("shopCar", new HashMap<String,Integer>());
				out.print("1");
			}else {
				//��ʾ��¼ʧ��
//				request.setAttribute("msg", "��¼ʧ�ܣ�����������...");
//				request.getRequestDispatcher("/WEB-INF/main/login.jsp").forward(request, response);
				out.print("0");
			}
		} catch (InputEmptyException e) {
//			request.setAttribute("msg",e.getMessage());
//			request.getRequestDispatcher("/WEB-INF/main/login.jsp").forward(request, response);
			out.print("-2");
		} catch (Exception e) {
			//�׸�����Ա�����쳣��Ϣ
			Log.logger.error(e.getMessage(),e);
			//���û������쳣��Ϣ
//			request.getRequestDispatcher("/WEB-INF/error/err.jsp").forward(request, response);
			out.print("-1");
		}		
		out.flush();
		out.close();
	}

}
