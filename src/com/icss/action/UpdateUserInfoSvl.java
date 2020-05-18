package com.icss.action;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.icss.bll.BookBiz;
import com.icss.bll.UserBiz;
import com.icss.dto.Book;
import com.icss.entity.User;
import com.icss.util.Log;

/**
 * Servlet implementation class UpdateUserInfoSvl
 */
@WebServlet("/user/UpdateUserInfoSvl")
public class UpdateUserInfoSvl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateUserInfoSvl() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/main/updateInfo.jsp").forward(request, response);			
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		UserBiz biz = new UserBiz();
		User user = (User)request.getSession().getAttribute("user");
		String uname=user.getUname();
		try {
		boolean flag=biz.updatePW(request.getParameter("pwd"),uname);
		if(flag==true) {
			request.setAttribute("msg", "成功");
			request.getRequestDispatcher("/WEB-INF/main/updateInfo.jsp").forward(request, response);}
		else {
			request.setAttribute("msg", "无此人");
			request.getRequestDispatcher("/WEB-INF/main/updateInfo.jsp").forward(request, response);
		}
		} catch (Exception e) {
			Log.logger.error(e.getMessage(),e);
			request.setAttribute("msg", "网络异常，请和管理员联系");
			request.getRequestDispatcher("/WEB-INF/error/err.jsp").forward(request, response);
		}		
		
	}


}


