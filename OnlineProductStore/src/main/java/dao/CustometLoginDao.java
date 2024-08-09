package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bean.AdminBean;
import bean.CustomerBean;
import dbConnection.DBConnection;

public class CustometLoginDao {
	
	CustomerBean cb=null;
	
	public CustomerBean login(String uname, String pwd)
	{
		Connection con=DBConnection.getConnection();
		try {
			PreparedStatement ps=con.prepareStatement("select * from customer63 where uname=? and pword=?");
			ps.setString(1, uname);
			ps.setString(2, pwd);
			ResultSet rs= ps.executeQuery();
			if(rs.next())
			{
				cb = new CustomerBean();
				cb.setuName(rs.getString(1));
				cb.setPwd(rs.getString(2));
				cb.setfName(rs.getString(3));
				cb.setlName(rs.getString(4));
				cb.setAddress(rs.getString(5));
				cb.setEmailId(rs.getString(6));
				cb.setPhNo(rs.getLong(7));			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cb;
	}


}
