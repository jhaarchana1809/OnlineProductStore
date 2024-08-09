package servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/customerlogout")
public class CustomerLogOutServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession hs=req.getSession(false);
		if(hs==null)
		{
			req.setAttribute("msg", "Session Expired....");
			req.getRequestDispatcher("msg.jsp").forward(req, resp);
	
		}
		else
		{
			hs.removeAttribute("productList");
			hs.removeAttribute("cbean");
			hs.invalidate();
			req.setAttribute("msg", "Log Out Successfully..");
			req.getRequestDispatcher("logout.jsp").forward(req, resp);
		}
	}

}
