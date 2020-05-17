package com.anglewang.servlet;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.anglewang.entity.Book;
import com.anglewang.service.BookService;
import com.anglewang.service.BookServiceImpl;
import com.anglewang.util.Log;

/**
 * Servlet implementation class ShopCarServlet
 */
@WebServlet("/user/shopCar")
public class ShopCarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ShopCarServlet() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Map<String,Integer> shopCar=(Map<String, Integer>) request.getSession().getAttribute("shopCar");
		//提取图书的完整信息
		
		BookService bookService=new BookServiceImpl();
		try {
			List<Book> bookList=bookService.getBookList(shopCar.keySet());
			request.setAttribute("books", bookList);
			request.getRequestDispatcher("/WEB-INF/main/shopCar.jsp").forward(request,response);
		} catch (Exception e) {
			Log.logger.error(e.getMessage(),e);
			request.setAttribute("msg", "网络异常，请和管理员联系");
			request.getRequestDispatcher("/WEB-INF/error/err.jsp").forward(request, response);
		}
	}

}
