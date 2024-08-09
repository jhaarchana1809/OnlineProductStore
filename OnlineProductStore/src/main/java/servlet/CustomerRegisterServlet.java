package servlet;

import java.io.IOException;

import bean.CustomerBean;
import dao.CustomerRegisterDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@SuppressWarnings("serial")
@WebServlet("/customerRegister")
public class CustomerRegisterServlet extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	CustomerBean cb=new CustomerBean();
	cb.setuName(req.getParameter("username"));
	cb.setPwd(req.getParameter("password"));
	cb.setfName(req.getParameter("firstName"));
	cb.setlName(req.getParameter("lastName"));
	cb.setAddress(req.getParameter("address"));
	cb.setEmailId(req.getParameter("email"));
	cb.setPhNo(Long.parseLong(req.getParameter("phone")));
	int k=new CustomerRegisterDao().registerCusomer(cb);
	if(k>0)
	{
		
		req.setAttribute("msg", "Registration Successfully...");
		req.getRequestDispatcher("customerRegister.jsp").forward(req, resp);
	}
	
	}

}
