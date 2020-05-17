package com.anglewang.service;

import java.util.List;
import java.util.Set;

import com.anglewang.entity.Book;

public interface BookService {
	/**
	 * �����ҳͼ���б�
	 * @return
	 * @throws Exception
	 */
	public List<Book> getMainBooks() throws Exception;
	/**
	 * ����isbn��ȡ�鼮����
	 * @param isbn
	 * @return
	 * @throws Exception
	 */
	public Book getBookInfo(String isbn)throws Exception;
	/**
	 * �����鼮isbn��ȡBook��Ϣ
	 * @param isbns
	 * @return
	 * @throws Exception
	 */
	public List<Book> getBookList(Set<String> isbns) throws Exception;
}
