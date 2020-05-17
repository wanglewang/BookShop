package com.anglewang.servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.anglewang.constant.IRole;
import com.anglewang.entity.User;
import com.anglewang.exception.UserVoilateExceptoin;
import com.anglewang.service.UserService;
import com.anglewang.service.UserServiceImpl;
import com.anglewang.util.Log;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/main/regist.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user = new User();
		user.setUserName(request.getParameter("uname"));
		user.setPwd(request.getParameter("pwd"));
		user.setPhone(request.getParameter("tel"));
		user.setRole(IRole.CUSER);   //所有注册的都是普通用户
		user.setGmtCreated(new Date());
		UserService userService = new UserServiceImpl();
		try {
			userService.register(user);
			//注册成功，转到登录页
			request.setAttribute("msg", "注册成功，请重新登录...");
			request.getRequestDispatcher("/WEB-INF/main/login.jsp").forward(request, response);
		}catch(UserVoilateExceptoin e) {
			Log.logger.error(e.getMessage(),e);
			request.setAttribute("msg", "用户名冲突，请重新录入...");
			request.getRequestDispatcher("/WEB-INF/main/regist.jsp").forward(request, response);
		} catch (Exception e) {
			Log.logger.error(e.getMessage(),e);
			request.setAttribute("msg", "网络异常，请和管理员联系");
			request.getRequestDispatcher("/WEB-INF/error/err.jsp").forward(request, response);
		}		
	}
}
