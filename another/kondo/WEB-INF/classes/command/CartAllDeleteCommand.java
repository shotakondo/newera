package command;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletRequest;

import exe.*;
import beans.*;

public class CartAllDeleteCommand extends AbstractCommand{
	
	//ÉJÅ[Égí«â¡èàóù
	public ResponseContext execute(ResponseContext resc){
		
		RequestContext reqc = getRequestContext();
		HttpServletRequest req = (HttpServletRequest)reqc.getRequest();
		HttpSession session = req.getSession();
		
		CartBean cb = (CartBean)session.getAttribute("cb");
		
		cb.alldeleteProduct();
		
		session.setAttribute("cb", cb);
		
		//cartdisplay.jspÇ÷ì]ëó
		resc.setTarget("cartdisplay");
		
		return resc;
	}
}