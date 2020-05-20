package com.icss.action.back;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.icss.bll.BookBiz;
import com.icss.exception.UserVoilateExceptoin;
import com.icss.util.Log;

/**
 * Servlet implementation class BookUpdatePriceSvl
 */
@WebServlet("/back/BookUpdatePriceSvl")
public class BookUpdatePriceSvl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookUpdatePriceSvl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("/WEB-INF/back/BookUpdatePrice.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			String  price = request.getParameter("price");
			String  isbn =request.getParameter("isbn");
			double Price = Double.parseDouble(price);
			 BookBiz biz=new BookBiz();
			 boolean flag=biz.UpdatePrice(Price,isbn);
			 if(flag==true) {
				 request.setAttribute("msg", "成功");
				 request.getRequestDispatcher("/WEB-INF/back/BookUpdatePrice.jsp").forward(request, response);
			 }
			 else {request.setAttribute("msg", "无此书");
				 request.getRequestDispatcher("/WEB-INF/back/BookUpdatePrice.jsp").forward(request, response);
			 }
			 }
                       catch (Exception e) {
					Log.logger.error(e.getMessage(),e);
					request.setAttribute("msg", "输入错误");
					request.getRequestDispatcher("/WEB-INF/back/BookUpdatePrice.jsp").forward(request, response);
				}		
			
	}

}
