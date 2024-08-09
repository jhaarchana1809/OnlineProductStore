package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import bean.ProductBean;
import dbConnection.DBConnection;

public class AdminDeleteDao {
	int k=0;
	public int deleteProduct(ProductBean pb)
	{
		Connection con=DBConnection.getConnection();
		try {
			PreparedStatement ps=con.prepareStatement("delete from product63 where code=?");
			ps.setString(1, pb.getPcode());
			k=ps.executeUpdate();
			
			
		} catch (Exception e) {
			e.printStackTrace();	}

		return k;
}
}