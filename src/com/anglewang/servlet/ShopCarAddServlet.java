package com.anglewang.servlet;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ShopCarAddServlet
 */
@WebServlet("/user/shopCarAdd")
public class ShopCarAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ShopCarAddServlet() {
        super();
    }
    
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String isbn=request.getParameter("isbn");
		Map<String,Integer> shopCar=(Map<String, Integer>) request.getSession().getAttribute("shopCar");
		shopCar.put(isbn, 1);
		request.getRequestDispatcher("/user/shopCar").forward(request, response);
	}

}
