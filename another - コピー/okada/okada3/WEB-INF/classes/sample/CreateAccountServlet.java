import Execute.*;
import Beans.*;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class CreateAccountServlet extends HttpServlet{
	public void doGet(HttpServletRequest req, HttpServletResponse res)
	throws IOException, ServletException{
		doPost(req,res);
	}
	
	public void doPost(HttpServletRequest req, HttpServletResponse res)
	throws IOException, ServletException{
		req.setCharacterEncoding("Windows-31J");
		
		CreateAccountExecute cae = new CreateAccountExecute();
		
		String name = req.getParameter("name");
		String pass = req.getParameter("pass");
		
		
		cae.createAccount(name,pass);
		
		RequestDispatcher rd = req.getRequestDispatcher("login.jsp");
		rd.forward(req,res);
		
	}
}