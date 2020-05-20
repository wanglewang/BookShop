package com.icss.action.back;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.icss.bll.OrderBiz;
import com.icss.entity.UniteInfo;
import com.icss.util.Log;


/**
 * Servlet implementation class SaleTopSvl
 */
@WebServlet("/back/SaleTopSvl")
public class SaleTopSvl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SaleTopSvl() {
        super();
        // TODO Auto-generated constructor stub
    }
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Log.logger.info(".isEmpty()");
		OrderBiz biz = new OrderBiz();
		try {
			Log.logger.info(".isEmpty()");
			List<UniteInfo> uniteinfo = biz.getSaleStat();
			Log.logger.info(uniteinfo.isEmpty());
			request.setAttribute("units", uniteinfo);
			Log.logger.info(uniteinfo.isEmpty());
			request.getRequestDispatcher("/WEB-INF/back/SaleTop.jsp").forward(request, response);
		}catch (Exception e) {
			Log.logger.error(e.getMessage(),e);
			request.setAttribute("msg", "网络异常，请和管理员联系");
			request.getRequestDispatcher("/WEB-INF/error/err.jsp").forward(request, response);
		}		
	}
}
