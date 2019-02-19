package command;

import dao.AbstractDaoFactory;
import dao.ProductDao;
import dao.OracleConnectionManager;

import exe.*;

public class CartDisplayCommand extends AbstractCommand{
	
	//�J�[�g�\���@�\
	public ResponseContext execute(ResponseContext resc){
		
		//�g�����U�N�V�������J�n����
		OracleConnectionManager.getInstance().beginTransaction();
		
		//�C���e�O���[�V�������C���̏������Ăяo��
		AbstractDaoFactory factory = AbstractDaoFactory.getFactory();
		ProductDao pd = factory.getProductDao();
		
		resc.setResult();
		
		//�g�����U�N�V�������I������
		OracleConnectionManager.getInstance().commit();
		
		//�R�l�N�V������ؒf����
		OracleConnectionManager.getInstance().closeConnection();
		
		//cartdisplay.jsp�֓]��
		resc.setTarget("cartdisplay");
		
		return resc;
	}
}