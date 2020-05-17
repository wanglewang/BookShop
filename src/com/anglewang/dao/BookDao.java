package com.anglewang.dao;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.anglewang.entity.Book;

public class BookDao extends BaseDao{
	/**
	 * 获得主页图书列表
	 * @return
	 * @throws Exception
	 */
	public List<Book> getMainBooks( ) throws Exception {
		List<Book> books;
		
		String sql = "select * from tbook";
		this.openConnection();
		PreparedStatement ps = this.conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		books = new ArrayList<>();
		while(rs.next()) {
			Book bk = new Book();
			bk.setAuthor(rs.getString("author"));
			bk.setBname(rs.getString("bname"));
			bk.setCid(rs.getString("cid"));
			bk.setDiscount(rs.getDouble("discount"));
			bk.setInfo(rs.getString("info"));
			bk.setIsbn(rs.getString("isbn"));
			bk.setNum(rs.getInt("num"));
			bk.setPdate(rs.getDate("pdate"));
			bk.setPic(rs.getString("pic"));
			bk.setPress(rs.getString("press"));
			bk.setPrice(rs.getDouble("price"));
			books.add(bk);
		}
		rs.close();
		ps.close();
		
		return books;
	}
	public Book getBookInfo(String isbn) throws Exception{
		Book book=new Book();
		String sql = "select * from tbook where isbn=?";
		this.openConnection();
		PreparedStatement ps = this.conn.prepareStatement(sql);
		ps.setString(1,isbn);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			book.setAuthor(rs.getString("author"));
			book.setBname(rs.getString("bname"));
			book.setCid(rs.getString("cid"));
			book.setDiscount(rs.getDouble("discount"));
			book.setInfo(rs.getString("info"));
			book.setIsbn(rs.getString("isbn"));
			book.setNum(rs.getInt("num"));
			book.setPdate(rs.getDate("pdate"));
			book.setPic(rs.getString("pic"));
			book.setPress(rs.getString("press"));
			book.setPrice(rs.getDouble("price"));
		}
		rs.close();
		ps.close();
		
		return book;
		
	}
	public List<Book> getBookList(Set<String> isbns) throws Exception{
		List<Book> books;
		
		int i=0;
		String allISBN = "";
		for(String isbn : isbns) {
			if(i==0) {
				allISBN = "'" + isbn + "'";
			}else {
				allISBN = allISBN + ",'" + isbn + "'"; 
			}
			i++;
		}		
		String sql = "select * from tbook where isbn in (" + allISBN + ")";
		this.openConnection();
		PreparedStatement ps = this.conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		books = new ArrayList<>();
		while(rs.next()) {
			Book bk = new Book();
			bk.setAuthor(rs.getString("author"));
			bk.setBname(rs.getString("bname"));
			bk.setCid(rs.getString("cid"));
			bk.setDiscount(rs.getDouble("discount"));
			bk.setInfo(rs.getString("info"));
			bk.setIsbn(rs.getString("isbn"));
			bk.setNum(rs.getInt("num"));
			bk.setPdate(rs.getDate("pdate"));
			bk.setPic(rs.getString("pic"));
			bk.setPress(rs.getString("press"));
			bk.setPrice(rs.getDouble("price"));
			books.add(bk);
		}
		rs.close();
		ps.close();	
		
		return books;
		
	}
}
