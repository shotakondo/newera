package command;

import java.util.List;
import java.util.ArrayList;

import dao.AbstractDaoFactory;
import dao.OracleConnectionManager;
import dao.ProductDao;

import exe.*;

public class ProductsSortCommand extends AbstractCommand{
	
	//���i���בւ�����
	public ResponseContext execute(ResponseContext resc){
		
		RequestContext reqc = getRequestContext();
		
		String[] sortparameters = reqc.getParameter("sortparameter");
		String sortparameter = sortparameters[0];
		
		//�g�����U�N�V�������J�n����
		OracleConnectionManager.getInstance().beginTransaction();
		
		//�C���e�O���[�V�������C���̏������Ăяo��
		AbstractDaoFactory factory = AbstractDaoFactory.getFactory();
		ProductDao pd = factory.getProductDao();
		
		if(sortparameter.equals("name")){
			session.setAttribute("pl", pd.getProductsName());
			
		}else if(sortparameter.equals("cheap")){
			session.setAttribute("pl", pd.getProductsCheap());
			
		}else if (sortparameter.equals("expensive")){
			session.setAttribute("pl", pd.getProductsExpensive());
		}
		
		//�g�����U�N�V�������I������
		OracleConnectionManager.getInstance().commit();
		
		//�R�l�N�V������ؒf����
		OracleConnectionManager.getInstance().closeConnection();
		
		//toppage.jsp�֓]��
		resc.setTarget("toppage");
		
		return resc;
	}
}