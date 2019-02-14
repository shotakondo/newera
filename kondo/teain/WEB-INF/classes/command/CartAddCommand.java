package command;

import java.util.ArrayList;
import java.util.List;

import dao.AbstractDaoFactory;
import dao.OracleConnectionManager;
import dao.ProductDao;

import exe.*;
import beans.*;

public class CartAddCommand extends AbstractCommand{
	
	//�J�[�g�ǉ�����
	public ResponseContext execute(ResponseContext resc){	RequestContext reqc = getRequestContext();
	
					
		
							
					
		
		
								
		
	CartBean cb = (CartBean)reqc.getSessionAttribute("cb");
	String[] pids = reqc.getParameter("pid");
	String pid = pids[0];
	
	if(cb == null){
cb = new CartBean();
}
//�g�����U�N�V�������J�n����
OracleConnectionManager.getInstance().beginTransaction();
//�C���e�O���[�V�������C���̏������Ăяo��
		AbstractDaoFactory factory = AbstractDaoFactory.getFactory();
		ProductDao pd = factory.getProductDao();	
		ProductBean pb = new ProductBean();
pb = pd.getProduct(pid);
cb.addProduct(pb);
session.setAttribute("cb", cb);
//�g�����U�N�V�������I������
OracleConnectionManager.getInstance().commit();

//�R�l�N�V������ؒf����
OracleConnectionManager.getInstance().closeConnection();

//cartdisplay.jsp�֓]��
resc.setTarget("cartdisplay");

		return resc;
	}
}