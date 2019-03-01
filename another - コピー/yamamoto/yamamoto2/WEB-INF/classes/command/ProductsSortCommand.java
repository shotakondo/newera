package command;

import java.util.List;
import java.util.ArrayList;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletRequest;

import dao.AbstractDaoFactory;
import dao.OracleConnectionManager;
import dao.ProductDao;

import context.*;

public class ProductsSortCommand extends AbstractCommand{
	
	//���i���בւ�����
	public ResponseContext execute(ResponseContext resc){
		
		RequestContext reqc = getRequestContext();
		HttpServletRequest req = (HttpServletRequest)reqc.getRequest();
		HttpSession session = req.getSession();
		
		String sortparameter = reqc.getParameter("sortparameter")[0];
		
		//�g�����U�N�V�������J�n����
		OracleConnectionManager.getInstance().beginTransaction();
		
		//�C���e�O���[�V�������C���̏������Ăяo��
		AbstractDaoFactory factory = AbstractDaoFactory.getFactory();
		ProductDao pd = factory.getProductDao();
		
		if(sortparameter.equals("name")){
			session.setAttribute("productlist", pd.getProductsName());
			
		}else if(sortparameter.equals("cheap")){
			session.setAttribute("productlist", pd.getProductsCheap());
			
		}else if (sortparameter.equals("expensive")){
			session.setAttribute("productlist", pd.getProductsExpensive());
		}
		
		//�g�����U�N�V�������I������
		OracleConnectionManager.getInstance().commit();
		
		//�R�l�N�V������ؒf����
		OracleConnectionManager.getInstance().closeConnection();
		
		//toppage.jsp�֓]��
		resc.setTarget("home");
		
		return resc;
	}
}