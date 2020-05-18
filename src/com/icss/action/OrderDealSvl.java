package com.icss.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.icss.bll.BookBiz;
import com.icss.bll.OrderBiz;
import com.icss.dto.Book;
import com.icss.entity.Order;
import com.icss.entity.User;
import com.icss.util.Log;

/**
 * Servlet implementation class OrderDealSvl
 */
@WebServlet("/user/OrderDealSvl")
public class OrderDealSvl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderDealSvl() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		OrderBiz biz = new OrderBiz();
		try {
			
			Object object = request.getSession().getAttribute("user");
				User user = (User)object;
			List<Order> Orders = biz.getOrderList(user.getUname());	
			request.setAttribute("Orders", Orders);
			request.getRequestDispatcher("/WEB-INF/main/OrderDeal.jsp").forward(request, response);
		} catch (Exception e) {
			Log.logger.error(e.getMessage(),e);
			request.setAttribute("msg", "网络异常，请和管理员联系");
			request.getRequestDispatcher("/WEB-INF/error/err.jsp").forward(request, response);
		}		
	}

}
