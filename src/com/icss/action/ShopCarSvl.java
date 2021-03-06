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
import com.icss.dto.Book;
import com.icss.util.Log;

/**
 * Servlet implementation class ShopCarSvl
 */
@WebServlet("/user/ShopCarSvl")
public class ShopCarSvl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShopCarSvl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {	
		
		Map<String,Integer> shopCar = (Map<String,Integer>)request.getSession().getAttribute("shopCar");
		//提取图书的完整信息
		BookBiz biz = new BookBiz();
		try {
			List<Book> books = biz.getBookList(shopCar.keySet());
			request.setAttribute("books", books);
			request.getRequestDispatcher("/WEB-INF/main/shopCar.jsp").forward(request, response);		
		} catch (Exception e) {
			Log.logger.error(e.getMessage(),e);
			request.setAttribute("msg", "网络异常，请和管理员联系");
			request.getRequestDispatcher("/WEB-INF/error/err.jsp").forward(request, response);
		}	
		
	}



}
