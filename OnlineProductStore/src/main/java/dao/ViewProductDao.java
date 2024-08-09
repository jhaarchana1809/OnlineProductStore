package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import bean.ProductBean;
import dbConnection.DBConnection;

public class ViewProductDao {
	
	ArrayList<ProductBean> productList=new ArrayList<ProductBean>();
	
	public ArrayList<ProductBean> viewProduct()
	{
		try {
			Connection con= DBConnection.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from product63");
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				ProductBean pb= new ProductBean();
				pb.setPcode(rs.getString(1));
				pb.setName(rs.getString(2));
				pb.setPrice(rs.getDouble(3));
				pb.setQty(rs.getInt(4));
				
				
				productList.add(pb);//add product to list
				
				
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return productList;
	}

}
