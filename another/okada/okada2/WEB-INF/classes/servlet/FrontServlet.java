package servlet;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import context.*;
import controller.*;


public class FrontServlet extends javax.servlet.http.HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse res)
	throws ServletException, IOException{
		doPost(req, res);
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res)
	throws ServletException, IOException{
		req.setCharacterEncoding("Windows-31J");
		
		//ApplicationController�̎����N���X�̃C���X�^���X���擾����
		ApplicationController app = new WebApplicationController();
		
		//�t�@�N�g�����\�b�h���Ăяo����
		//��ۃN���X�̃C���X�^���X���擾����
		RequestContext reqc = app.getRequest(req);
		
		//�t�@�N�g�����\�b�h���Ăяo��
		//RequestContext��n����ResponseContext���擾����
		ResponseContext resc = app.handleRequest(reqc);
		
		//ResponseContext��
		//HttpServletResponse�C���^�[�t�F�C�X����������N���X��
		//�C���X�^���X���擾����
		resc.setResponse(res);
		
		//View�̑I���Ɠ]���������s��
		app.handleResponse(reqc, resc);
	}
}