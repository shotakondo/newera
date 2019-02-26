package command;

import java.util.ArrayList;
import java.util.List;

import dao.AbstractDaoFactory;
import dao.OracleConnectionManager;
import dao.StockDao;

import exe.*;
import beans.*;

public class PurchaseProcedureCommand extends AbstractCommand{
	
	//�w���葱���@�\
	public ResponseContext execute(ResponseContext resc){		RequestContext reqc = getRequestContext();	CartBean cb = (CartBean)reqc.getSessionAttribute("cb");
		String[] nums = reqc.getParameter("num");	Boolean judge = false;

			
							
		
									
				
		
					
		
													
																								cb.alterProductsNum(nums);
		
		//�g�����U�N�V�������J�n����
		OracleConnectionManager.getInstance().beginTransaction();
			//�C���e�O���[�V�������C���̏������Ăяo��
		AbstractDaoFactory factory = AbstractDaoFactory.getFactory();
																							StockDao sd = factory.getStockDao();
	
		for(int i = 0; i < cb.getProducts().size(); i++){
			ProductBean pb = (ProductBean)cb.getProducts().get(i);
			if(pb.getNum().length() == 0 || Integer.parseInt(pb.getNum()) == 0){
		System.out.println("�J�[�g����"+pb.getName()+"���폜���܂�");			cb.deleteProduct(pb.getPid());
			}
		}
			if(cb.getProducts().size() == 0){
			judge = true;
}else{
		for(int i = 0; i < cb.getProducts().size(); i++){
				ProductBean pb = (ProductBean)cb.getProducts().get(i);
				if(Integer.parseInt(pb.getNum()) > 30){
			System.out.println(pb.getName()+"�̍݌ɂ�30�ȉ��ɂ��Ă�������");
					judge = true;
					break;				}
			}			for(int i = 0; i < cb.getProducts().size(); i++){
				ProductBean pb = (ProductBean)cb.getProducts().get(i);
				if(judge == false && Integer.parseInt(pb.getNum()) > sd.getStock(pb.getPid())){
	System.out.println(pb.getName()+"�̍݌ɂ��s�����Ă��܂�");
	judge = true;
					break;
				}
			}		}
		
		session.setAttribute("cb", cb);		//�g�����U�N�V�������I������
		OracleConnectionManager.getInstance().commit();		//�R�l�N�V������ؒf����
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