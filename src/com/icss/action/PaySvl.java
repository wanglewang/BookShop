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
import com.icss.bll.UserBiz;
import com.icss.dto.Book;
import com.icss.entity.User;
import com.icss.util.Log;

/**
 * Servlet implementation class PaySvl
 */
@WebServlet("/user/PaySvl")
public class PaySvl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PaySvl() {
        super();
        // TODO Auto-generated constructor stub
    }



	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		//无需接收参数		
		User user = (User)request.getSession().getAttribute("user");
		Map<String,Integer> shopCar = (Map<String,Integer>)request.getSession().getAttribute("shopCar");
		BookBiz bookBiz = new BookBiz();		
		try {
			//提取图书的价格、折扣等信息
			List<Book> books = bookBiz.getBookList(shopCar.keySet());			
			//计算图书总价
			double allMoney = 0;
			for(Book bk : books) {
				bk.setBuynum(shopCar.get(bk.getIsbn()));     
				allMoney += bk.getPrice() * bk.getDiscount() * bk.getBuynum() ;
			}
			UserBiz userBiz = new UserBiz();
			userBiz.payMoney(user.getUname(), allMoney, books);
			//付款成功，更新会话中的用户余额
			user.setAccount(user.getAccount()-allMoney);
			//付款成功，重定向到成功页
			String path = request.getContextPath();
			String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
			response.sendRedirect(basePath + "user/PayOkSvl?allMoney=" + allMoney );
		} catch (Exception e) {
			Log.logger.error(e.getMessage(),e);
			request.setAttribute("msg", "网络异常，请和管理员联系");
			request.getRequestDispatcher("/WEB-INF/error/err.jsp").forward(request, response);
		}
		
	}

}
