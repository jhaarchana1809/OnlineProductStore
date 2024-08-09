package servlet;

import java.io.IOException;
import java.util.ArrayList;

import bean.ProductBean;
import dao.ViewProductDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@WebServlet("/viewProduct")
public class ViewProductServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession hs=req.getSession();
		if(hs==null)
		{
			req.setAttribute("msg", "Session Expired...");
			req.getRequestDispatcher("msg.jsp").forward(req, resp);
			
		}
		else
		{
			ArrayList<ProductBean> list=new ViewProductDao().viewProduct();
			hs.setAttribute("productList",list);
			req.getRequestDispatcher("viewProduct.jsp").forward(req, resp);
		}
	}
	

}
