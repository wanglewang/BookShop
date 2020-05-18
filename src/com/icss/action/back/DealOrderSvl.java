package com.icss.action.back;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.icss.bll.OrderBiz;
import com.icss.bll.UserBiz;
import com.icss.entity.Order;
import com.icss.util.Log;

/**
 * Servlet implementation class DealOrderSvl
 */
@WebServlet("/back/DealOrderSvl")
public class DealOrderSvl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DealOrderSvl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		OrderBiz biz = new OrderBiz();
		try {
			List<Order> Orders = biz.getAllOrderList();	
			Log.logger.info(String.valueOf(Orders.size()));
			request.setAttribute("Orders", Orders);
			request.getRequestDispatcher("/WEB-INF/back/DealOrder.jsp").forward(request, response);
		} catch (Exception e) {
			Log.logger.error(e.getMessage(),e);
			request.setAttribute("msg", "网络异常，请和管理员联系");
			request.getRequestDispatcher("/WEB-INF/error/err.jsp").forward(request, response);
		}		
	}

}
