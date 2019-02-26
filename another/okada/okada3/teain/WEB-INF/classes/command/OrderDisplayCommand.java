package command;

import dao.AbstractDaoFactory;
import dao.OracleConnectionManager;
import dao.OrderDao;

import exe.*;
import beans.UserBean;

public class OrderDisplayCommand extends AbstractCommand{
	
	//���C�ɓ���\������
	public ResponseContext execute(ResponseContext resc){
		
		RequestContext reqc = getRequestContext();
		
		UserBean ub = (UserBean)reqc.getSessionAttribute("ub");
		String uid = ub.getUid();
		
		//�g�����U�N�V�������J�n����
		OracleConnectionManager.getInstance().beginTransaction();
		
		//�C���e�O���[�V�������C���̏������Ăяo��
		AbstractDaoFactory factory = AbstractDaoFactory.getFactory();
		OrderDao od = factory.getOrderDao();
		
		resc.setResult(od.getOrders(uid));
		
		//�g�����U�N�V�������I������
		OracleConnectionManager.getInstance().commit();
		
		//�R�l�N�V������ؒf����
		OracleConnectionManager.getInstance().closeConnection();
		
		//favoritedisplay.jsp�֓]��
		resc.setTarget("orderdisplay");
		
		return resc;
	}
}