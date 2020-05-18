package com.icss.bll;

import java.sql.SQLException;
import java.util.List;
import java.util.Set;

import com.icss.dll.BookDao;
import com.icss.dto.Book;
import com.icss.exception.InputEmptyException;

public class BookBiz {
	
	/**
	 * 提取购物车中的图书信息
	 * @param isbns
	 * @return
	 * @throws Exception
	 */
	public List<Book> getBookList(Set<String> isbns) throws Exception {
		List<Book> books = null;
		
		if(isbns == null) {
			throw new Exception("isbns入参不能为空");
		}	
		if(isbns.size() >0) {
			BookDao dao = new BookDao();
			try {
				books = dao.getBookList(isbns);	
			} finally {
				dao.closeConnection();
			}	
		}
		
		return books;		
	}
	
	/**
	 * 提取图书详情信息
	 * @param isbn
	 * @return
	 * @throws Exception
	 */
	public Book getBookInfo(String isbn)throws Exception {
		if(isbn==null) {
			throw new InputEmptyException("入参isbn不能为空");
		}
		BookDao dao = new BookDao();
		try {
			return dao.getBookInfo(isbn);	
		} finally {
			dao.closeConnection();
		}		
	}
	
	/**
	 * 获得主页图书列表
	 * @return
	 * @throws Exception
	 */
	public List<Book> getMainBooks( ) throws Exception {
		BookDao dao = new BookDao();
		try {
			return dao.getMainBooks();	
		} finally {
			dao.closeConnection();
		}		
	}

	public void Add(Book book) throws Exception  {
		// TODO Auto-generated method stub
		BookDao dao = new BookDao();
		try {
			dao.AddNewBook(book);

		} finally {
			dao.closeConnection();
		}		
	}

	public boolean Delete(Book book) throws Exception{
		// TODO Auto-generated method stub
		BookDao dao = new BookDao();
		boolean flag=false;
		try {
			flag=dao.DeleteBook(book);

		} finally {
			dao.closeConnection();
			
		}	return flag;
	}

	public boolean Addnum(int result, String isbn) throws Exception{
		// TODO Auto-generated method stub
		BookDao dao = new BookDao();
		
		boolean flag=false;
		try {
			flag=dao.AddNum(result,isbn);
		} finally {
			dao.closeConnection();
		
		}	
		return flag;
	}

	public boolean UpdatePrice(double price, String isbn)throws Exception {
		// TODO Auto-generated method stub
		BookDao dao = new BookDao();
		boolean flag=false;
		try {
			flag=dao.updateprice(price,isbn);

		} finally {
			dao.closeConnection();
		
		}
		return flag;
	}

	
	

}
