package com.icss.action.back;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.icss.bll.BookBiz;
import com.icss.bll.OrderBiz;
import com.icss.bll.UserBiz;
import com.icss.constant.IRole;
import com.icss.dto.Book;
import com.icss.entity.Order;
import com.icss.entity.UniteInfo;
import com.icss.entity.User;
import com.icss.exception.UserVoilateExceptoin;
import com.icss.util.Log;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BuyinfoListSvl
 */
@WebServlet("/back/BuyinfoListSvl")
public class BuyinfoListSvl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BuyinfoListSvl() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		OrderBiz biz = new OrderBiz();
		try {
			List<UniteInfo> uniteinfo = biz.getUniteInfo();	
			Log.logger.info(String.valueOf(uniteinfo.size()));
			request.setAttribute("units", uniteinfo);
			request.setAttribute("NUM", uniteinfo.size());
			request.getRequestDispatcher("/WEB-INF/back/BuyinfoList.jsp").forward(request, response);
		}catch (Exception e) {
			Log.logger.error(e.getMessage(),e);
			request.setAttribute("msg", "网络异常，请和管理员联系");
			request.getRequestDispatcher("/WEB-INF/error/err.jsp").forward(request, response);
		}		
	}

}
