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
import com.icss.entity.UniteInfo;

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
		String sql = "select * from torder where stat='Œ¥≈‰ÀÕ'";
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
		String sql = "update torder set stat='“—≈‰ÀÕ' where oid='"+oid+"';";
		this.openConnection();
		PreparedStatement ps = this.conn.prepareStatement(sql);
		ps.executeUpdate();
		ps.close();
	}

	public List<UniteInfo> getUniteInfo() throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
List<UniteInfo> unites;
		String sql = "select a.uname,b.bname,c.paytime,c.allmoney,c.stat from tuser a join tbook b join torder c join torderdetail d on a.uname=c.uname and c.oid=d.oid and b.isbn=d.isbn;";
		this.openConnection();
		PreparedStatement ps = this.conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		unites = new ArrayList<>();
		while(rs.next()) {
			UniteInfo unite = new UniteInfo();
			unite.setAllMoney(rs.getDouble("allmoney"));
			unite.setBname(rs.getString("bname"));
			unite.setPayTime(rs.getDate("paytime"));
			unite.setUname(rs.getString("uname"));
			unite.setStat(rs.getString("stat"));
			unites.add(unite);
		}
		rs.close();
		ps.close();	
		return unites;
	}

	public List<UniteInfo> SeekUniteInfo(String uname) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
        List<UniteInfo> unites;
		String sql = "select a.uname,b.bname,c.paytime,c.allmoney,c.stat from tuser a join tbook b join torder c "
				+ "join torderdetail d on a.uname=c.uname and c.oid=d.oid and b.isbn=d.isbn and a.uname=?;";
		this.openConnection();
		PreparedStatement ps = this.conn.prepareStatement(sql);
		ps.setString(1,uname);
		ResultSet rs = ps.executeQuery();
		unites = new ArrayList<>();
		while(rs.next()) {
			UniteInfo unite = new UniteInfo();
			unite.setAllMoney(rs.getDouble("allmoney"));
			unite.setBname(rs.getString("bname"));
			unite.setPayTime(rs.getDate("paytime"));
			unite.setUname(rs.getString("uname"));
			unite.setStat(rs.getString("stat"));
			unites.add(unite);
		}
		rs.close();
		ps.close();	
		return unites;
	}

	public List<UniteInfo> getSaleStat() throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		   List<UniteInfo> unites;
			String sql = "select sum(d.buynum), b.bname from torderdetail d,torder br, tbook b where br.oid = d.oid  and b.isbn = d.isbn and br.paytime >'2015-10-1'and br.paytime <'2020-11-27'   group by b.bname";
			this.openConnection();
			PreparedStatement ps = this.conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			unites = new ArrayList<>();
			while(rs.next()) {
				UniteInfo unite = new UniteInfo();
				unite.setBname(rs.getString("bname"));
				unite.setSumNum(rs.getInt("sum(d.buynum)"));
				unites.add(unite);
			}
			rs.close();
			ps.close();	
			return unites;
	}
}
