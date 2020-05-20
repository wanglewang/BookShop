package com.icss.dll;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import com.icss.dto.Book;
import com.icss.entity.User;
import com.icss.util.OrderUtil;

public class UserDao extends BaseDao{
	
	/**
	 * �û��ۿ����ֵ
	 * @param uname
	 * @param account  ������ʾ��ֵ��������ʾ�ۿ�
	 * @throws Exception
	 */
	public int updateUserAccount(String uname,double account) throws Exception{
		int iRet;
		
		String sql = "update tuser set account=account+? where uname=?";
		this.openConnection();
		PreparedStatement ps = this.conn.prepareStatement(sql);
		ps.setDouble(1,account);
		ps.setString(2,uname);
		iRet = ps.executeUpdate();
		ps.close();
		
		return iRet;
	}
	
	/**
	 * �����¶���
	 * @param uname
	 * @param allMoney
	 * @return    ���ض������
	 * @throws Exception
	 */
	public String addOrder(String uname,double allMoney) throws Exception{

		String oid = OrderUtil.createNewOrderNo();
		String sql = "insert into torder values(?,?,?,?,?)";
		this.openConnection();
		PreparedStatement ps = this.conn.prepareStatement(sql);
		ps.setString(1, oid);
		ps.setString(2,uname);
		ps.setDouble(3,allMoney);
		ps.setTimestamp(4,new java.sql.Timestamp(new Date().getTime()));
		ps.setString(5,"δ����");
		ps.executeUpdate();
		ps.close();
		
		return oid;
	}
	
	/**
	 * ���һ��������ϸ
	 * @param orderNo
	 * @param book
	 * @throws Exception
	 */
	public void addOrderDetail(String orderNo,Book book) throws Exception{		
		//��Ӷ�����ϸ
		String sql = "insert into TOrderDetail(oid,isbn,buyNum,rprice) values(?,?,?,?)";
		this.openConnection();
		PreparedStatement ps = this.conn.prepareStatement(sql);
		ps.setString(1,orderNo);
		ps.setString(2,book.getIsbn());
		ps.setInt(3,book.getBuynum());
		ps.setDouble(4,book.getDiscount()*book.getPrice());
		ps.executeUpdate();
		ps.close();			
		//����ͼ����(��һ�������У����ݿ�����ӱ���һ��)
		BookDao bookDao = new BookDao();
		bookDao.setConn(this.getConn());  //�ѵ�ǰ��������ݿ����Ӹ�ֵ��bookDao
		bookDao.updateBookNum(book.getIsbn(),-book.getBuynum());
	}
	

	/**
	 * У���û����Ƿ��ͻ
	 * @param uname
	 * @return  true ��ʾ�û�����ͻ     false����ͻ
	 * @throws Exception
	 */
	public boolean validUname(String uname) throws Exception{
		boolean bRet = false;
		
		String sql = "select uname from tuser where uname=?";
		this.openConnection();
		PreparedStatement ps = this.conn.prepareStatement(sql);
		ps.setString(1,uname);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
		   bRet = true;	
		}
		rs.close();
		ps.close();
		
		return bRet;		
	}
	
	
	/**
	 * �û���¼
	 * @param uname �û���
	 * @param pwd   ����
	 * @return      ���ص�¼�ɹ����û�����
	 * @throws Exception
	 */
	public User login(String uname , String pwd) throws Exception {
		User user = null;
		
		//������¼sql
		String sql = "select * from tuser where uname=? and pwd=?";
		//�����ݿ�
		this.openConnection();
		
		//PreparedStatement����ִ��sql���
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, uname);
		ps.setString(2, pwd);
		//���ؽ����
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			user = new User();
			user.setUname(uname);
			user.setPwd(pwd);
			user.setRole(rs.getInt("role"));
			user.setTel(rs.getString("tel"));
			user.setRtime(rs.getTimestamp("rtime"));
			user.setAccount(rs.getDouble("account"));
			break;
		}
		rs.close();
		ps.close();
		
				
		return user;
	}
	
	/**
	 * �û�ע��
	 * @param user
	 * @throws Exception
	 */
	public void regist(User user) throws Exception {
		String sql="insert into tuser values(?,?,?,?,?)";
		this.openConnection();
		PreparedStatement ps = this.conn.prepareStatement(sql);
		ps.setString(1,user.getUname());
		ps.setString(2, user.getPwd());
		ps.setInt(3,user.getRole());
		ps.setString(4,user.getTel());
		if(user.getRtime() != null) {
			ps.setTimestamp(5,new java.sql.Timestamp(user.getRtime().getTime()));	
		}else {
			ps.setTimestamp(5, null);
		}
		ps.executeUpdate();
		ps.close();		
	}
	
	/**
	 * 
	 * @param uname
	 * @return
	 * @throws Exception
	 */
	public boolean validUserName(String uname) throws Exception {
		boolean bRet = false;
		
        String sql = "select uname from tuser where uname=?";		
		this.openConnection();
		PreparedStatement ps = this.conn.prepareStatement(sql);
		ps.setString(1, uname);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
		  bRet = true;	
		}
		rs.close();
		ps.close();
		
		return bRet;
	}

	public boolean updateUserInfo(String newpw, String uname)throws Exception {
		// TODO Auto-generated method stub
		String sql = "update tuser set pwd=? where uname=?";		
		this.openConnection();
		PreparedStatement ps = this.conn.prepareStatement(sql);
		ps.setString(1, newpw);
		ps.setString(2,uname);
		int i=ps.executeUpdate();

		ps.close();
		if(i==1) {
			return true;
		}
		else {
			return false;
		}
	}

	public boolean DeleteP(String pid) throws Exception {
		// TODO Auto-generated method stub
		String sql="delete from tuser where uname=?";
		this.openConnection();
		PreparedStatement ps = this.conn.prepareStatement(sql);
		ps.setString(1,pid);
		int i=ps.executeUpdate();
		ps.close();
		if(i==0) {
			return false;
		}
		else {
			return true;
		}
	}

	public double UpdatePrice(double price, String uname) throws Exception {
		// TODO Auto-generated method stub
		String sql = "update tuser set account=account+? where uname=?";		
		this.openConnection();
		PreparedStatement ps = this.conn.prepareStatement(sql);
		ps.setDouble(1,price);
		ps.setString(2,uname);
		ps.close();
		String sql1 = "select * from tuser where uname=?";
		PreparedStatement ps1 = conn.prepareStatement(sql1);
		ps1.setString(1, uname);
		ResultSet rs1 = ps.executeQuery();
		double account =rs1.getDouble("account");
		ps1.close();
		rs1.close();
		return account;
	}
}
