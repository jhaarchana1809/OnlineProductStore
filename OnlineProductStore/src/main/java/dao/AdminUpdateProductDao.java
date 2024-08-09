package dao;

import java.nio.file.attribute.AclEntry;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import bean.ProductBean;
import dbConnection.DBConnection;

public class AdminUpdateProductDao {
	
	public 	int k=0;
	public int updateProduct(ProductBean pb)
	{
		Connection con=DBConnection.getConnection();
		try {
			PreparedStatement ps=con.prepareStatement("update product63 set price=?, qty=? where code=?");
			ps.setDouble(1, pb.getPrice());
			ps.setInt(2, pb.getQty());
			ps.setString(3, pb.getPcode());
			k = ps.executeUpdate();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return k;
	}

}
