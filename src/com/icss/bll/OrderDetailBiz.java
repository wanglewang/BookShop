package com.icss.bll;

import java.util.List;

import com.icss.dll.OrderDetailDao;
import com.icss.entity.OrderDetail;
import com.icss.exception.InputEmptyException;

public class OrderDetailBiz {

	public List<OrderDetail> getOrderDetail(String oid)throws Exception {
		if(oid==null) {
			throw new InputEmptyException("入参不能为空");
		}
		OrderDetailDao dao = new OrderDetailDao();
		try {
			return dao.getOrderdetailList(oid);	
		} finally {
			dao.closeConnection();
		}		
	}
}
