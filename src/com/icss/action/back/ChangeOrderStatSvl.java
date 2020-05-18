package com.icss.action.back;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.icss.bll.OrderBiz;
import com.icss.entity.Order;
import com.icss.util.Log;

/**
 * Servlet implementation class ChangeOrderStatSvl
 */
@WebServlet("/back/ChangeOrderStatSvl")
public class ChangeOrderStatSvl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangeOrderStatSvl() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Order order =new Order();
		OrderBiz biz=new OrderBiz();
		try {
			biz.changeStat(request.getParameter("oid"));
			request.setAttribute("msg", "成功配送");
			request.getRequestDispatcher("/WEB-INF/back/DealOrder.jsp").forward(request, response);
		} catch (ClassNotFoundException | SQLException e) {
			Log.logger.error(e.getMessage(),e);
			request.setAttribute("msg", "网络异常，请和管理员联系");
			request.getRequestDispatcher("/WEB-INF/error/err.jsp").forward(request, response);
		}
	}

}
