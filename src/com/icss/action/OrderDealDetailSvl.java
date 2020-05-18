package com.icss.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.icss.bll.OrderDetailBiz;
import com.icss.entity.OrderDetail;

/**
 * Servlet implementation class OrderDealDetailSvl
 */
@WebServlet("/user/OrderDealDetailSvl")
public class OrderDealDetailSvl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderDealDetailSvl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("/WEB-INF/main/OrderDealDetail.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<OrderDetail> ods;
         String Oid=request.getParameter("oid");
         OrderDetailBiz biz=new OrderDetailBiz();
        try {ods=biz.getOrderDetail(Oid);
			request.setAttribute("ods" ,ods);
	 		request.getRequestDispatcher("/WEB-INF/main/OrderDealDetail.jsp").forward(request, response);
		}
        catch (Exception e) {
			// TODO Auto-generated catch block
			request.setAttribute("msg", "网络异常，请和管理员联系");
			request.getRequestDispatcher("/WEB-INF/error/err.jsp").forward(request, response);
			e.printStackTrace();
		}

	}

}
