package com.icss.action.back;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.icss.bll.BookBiz;
import com.icss.bll.UserBiz;
import com.icss.constant.IRole;
import com.icss.dto.Book;
import com.icss.entity.User;
import com.icss.exception.UserVoilateExceptoin;
import com.icss.util.Log;

/**
 * Servlet implementation class BookAddSvl
 */
@WebServlet("/back/BookAddSvl")
public class BookAddSvl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookAddSvl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/back/bookAdd.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	try {
		Book book = new Book();
		book.setCid(request.getParameter("selectType"));
		book.setIsbn(request.getParameter("isbn"));
		book.setBname(request.getParameter("bkname"));
		book.setAuthor(request.getParameter("author"));
		book.setPress(request.getParameter("press")); 
	    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
	    String pdate=request.getParameter("publishdate");
	    Log.logger.info("asfafsa:::::"+pdate);
		book.setPdate(simpleDateFormat.parse(pdate));
		book.setPrice(Double.valueOf(request.getParameter("price"))); 
		book.setPic("asfw");
		BookBiz biz = new BookBiz();
			biz.Add(book);
			request.setAttribute("msg", "��ӳɹ�");
			request.getRequestDispatcher("/WEB-INF/back/bookAdd.jsp").forward(request, response);
		}catch(UserVoilateExceptoin e) {
			Log.logger.error(e.getMessage(),e);
			request.setAttribute("msg", "��ų�ͻ��������¼��...");
			request.getRequestDispatcher("/WEB-INF/back/bookAdd.jsp").forward(request, response);
		} catch (Exception e) {
			Log.logger.error(e.getMessage(),e);
			request.setAttribute("msg", "�����쳣����͹���Ա��ϵ");
			request.getRequestDispatcher("/WEB-INF/error/err.jsp").forward(request, response);
		}		
	}

}
