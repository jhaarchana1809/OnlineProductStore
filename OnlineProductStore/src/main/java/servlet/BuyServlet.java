package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import bean.ProductBean;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/buy")
public class BuyServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	HttpSession hs=req.getSession(false);
	if(hs==null)
	{
		req.setAttribute("msg", "Session Expired...");
		req.getRequestDispatcher("msg.jsp").forward(req, resp);
	}
	else
	{
		String pCode=req.getParameter("code");
		ArrayList<ProductBean> list=(ArrayList<ProductBean>)hs.getAttribute("productList");
		Iterator<ProductBean > it=list.iterator();
		while(it.hasNext())
		{
			ProductBean pb=it.next();
			if(pCode.equals(pb.getPcode()))
			{
				hs.setAttribute("pb", pb);
				if(pb.getQty()>0)
				{
				req.getRequestDispatcher("buyProduct.jsp").forward(req, resp);
				}
				else
				{
					req.setAttribute("msg", "Out of Stock");
					req.getRequestDispatcher("outOfStock.jsp").forward(req, resp);
				}
				break;
			}
		}
	}
	
	}
}
