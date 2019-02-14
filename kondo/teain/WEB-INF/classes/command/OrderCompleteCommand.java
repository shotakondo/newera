package command;

import dao.*;
import exe.*;
import beans.*;

public class OrderCompleteCommand extends AbstractCommand{
	
	//�����m�菈��
	public ResponseContext execute(ResponseContext resc){
		
		RequestContext reqc = getRequestContext();
		
		CartBean cb = (CartBean)reqc.getSessionAttribute("cb");
		UserBean ub = (UserBean)reqc.getSessionAttribute("ub");
		PaymentBean payb = (PaymentBean)reqc.getSessionAttribute("payb");
		
		int total = 0;
		
		//�g�����U�N�V�������J�n����
		OracleConnectionManager.getInstance().beginTransaction();
		
		//�C���e�O���[�V�������C���̏������Ăяo��
		AbstractDaoFactory factory = AbstractDaoFactory.getFactory();
		StockDao sd = factory.getStockDao();
		OrderDao od = factory.getOrderDao();
		DetailDao dd = factory.getDetailDao();
		
		for(int i = 0; i < cb.getProducts().size(); i++){
			ProductBean pb = (ProductBean)cb.getProducts().get(i);
			sd.alterStock(Integer.parseInt(pb.getNum()), pb.getPid());
		}
		
		for(int i = 0; i < cb.getProducts().size(); i++){
			ProductBean pb = (ProductBean)cb.getProducts().get(i);
			total += Integer.parseInt(pb.getPrice()) * Integer.parseInt(pb.getNum());
		}
		String sq = od.getSequence();
		od.setOrder(sq, ub.getUid(), payb.getMethod(), total);
		
		for(int i = 0; i < cb.getProducts().size(); i++){
			ProductBean pb = (ProductBean)cb.getProducts().get(i);
			dd.setDetail(sq, pb);
		}
		
		//cb�̃Z�b�V�����j��
		session.removeAttribute("cb");
		
		//�g�����U�N�V�������I������
		OracleConnectionManager.getInstance().commit();
		
		//�R�l�N�V������ؒf����
		OracleConnectionManager.getInstance().closeConnection();
		
		//orderconfirm.jsp�֓]��
		resc.setTarget("ordercomplete");
		
		return resc;
	}
}