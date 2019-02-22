package command;

import dao.AbstractDaoFactory;
import dao.OracleConnectionManager;
import dao.ProductDao;

import context.*;
import beans.*;

public class ProductDetailDisplayCommand extends AbstractCommand{
	
	//���i�ڍו\���@�\
	public ResponseContext execute(ResponseContext resc){
		
		RequestContext reqc = getRequestContext();
		
		User u = (User)reqc.getSessionAttribute("userBean");
		String id = u.getId();
		
		String[] pids = reqc.getParameter("pid");
		String pid = pids[0];
		
		//�g�����U�N�V�������J�n����
		OracleConnectionManager.getInstance().beginTransaction();
		
		//�C���e�O���[�V�������C���̏������Ăяo��
		AbstractDaoFactory factory = AbstractDaoFactory.getFactory();
		ProductDao pd = factory.getProductDao();
		
		resc.setResult(pd.getProduct(pid));
		
		//�g�����U�N�V�������I������
		OracleConnectionManager.getInstance().commit();
		
		//�R�l�N�V������ؒf����
		OracleConnectionManager.getInstance().closeConnection();
		
		resc.setTarget("display");
		
		return resc;
	}
}