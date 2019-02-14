package command;

import dao.AbstractDaoFactory;
import dao.OracleConnectionManager;
import dao.ProductDao;

import exe.*;

public class ProductsSearchCommand extends AbstractCommand{
	
	//���i��������
	public ResponseContext execute(ResponseContext resc){
		
		RequestContext reqc = getRequestContext();
		
		String[] productwords = reqc.getParameter("productword");
		String productword = productwords[0];
		
		if(productword != null && productword.length() != 0){
			//�g�����U�N�V�������J�n����
			OracleConnectionManager.getInstance().beginTransaction();
			
			//�C���e�O���[�V�������C���̏������Ăяo��
			AbstractDaoFactory factory = AbstractDaoFactory.getFactory();
			ProductDao pd = factory.getProductDao();
			
			session.setAttribute("pl", pd.getProductsWord(productword));
			
			//�g�����U�N�V�������I������
			OracleConnectionManager.getInstance().commit();
			
			//�R�l�N�V������ؒf����
			OracleConnectionManager.getInstance().closeConnection();
		}
			
		//toppage.jsp�֓]��
		resc.setTarget("toppage");
		
		return resc;
	}
}