package command;

import java.util.ArrayList;
import java.util.List;

import exe.*;
import beans.*;

public class CartDeleteCommand extends AbstractCommand{
													
	//�J�[�g�ǉ�����
	public ResponseContext execute(ResponseContext resc){
						RequestContext reqc = getRequestContext();
		CartBean cb = (CartBean)reqc.getSessionAttribute("cb");
				String[] pids = reqc.getParameter("pid");
					String pid = pids[0];			
		cb.deleteProduct(pid);
			session.setAttribute("cb", cb);
		//cartdisplay.jsp�֓]��
		resc.setTarget("cartdisplay");
		return resc;
	}
}