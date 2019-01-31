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
@WebServlet("/CreateUserServlet")
public class CreateUserServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("windows-31J");
		response.setCharacterEncoding("windows-31J");
		
		String email = request.getParameter("email");
		String pass = request.getParameter("pass");
		String id = request.getParameter("id");
		String sei = request.getParameter("sei");
		String mei = request.getParameter("mei");
		String tel = request.getParameter("tel");
		String birthday = request.getParameter("birthday");
		User u = new User(email,pass,id,sei,mei,tel,birthday);
		
		if(new OraUserDao().creatUser(u)){

			response.sendRedirect("login.jsp");
		}else{
			System.out.println("ÉzÅ[ÉÄÇ÷ñﬂÇÈ");
		}
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
