package com.anglewang.service;

import java.util.List;
import java.util.Set;

import com.anglewang.dao.BookDao;
import com.anglewang.entity.Book;
import com.anglewang.exception.InputEmptyException;

public class BookServiceImpl implements BookService{
	
	@Override
	public List<Book> getMainBooks( ) throws Exception {
		BookDao dao = new BookDao();
		try {
			return dao.getMainBooks();	
		} finally {
			dao.closeConnection();
		}		
	}

	@Override
	public Book getBookInfo(String isbn) throws Exception {
		if(isbn==null) {
			throw new InputEmptyException("入参isbn不能为空");
		}
		BookDao bookDao=new BookDao();
		try {
			return bookDao.getBookInfo(isbn);
		}finally {
			bookDao.closeConnection();
		}
	}

	@Override
	public List<Book> getBookList(Set<String> isbns) throws Exception {
		if(isbns==null||isbns.size()==0) {
			throw new Exception("isbns入参为空");
		}
		BookDao dao = new BookDao();
		try {
			return dao.getBookList(isbns);
		}finally {
			dao.closeConnection();
		}
	}

}
