package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import bean.ProductBean;
import dbConnection.DBConnection;

public class AddProductDao {
	
	public int k=0;
	public int addProduct(ProductBean p)
	{
		try {
			
			Connection con=DBConnection.getConnection();
			PreparedStatement ps=con.prepareStatement("insert into Product63 values(?,?,?,?)");
			ps.setString(1, p.getPcode()); 
			ps.setString(2, p.getName()); 
			ps.setDouble(3, p.getPrice()); 
			ps.setInt(4, p.getQty()); 
			k=ps.executeUpdate();
			
		} catch (Exception e) {
			
		e.printStackTrace();
		}
		return k;
	}

}
