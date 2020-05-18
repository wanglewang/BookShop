package com.icss.bll;

import java.sql.SQLException;
import java.util.List;
import java.util.Set;

import com.icss.dll.BookDao;
import com.icss.dto.Book;
import com.icss.exception.InputEmptyException;

public class BookBiz {
	
	/**
	 * ��ȡ���ﳵ�е�ͼ����Ϣ
	 * @param isbns
	 * @return
	 * @throws Exception
	 */
	public List<Book> getBookList(Set<String> isbns) throws Exception {
		List<Book> books = null;
		
		if(isbns == null) {
			throw new Exception("isbns��β���Ϊ��");
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
	 * ��ȡͼ��������Ϣ
	 * @param isbn
	 * @return
	 * @throws Exception
	 */
	public Book getBookInfo(String isbn)throws Exception {
		if(isbn==null) {
			throw new InputEmptyException("���isbn����Ϊ��");
		}
		BookDao dao = new BookDao();
		try {
			return dao.getBookInfo(isbn);	
		} finally {
			dao.closeConnection();
		}		
	}
	
	/**
	 * �����ҳͼ���б�
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
