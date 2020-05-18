package com.icss.action.back;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.icss.bll.BookBiz;
import com.icss.bll.UserBiz;
import com.icss.constant.IRole;
import com.icss.dto.Book;
import com.icss.entity.User;
import com.icss.exception.UserVoilateExceptoin;
import com.icss.util.Log;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UserManageSvl
 */
@WebServlet("/back/UserManageSvl")
public class UserManageSvl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserManageSvl() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
			request.getRequestDispatcher("/WEB-INF/back/UserManage.jsp").forward(request, response);
	    	
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	     UserBiz biz =new UserBiz();try {
	    	 String pid=request.getParameter("pid");
	    boolean flag=biz.DeleteP(pid);
	    if(flag==true) {
	    	request.setAttribute("msg", "删除成功");
			request.getRequestDispatcher("/WEB-INF/back/UserManage.jsp").forward(request, response);
	    }
	    else {
	    	request.setAttribute("msg", "无此人");
			request.getRequestDispatcher("/WEB-INF/back/UserManage.jsp").forward(request, response);
	    }
	     }catch (Exception e) {
				Log.logger.error(e.getMessage(),e);
				request.setAttribute("msg", "网络异常，请和管理员联系");
				request.getRequestDispatcher("/WEB-INF/error/err.jsp").forward(request, response);
			}		
	}

}
