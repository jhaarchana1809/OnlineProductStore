package servlet;

import java.io.IOException;

import bean.AdminBean;
import bean.CustomerBean;
import dao.AdminLoginDao;
import dao.CustometLoginDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@WebServlet("/customerLogin")
public class CustomerLoginServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String uname=req.getParameter("uname");
		String pwd=req.getParameter("password");
		
		
		
		CustomerBean cb=new CustometLoginDao().login(uname, pwd);
			if(cb==null)
		{
			req.setAttribute("msg", "Invalid login process...");
			req.getRequestDispatcher("msg.jsp").forward(req, resp);
		}
		else
		{
			HttpSession hs=req.getSession();
			hs.setAttribute("cbean", cb);
			req.setAttribute("msg", "Customer Login Successfully...");
			req.getRequestDispatcher("customerLogin.jsp").forward(req, resp);
		}
		
	
	}

}
