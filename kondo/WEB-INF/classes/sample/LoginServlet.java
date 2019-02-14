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
		
		//�G�X�P�[�v����getParameter�Ŏ󂯎��
		String name = req.getParameter("name");
		String pass = req.getParameter("pass");
		
		//�Z�b�V�����̊J�n
		HttpSession session = req.getSession();
		
		//�f�[�^�x�[�X�Ƀ��[�U�F�؂ɐ��������ꍇ��true�A���s������false
		boolean check = le.authUser(name, pass, session);
		if (check){
			// �F�؍ς݂ɃZ�b�g 
			res.sendRedirect("result");
		}else{
			// �F�؂Ɏ��s������A���O�C����ʂɖ߂� */
			res.sendRedirect("login");
		}
	}
}