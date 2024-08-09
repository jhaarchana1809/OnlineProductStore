package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import bean.CustomerBean;
import dbConnection.DBConnection;

public class CustomerRegisterDao {
	int k=0;
		
	public int registerCusomer(CustomerBean cb)
	{
		try {
			
			Connection con=DBConnection.getConnection();
			PreparedStatement ps= con.prepareStatement("insert into customer63 values(?,?,?,?,?,?,?)");
			ps.setString(1, cb.getuName());
			ps.setString(2, cb.getPwd());
			ps.setString(3, cb.getfName());
			ps.setString(4, cb.getlName());
			ps.setString(5, cb.getAddress());
			ps.setString(6, cb.getEmailId());
			ps.setLong(7, cb.getPhNo());
			k=ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return k;
	}
	
	
	

}
