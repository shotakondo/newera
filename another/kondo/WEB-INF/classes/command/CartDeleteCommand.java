package command;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletRequest;

import context.*;
import beans.*;

public class CartDeleteCommand extends AbstractCommand{
	
	//ÉJÅ[Égí«â¡èàóù
	public ResponseContext execute(ResponseContext resc){
		
		RequestContext reqc = getRequestContext();
		HttpServletRequest req = (HttpServletRequest)reqc.getRequest();
		HttpSession session = req.getSession();
		
		CartBean cb = (CartBean)session.getAttribute("cb");
		String pid = reqc.getParameter("pid")[0];
		
		cb.deleteProduct(pid);
		
		session.setAttribute("cb", cb);
		
		//cartdisplay.jspÇ÷ì]ëó
		resc.setTarget("cartdisplay");
		
		return resc;
	}
}