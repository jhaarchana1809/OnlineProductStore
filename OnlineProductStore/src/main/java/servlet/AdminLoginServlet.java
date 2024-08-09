package servlet;

import java.io.IOException;

import bean.AdminBean;
import dao.AdminLoginDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@WebServlet("/admin")
public class AdminLoginServlet extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	
	String uname=req.getParameter("uname");
	String pwd=req.getParameter("password");
	
	
	
	AdminBean ab=new AdminLoginDao().login(uname, pwd);
		if(ab==null)
	{
		req.setAttribute("msg", "Invalid login process...");
		req.getRequestDispatcher("msg.jsp").forward(req, resp);
	}
	else
	{
		HttpSession hs=req.getSession();
		hs.setAttribute("abean", ab);
		req.setAttribute("msg", "Login Successfully...");
		req.getRequestDispatcher("adminLogin.jsp").forward(req, resp);
	}
	
	}

}
