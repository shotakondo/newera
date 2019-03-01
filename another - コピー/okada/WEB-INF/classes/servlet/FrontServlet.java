package servlet;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import context.*;
import controller.*;


public class FrontServlet extends javax.servlet.http.HttpServlet{
	protected void doGet(HttpServletRequest req, HttpServletResponse res)
		throws ServletException, IOException{
			doPost(req,res);
		}
	protected void doPost(HttpServletRequest req, HttpServletResponse res)
		throws ServletException, IOException{
			
			req.setCharacterEncoding("Windows-31J");

				ApplicationController app = new WebApplicationController();

				RequestContext reqc = app.getRequest(req);
				ResponseContext resc = app.handleRequest(reqc);

				resc.setResponse(res);

				app.handleResponse(reqc, resc);
			
		}
}