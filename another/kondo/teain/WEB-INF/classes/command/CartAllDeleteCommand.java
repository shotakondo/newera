package command;

import exe.*;
import beans.*;

public class CartAllDeleteCommand extends AbstractCommand{	
	//カート追加処理
	public ResponseContext execute(ResponseContext resc){			
		RequestContext reqc = getRequestContext();				
		CartBean cb = (CartBean)reqc.getSessionAttribute("cb");
			cb.alldeleteProduct();		
		session.setAttribute("cb", cb);	
//cartdisplay.jspへ転送		
		resc.setTarget("cartdisplay");
		return resc;
	}
}