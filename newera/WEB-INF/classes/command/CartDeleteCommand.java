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
		
		String[] pids = reqc.getParameter("pid");
		String pid = pids[0];
		
		User u = (User)session.getAttribute("userBean");
		if(u == null){
			u = new User();
		}
		
		CartBean cb = u.getCart();
		if(cb == null){
			cb = new CartBean();
		}
		AbstractDaoFactory factory = AbstractDaoFactory.getFactory();
		ProductDao pd = factory.getProductDao();
		cb.deleteProduct(pid);
		
		u.setCart(cb);
		
		//cartdisplay.jspÇ÷ì]ëó
		resc.setTarget("cartdisplay");
		
		return resc;
	}
}