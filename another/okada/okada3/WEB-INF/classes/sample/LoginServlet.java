import Execute.*;
import Beans.*;
import DBA.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.*;

public class LoginServlet extends HttpServlet{
	public void doGet(HttpServletRequest req, HttpServletResponse res)
	throws IOException, ServletException{
		doPost(req,res);
	}
	
	public void doPost(HttpServletRequest req,HttpServletResponse res)
	throws IOException,ServletException{
		req.setCharacterEncoding("Windows-31J");
		
		LoginExecute le = new LoginExecute();
		
		//エスケープしてgetParameterで受け取る
		String name = req.getParameter("name");
		String pass = req.getParameter("pass");
		
		//セッションの開始
		HttpSession session = req.getSession();
		
		//データベースにユーザ認証に成功した場合はtrue、失敗したらfalse
		boolean check = le.authUser(name, pass, session);
		if (check){
			// 認証済みにセット 
			res.sendRedirect("result");
		}else{
			// 認証に失敗したら、ログイン画面に戻す */
			res.sendRedirect("login");
		}
	}
}