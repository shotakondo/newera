package command;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletRequest;

import dao.AbstractDaoFactory;
import dao.OracleConnectionManager;
import dao.StockDao;

import context.*;
import beans.*;

public class PurchaseProcedureCommand extends AbstractCommand{
	
	//�w���葱���@�\
	public ResponseContext execute(ResponseContext resc){
		
		RequestContext reqc = getRequestContext();
		HttpServletRequest req = (HttpServletRequest)reqc.getRequest();
		HttpSession session = req.getSession();
		User u = (User)session.getAttribute("userBean");
		if(u == null){
			u = new User();
		}
		
		CartBean cb = u.getCart();
		if(cb == null){
			cb = new CartBean();
		}
		
		String[] numliststring = req.getParameterValues("num");
		int[] numlistint = new int[numliststring.length];
		
		for(int i = 0; i < numliststring.length; i++){
			numlistint[i] = Integer.parseInt(numliststring[i]);
		}
		
		Boolean judge = false;
		System.out.println("�͂���");
		cb.alterProductsNum(numlistint);
		System.out.println("�I���");
		//�g�����U�N�V�������J�n����
		OracleConnectionManager.getInstance().beginTransaction();
		
		//�C���e�O���[�V�������C���̏������Ăяo��
		AbstractDaoFactory factory = AbstractDaoFactory.getFactory();
		StockDao sd = factory.getStockDao();
		
		for(int i = 0; i < cb.getProducts().size(); i++){
			ProductBean pb = (ProductBean)cb.getProducts().get(i);
			if(String.valueOf(pb.getNum()).equals(null) || pb.getNum() == 0){
				System.out.println("�J�[�g����"+pb.getName()+"���폜���܂�");
				cb.deleteProduct(pb.getPid());
			}
		}
		
		if(cb.getProducts().size() == 0){
			judge = true;
		}else{
			for(int i = 0; i < cb.getProducts().size(); i++){
				ProductBean pb = (ProductBean)cb.getProducts().get(i);
				if(pb.getNum() > 30){
					System.out.println(pb.getName()+"�̍݌ɂ�30�ȉ��ɂ��Ă�������");
					judge = true;
					break;
				}
			}
			for(int i = 0; i < cb.getProducts().size(); i++){
				ProductBean pb = (ProductBean)cb.getProducts().get(i);
				if(judge == false && pb.getNum() > sd.getStock(pb.getPid())){
					System.out.println(pb.getName()+"�̍݌ɂ��s�����Ă��܂�");
					judge = true;
					break;
				}
			}
		}
		
		u.setCart(cb);
		
		//�g�����U�N�V�������I������
		OracleConnectionManager.getInstance().commit();
		
		//�R�l�N�V������ؒf����
		OracleConnectionManager.getInstance().closeConnection();
		
		if(judge == true){
			//cartdisplay.jsp�֓]��
			resc.setTarget("cartdisplay");
		}else{
			//purchaseprocedure.jsp�֓]��
			resc.setTarget("purchaseprocedure");
		}
		
		return resc;
	}
}