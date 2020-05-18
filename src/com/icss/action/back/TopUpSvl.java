package com.icss.action.back;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.icss.bll.BookBiz;
import com.icss.bll.UserBiz;
import com.icss.exception.UserVoilateExceptoin;
import com.icss.util.Log;

/**
 * Servlet implementation class TopUpSvl
 */
@WebServlet("/back/TopUpSvl")
public class TopUpSvl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TopUpSvl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("/WEB-INF/back/TopUp.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			String  price = request.getParameter("price");
			String  uname=request.getParameter("pid");
			double Price = Integer.parseInt(price);
			 UserBiz biz=new UserBiz();
			double monny= biz.UpdatePrice(Price,uname);
			String M=String.valueOf(monny);
				request.setAttribute("msg", "充值成功,余额为"+M);	 
				request.getRequestDispatcher("/WEB-INF/back/TopUp.jsp").forward(request, response);
		}
		catch (Exception e) {
			Log.logger.error(e.getMessage(),e);
			request.setAttribute("msg", "网络异常，请和管理员联系");
			request.getRequestDispatcher("/WEB-INF/error/err.jsp").forward(request, response);
		}	
	}

}
