package command;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletRequest;

import context.*;
import beans.*;
import dao.*;


public class CartAllDeleteCommand extends AbstractCommand{
	
	//�J�[�g�ǉ�����
	public ResponseContext execute(ResponseContext resc){
		
		RequestContext reqc = getRequestContext();
		HttpServletRequest req = (HttpServletRequest)reqc.getRequest();
		HttpSession session = req.getSession();
		
		//�g�����U�N�V�������J�n����
		OracleConnectionManager.getInstance().beginTransaction();
		
		//�C���e�O���[�V�������C���̏������Ăяo��
		AbstractDaoFactory factory = AbstractDaoFactory.getFactory();
		CartBean cb = (CartBean)session.getAttribute("cb");
		
		cb.alldeleteProduct();
		//�g�����U�N�V�������I������
		OracleConnectionManager.getInstance().commit();
		
		//�R�l�N�V������ؒf����
		OracleConnectionManager.getInstance().closeConnection();
		
		session.setAttribute("cb", cb);
		
		//cartdisplay.jsp�֓]��
		resc.setTarget("cartdisplay");
		
		return resc;
	}
}