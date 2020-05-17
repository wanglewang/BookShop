package com.anglewang.service;

import java.util.List;
import java.util.Set;

import com.anglewang.entity.Book;

public interface BookService {
	/**
	 * 获得主页图书列表
	 * @return
	 * @throws Exception
	 */
	public List<Book> getMainBooks() throws Exception;
	/**
	 * 根据isbn获取书籍详情
	 * @param isbn
	 * @return
	 * @throws Exception
	 */
	public Book getBookInfo(String isbn)throws Exception;
	/**
	 * 根据书籍isbn获取Book信息
	 * @param isbns
	 * @return
	 * @throws Exception
	 */
	public List<Book> getBookList(Set<String> isbns) throws Exception;
}
