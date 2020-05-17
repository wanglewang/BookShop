package com.anglewang.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.anglewang.util.DbInfo;
import com.anglewang.util.Log;
public abstract class BaseDao {
	protected Connection conn;
	
	public void openConnection() throws SQLException,ClassNotFoundException {
		if(this.conn == null || this.conn.isClosed()) {
			DbInfo db = DbInfo.instance();
			Class.forName(db.getDriver());
			conn = DriverManager.getConnection(db.getUrl(),db.getUname(),db.getPwd());
			Log.logger.info("��һ���µ����ݿ�����....");
		}else {
			Log.logger.info("ʹ��ԭ�����ݿ�����....");
		}		
	}
	
	public void closeConnection() {
		if(conn != null) {
			try {
				conn.close();
				Log.logger.info("���ݿ�ر�...");
			} catch (Exception e) {
				e.printStackTrace();
			}			
		}		
	}
}
