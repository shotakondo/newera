package command;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletRequest;

import dao.AbstractDaoFactory;
import dao.OracleConnectionManager;
import dao.ProductDao;

import context.*;

public class ProductsSearchCommand extends AbstractCommand{
	
	//���i��������
	public ResponseContext execute(ResponseContext resc){
		
		RequestContext reqc = getRequestContext();
		HttpServletRequest req = (HttpServletRequest)reqc.getRequest();
		HttpSession session = req.getSession();
		
		String productword = reqc.getParameter("productword")[0];
		
		if(productword != null && productword.length() != 0){
			//�g�����U�N�V�������J�n����
			OracleConnectionManager.getInstance().beginTransaction();
			
			//�C���e�O���[�V�������C���̏������Ăяo��
			AbstractDaoFactory factory = AbstractDaoFactory.getFactory();
			ProductDao pd = factory.getProductDao();
			
			session.setAttribute("productlist", pd.getProductsWord(productword));
			
			//�g�����U�N�V�������I������
			OracleConnectionManager.getInstance().commit();
			
			//�R�l�N�V������ؒf����
			OracleConnectionManager.getInstance().closeConnection();
		}
			
		//toppage.jsp�֓]��
		resc.setTarget("home");
		
		return resc;
	}
}