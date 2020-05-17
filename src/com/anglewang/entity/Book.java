package com.anglewang.entity;

import java.io.Serializable;
import java.util.Date;

public class Book implements Serializable{
	private static final long serialVersionUID = 1L;
//	private String bid;
//	private String bname;//����
//	private String author;//����
//	private String publish;//������
//	private String publishTime;//����ʱ��
//	private String pic;//����
//	private String intro;//���
//	private Double discount;//�ۿ�
//	private Double price;//�۸�
//	private Integer quantity;//�������
	private String isbn;
	private String cid;
	private String bname;
	private String author;
	private String press;
	private Date   pdate;
	private String pic;
	private String   info;
	private double   discount;
	private double   price;
	private int    num;
	
	
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getCid() {
		return cid;
	}
	public void setCid(String cid) {
		this.cid = cid;
	}
	public String getBname() {
		return bname;
	}
	public void setBname(String bname) {
		this.bname = bname;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getPress() {
		return press;
	}
	public void setPress(String press) {
		this.press = press;
	}
	public Date getPdate() {
		return pdate;
	}
	public void setPdate(Date pdate) {
		this.pdate = pdate;
	}
	public String getPic() {
		return pic;
	}
	public void setPic(String pic) {
		this.pic = pic;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public double getDiscount() {
		return discount;
	}
	public void setDiscount(double discount) {
		this.discount = discount;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
}
