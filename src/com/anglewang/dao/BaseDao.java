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
			Log.logger.info("打开一个新的数据库连接....");
		}else {
			Log.logger.info("使用原有数据库连接....");
		}		
	}
	
	public void closeConnection() {
		if(conn != null) {
			try {
				conn.close();
				Log.logger.info("数据库关闭...");
			} catch (Exception e) {
				e.printStackTrace();
			}			
		}		
	}
}
