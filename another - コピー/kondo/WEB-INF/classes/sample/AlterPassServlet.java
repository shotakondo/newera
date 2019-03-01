import Execute.*;
import Beans.*;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class NewPasswordServlet extends HttpServlet{
	public void doGet(HttpServletRequest req, HttpServletResponse res)
	throws IOException, ServletException{
		doPost(req,res);
	}
	
	public void doPost(HttpServletRequest req, HttpServletResponse res)
	throws IOException, ServletException{
		req.setCharacterEncoding("Windows-31J");
		
		AlterPassExecute  ape = new AlterPassExecute();
		
		String name    = req.getParameter("name");
		String pass    = req.getParameter("pass");
		String newpass = req.getParameter("newpass");
		
		ape.createAccount(name,pass,newpass);
		
		RequestDispatcher rd = req.getRequestDispatcher("login.jsp");
		rd.forward(req,res);
		
	}
}