package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import bean.ProductBean;
import dao.AdminUpdateProductDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/update")
public class AdminUpdateProductServlet extends HttpServlet{

	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession hs=req.getSession(false);
		
		if(hs==null)
		{
			req.setAttribute("msg", "Session Expired...");
			req.getRequestDispatcher("msg.jsp").forward(req, resp);
		}
		else
		{
			String pCode=req.getParameter("code");
			double pPrice=Double.parseDouble(req.getParameter("price"));
			int pQty= Integer.parseInt(req. getParameter("quantity"));
			
			ArrayList<ProductBean> list=(ArrayList<ProductBean>)hs.getAttribute("productList");
			Iterator<ProductBean > it=list.iterator();
			while(it.hasNext())
			{
				ProductBean pb=it.next();
				if(pCode.equals(pb.getPcode()))
				{
					pb.setPrice(pPrice);
					pb.setQty(pQty);
					int k= new AdminUpdateProductDao().updateProduct(pb);
					if(k>0)
					{
						req.setAttribute("msg", "Product Updated Successfully...");
						req.getRequestDispatcher("updateProduct.jsp").forward(req, resp);
						
					}
					break;
				}
			}
		}
	}
}
