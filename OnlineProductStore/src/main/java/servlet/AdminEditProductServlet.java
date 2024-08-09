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

@WebServlet("/edit")
public class AdminEditProductServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession hs = req.getSession(false);

		if (hs == null) {
			req.setAttribute("msg", "Session Expire...");
			req.getRequestDispatcher("msg.jsp").forward(req, resp);
		} else {
			String pCode = req.getParameter("code");
			ArrayList<ProductBean> productList = (ArrayList<ProductBean>) hs.getAttribute("productList");
			Iterator<ProductBean> it = productList.iterator();
			while (it.hasNext()) {
				ProductBean pb = (ProductBean) it.next();
				
				if (pb.getPcode().equals(pCode)) {
					hs.setAttribute("pb", pb);
					
					req.getRequestDispatcher("AdminEditProduct.jsp").forward(req, resp);
					break;
				}
			}
		}

	}
}
