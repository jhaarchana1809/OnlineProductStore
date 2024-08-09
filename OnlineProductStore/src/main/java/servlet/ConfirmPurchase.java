package servlet;

import java.io.IOException;

import bean.ProductBean;
import dao.AdminUpdateProductDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/confirmPurchase")
public class ConfirmPurchase extends HttpServlet{
	
	
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
			int qty=Integer.parseInt(req.getParameter("quantity"));
			String name=req.getParameter("buyerName");
			ProductBean pb =(ProductBean) hs.getAttribute("pb");
			Double price = pb.getPrice();
			String pname = pb.getName();
			if(pb.getQty()>=qty)
			{
				int currentQty=pb.getQty()-qty;
				pb.setQty(currentQty);
				int k = new AdminUpdateProductDao().updateProduct(pb);
				hs.setAttribute("cname", name);
				req.setAttribute("qty", qty);
				req.setAttribute("price", price);
				req.setAttribute("pName", pname);
				req.getRequestDispatcher("confirm.jsp").forward(req, resp);
			}
			else if(pb.getQty()==0)
			{
				req.setAttribute("msg", "Out of Stock");
				req.getRequestDispatcher("outOfStock.jsp").forward(req, resp);
			}
			else
			{
				req.setAttribute("msg", "Out of Stock");
				req.getRequestDispatcher("outOfStock.jsp").forward(req, resp);
			}
		}
	
	
	
	}

}
