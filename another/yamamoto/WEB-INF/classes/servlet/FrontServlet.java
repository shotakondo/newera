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
		
		//ApplicationControllerの実装クラスのインスタンスを取得する
		ApplicationController app = new WebApplicationController();
		
		//ファクトリメソッドを呼び出して
		//具象クラスのインスタンスを取得する
		RequestContext reqc = app.getRequest(req);
		
		//ファクトリメソッドを呼び出す
		//RequestContextを渡してResponseContextを取得する
		ResponseContext resc = app.handleRequest(reqc);
		
		//ResponseContextに
		//HttpServletResponseインターフェイスを実装するクラスの
		//インスタンスを取得する
		resc.setResponse(res);
		
		//Viewの選択と転送処理を行う
		app.handleResponse(reqc, resc);
	}
}