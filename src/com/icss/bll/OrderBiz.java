package com.icss.bll;

import java.sql.SQLException;
import java.util.List;
import java.util.Set;

import com.icss.dll.OrderDao;
import com.icss.entity.Order;
import com.icss.entity.UniteInfo;

public class OrderBiz {
	public List<Order> getOrderList(String uname) throws Exception {
		List<Order> orders = null;
		
		if(uname == null) {
			throw new Exception("用户名不能为空");
		}	
			OrderDao dao = new OrderDao();
			try {
				orders = dao.getOrderList(uname);	
			} finally {
				dao.closeConnection();
			}	
		
		
		return orders;		
	}

	public List<Order> getAllOrderList() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		List<Order> orders = null;
		OrderDao dao = new OrderDao();
		try {
			orders = dao.getAllOrderList();	
		} finally {
			dao.closeConnection();
		}	
	
	return orders;		
	}

	public void changeStat(String Oid) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		OrderDao dao = new OrderDao();
		try {
			dao.ChangeStat(Oid);	
		} finally {
			dao.closeConnection();
		}	
	}

	public List<UniteInfo> getUniteInfo() {
		// TODO Auto-generated method stub
		return null;
	}
}
