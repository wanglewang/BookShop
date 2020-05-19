package com.icss.action.back;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.icss.bll.BookBiz;
import com.icss.dto.Book;
import com.icss.util.Log;

/**
 * Servlet implementation class BookAddSvl
 */
@WebServlet("/back/BookAddSvl")
@MultipartConfig(maxFileSize=1024*100)
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
		//提取所有目录信息
		
		request.getRequestDispatcher("/WEB-INF/back/bookAdd.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Book book = new Book();
		Part part = null;
		try {
			//获取Part对象
			part = request.getPart("pic");
			//获取磁盘路径
			String path = request.getServletContext().getRealPath("/bkpic");
			String fileName = path + "/" + part.getSubmittedFileName();
			if(!part.getSubmittedFileName().equals("")) {
				part.write(fileName);	
				book.setPic("/bkpic/" + part.getSubmittedFileName());		
			}			
			String isbn = request.getParameter("isbn");
			String bname = request.getParameter("bname");		
			String author = request.getParameter("author");
			String press = request.getParameter("press");		
			String cid = request.getParameter("ca");	
			String price = request.getParameter("price");
			double dPrice = 0;
			try {
				dPrice = Double.parseDouble(price);
				if(dPrice<=0) {
					throw new ServletException("图书价格不能为小于或等于0");
				}
			} catch (Exception e) {
				Log.logger.info(e.getMessage(),e);
				throw new ServletException("图书价格录入错误！");
			}
			String pdate = request.getParameter("pdate");
			Date pubDate = null;
			try {
				if(!pdate.equals("")) {
					SimpleDateFormat sd = new SimpleDateFormat("MM/dd/yyyy");
					pubDate = sd.parse(pdate);	
				}				
			} catch (Exception e) {
				Log.logger.error(e.getMessage(),e);
			}			
			book.setIsbn(isbn);
			book.setAuthor(author);
			book.setBname(bname);
			book.setCid(cid);
			book.setPress(press);
			book.setPrice(dPrice);
			book.setPdate(pubDate);
			book.setDiscount(1.0);
			book.setInfo("图书介绍...");
			book.setNum(0);			
			BookBiz biz = new BookBiz();
			try {
				biz.Add(book);			
				request.setAttribute("msg",bname+ "--上传成功");
				request.getRequestDispatcher("/WEB-INF/back/bookAdd.jsp").forward(request, response);
			}catch(java.sql.SQLIntegrityConstraintViolationException e) {
				request.setAttribute("msg","ISBN冲突，请重新录入");
				request.getRequestDispatcher("/WEB-INF/back/bookAdd.jsp").forward(request, response);
			} catch (Exception e) {
				Log.logger.error(e.getMessage(),e);
				request.setAttribute("msg", "网络异常，请和管理员联系");
				request.getRequestDispatcher("/WEB-INF/error/err.jsp").forward(request, response);
			}	
		} catch (java.lang.IllegalStateException e) {
			request.setAttribute("msg",e.getMessage());			
			request.getRequestDispatcher("/WEB-INF/error/uploadMaxError.jsp").forward(request, response);	
		}			
	}
}
