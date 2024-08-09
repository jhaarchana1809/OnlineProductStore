package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bean.AdminBean;
import dbConnection.DBConnection;

public class AdminLoginDao {
	
	AdminBean ab=null;
	
	public AdminBean login(String uname, String pwd)
	{
		Connection con=DBConnection.getConnection();
		try {
			PreparedStatement ps=con.prepareStatement("select * from admin63 where uname=? and pword=?");
			ps.setString(1, uname);
			ps.setString(2, pwd);
			ResultSet rs= ps.executeQuery();
			if(rs.next())
			{
				ab = new AdminBean();
				ab.setuName(rs.getString(1));
				ab.setpWord(rs.getString(2));
				ab.setfName(rs.getString(3));
				ab.setlName(rs.getString(4));
				ab.setAddr(rs.getString(5));
				ab.setmId(rs.getString(6));
				ab.setPhno(rs.getLong(7));			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ab;
	}

}
