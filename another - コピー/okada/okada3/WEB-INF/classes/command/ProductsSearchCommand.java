package command;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletRequest;

import java.util.List;
import java.util.ArrayList;

import dao.AbstractDaoFactory;
import dao.OracleConnectionManager;
import dao.ProductDao;

import context.*;
import beans.*;

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
			
			reqc.setSessionAttribute("productlist", pd.getProductsWord(productword));
			//session.setAttribute("productlist", pd.getProductsWord(productwordtop));
			
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