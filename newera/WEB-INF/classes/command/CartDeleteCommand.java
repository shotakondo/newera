package command;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletRequest;

import context.*;
import beans.*;
import dao.*;

public class CartDeleteCommand extends AbstractCommand{
	
	//ÉJÅ[Égí«â¡èàóù
	public ResponseContext execute(ResponseContext resc){
		
		RequestContext reqc = getRequestContext();
		HttpServletRequest req = (HttpServletRequest)reqc.getRequest();
		HttpSession session = req.getSession();
		
		CartBean cb = (CartBean)session.getAttribute("cb");
		String pid = reqc.getParameter("pid")[0];
		
		User u = (User)session.getAttribute("userBean");
		if(u == null){
			u = new User();
		}
		
		
		if(cb == null){
			cb = new CartBean();
		}
		AbstractDaoFactory factory = AbstractDaoFactory.getFactory();
		ProductDao pd = factory.getProductDao();
		cb.deleteProduct(pid);

		
		reqc.setSessionAttribute("userBean",u);
		
		
		//cartdisplay.jspÇ÷ì]ëó
		resc.setTarget("cartdisplay");
		
		return resc;
	}
}