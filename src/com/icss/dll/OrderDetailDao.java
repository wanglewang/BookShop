package com.icss.dll;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.icss.entity.Order;
import com.icss.entity.OrderDetail;

public class OrderDetailDao extends BaseDao {

	public List<OrderDetail> getOrderdetailList(String oid) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
	List<OrderDetail> ods;
	int i=0;
	String sql = "select * from torderdetail where oid="+ oid + ";";
	this.openConnection();
	PreparedStatement ps = this.conn.prepareStatement(sql);
	ResultSet rs = ps.executeQuery();
	ods = new ArrayList<>();
	while(rs.next()) {
		OrderDetail od = new OrderDetail();
		od.setDno(rs.getLong("dno"));
		od.setBuyNum(rs.getInt("buynum"));
		od.setIsbn(rs.getString("isbn"));
		od.setOid(rs.getString("oid"));
		od.setRprice(rs.getDouble("rprice"));
		ods.add(od);
	}
	rs.close();
	ps.close();	
	return ods;
	}

}
