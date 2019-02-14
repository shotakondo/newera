package command;

import exe.*;
import beans.*;

public class CartAllDeleteCommand extends AbstractCommand{
	
	//�J�[�g�ǉ�����
	public ResponseContext execute(ResponseContext resc){
		
		RequestContext reqc = getRequestContext();
		
		CartBean cb = (CartBean)reqc.getSessionAttribute("cb");
		
		cb.alldeleteProduct();
		
		session.setAttribute("cb", cb);
		
		//cartdisplay.jsp�֓]��
		resc.setTarget("cartdisplay");
		
		return resc;
	}
}