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
		
		System.out.println("ProductDetailDisplayCommand : pid" + pid);

		
		//�g�����U�N�V�������J�n����
		OracleConnectionManager.getInstance().beginTransaction();
		
		//�C���e�O���[�V�������C���̏������Ăяo��
		AbstractDaoFactory factory = AbstractDaoFactory.getFactory();
		ProductDao pd = factory.getProductDao();
		
		try{
			resc.setResult(pd.getProduct(pid));
		}catch(Exception e){
			e.printStackTrace();
		}		
		
		
		try{
			//�g�����U�N�V�������I������
			OracleConnectionManager.getInstance().commit();
			
			//�R�l�N�V������ؒf����
			OracleConnectionManager.getInstance().closeConnection();
		
		}catch(Exception e){
			e.printStackTrace();
		}	
		
		System.out.println("display��setTarget����");
		
		resc.setTarget("display");
		
		
		
		return resc;
	}
}