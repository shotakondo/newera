package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.OraUserDao;
import beans.User;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email= request.getParameter("email");
		String pass = request.getParameter("pass");

		
		User u = new OraUserDao().getUser(email);
		System.out.println(u);
		if(new OraUserDao().checkLogin(email, pass)){
			HttpSession session = request.getSession();
			session.setAttribute("user", u);
			
			response.sendRedirect("index.jsp");
		}else{
			response.sendRedirect("login?err=1");
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
