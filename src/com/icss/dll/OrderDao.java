package com.icss.dll;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.icss.dto.Book;
import com.icss.entity.Order;
import com.icss.entity.OrderDetail;

public class OrderDao  extends BaseDao{
	public List<Order> getOrderList(String uname) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
	List<Order> orders;
		
		int i=0;
		String sql = "select * from torder where uname='"+ uname + "';";
		this.openConnection();
		PreparedStatement ps = this.conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		orders = new ArrayList<>();
		while(rs.next()) {
			Order order = new Order();
			order.setAllMoney(rs.getDouble("allmoney"));
			order.setOid(rs.getString("oid"));
			order.setPayTime(rs.getDate("paytime"));
			order.setStat(rs.getString("stat"));
			order.setUname(uname);
			orders.add(order);
		}
		rs.close();
		ps.close();	
		return orders;
		
	}

	public List<Order> getAllOrderList() throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
	List<Order> orders;
		
		int i=0;
		String sql = "select * from torder where stat='δ����'";
		this.openConnection();
		PreparedStatement ps = this.conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		orders = new ArrayList<>();
		while(rs.next()) {
			Order order = new Order();
			order.setAllMoney(rs.getDouble("allmoney"));
			order.setOid(rs.getString("oid"));
			order.setPayTime(rs.getDate("paytime"));
			order.setUname(rs.getString("uname"));
			orders.add(order);
		}
		rs.close();
		ps.close();	
		return orders;
			}

	public void ChangeStat(String oid) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		String sql = "update torder set stat='������' where oid='"+oid+"';";
		this.openConnection();
		PreparedStatement ps = this.conn.prepareStatement(sql);
		ps.executeUpdate();
		ps.close();
	}
}