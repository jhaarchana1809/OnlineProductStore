package servlet;

import java.io.IOException;

import bean.ProductBean;
import dao.AddProductDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@SuppressWarnings("serial")
@WebServlet("/product")
public class AddProductServlet extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession hs=req.getSession(false);//Access Existing Session
		
		if(hs==null)
		{
			req.setAttribute("msg", "Session Expired....");
			req.getRequestDispatcher("msg.jsp").forward(req, resp);
			
		}
		else
		{
			ProductBean pb = new ProductBean();
			pb.setPcode(req.getParameter("code"));
			pb.setName(req.getParameter("name"));
			pb.setPrice(Double.parseDouble(req.getParameter("price")));
			pb.setQty( Integer.parseInt(req.getParameter("quantity")));
			int k=new AddProductDao().addProduct(pb);
			if(k>0)
			{
				req.setAttribute("msg", "Product added!");
				req.getRequestDispatcher("addProduct.jsp").forward(req, resp);
			}
			
		}
	}

}
