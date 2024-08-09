package servlet;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;

import bean.ProductBean;
import dao.AdminDeleteDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/delete")
public class AdminDeleteProductServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession hs=req.getSession(false);
		if(hs==null)
		{
			req.setAttribute("msg", "Session Expire...");
			req.getRequestDispatcher("msg.jsp").forward(req, resp);
			
		}
		else
		{
			String pCode=req.getParameter("code");
			ArrayList<ProductBean> list=(ArrayList<ProductBean>)hs.getAttribute("productList");
			Iterator<ProductBean> it=list.iterator();
			while(it.hasNext())
			{
				ProductBean pb=it.next();
				if(pb.getPcode().equals(pCode))
				{
					int k=new AdminDeleteDao().deleteProduct(pb);
					if(k>0)
					{
						req.setAttribute("msg", "Product Deleted");
						req.getRequestDispatcher("AdminDeleteProduct.jsp").forward(req, resp);
					}
					break;
				}
				
			}
			
		}
	
	}

}
