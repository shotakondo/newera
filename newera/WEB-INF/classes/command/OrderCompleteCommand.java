package command;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletRequest;

import context.*;
import beans.*;
import dao.*;

public class OrderCompleteCommand extends AbstractCommand{
	
	//������������
	public ResponseContext execute(ResponseContext resc){
		
		RequestContext reqc = getRequestContext();
		HttpServletRequest req = (HttpServletRequest)reqc.getRequest();
		HttpSession session = req.getSession();
		
		User u = (User)session.getAttribute("userBean");
		CartBean cb = u.getCart();
		OrderBean ob = new OrderBean();
		PaymentBean payb = (PaymentBean)session.getAttribute("payb");
		
		int total = 0;
		
		//�g�����U�N�V�������J�n����
		OracleConnectionManager.getInstance().beginTransaction();
		
		//�C���e�O���[�V�������C���̏������Ăяo��
		AbstractDaoFactory factory = AbstractDaoFactory.getFactory();
		StockDao sd = factory.getStockDao();
		OrderDao od = factory.getOrderDao();
		DetailDao dd = factory.getDetailDao();
		
		for(int i = 0; i < cb.getProducts().size(); i++){
			ProductBean pb = (ProductBean)(cb.getProducts().get(i));
			sd.alterStock(pb.getNum(), pb.getPid());
		}
		
		String sq = od.getSequence();
		od.setOrder(sq, u.getId(), payb.getMethod(), payb.getTotal());
		
		for(int i = 0; i < cb.getProducts().size(); i++){
			ProductBean pb = (ProductBean)cb.getProducts().get(i);
			dd.setDetail(sq, pb);
		}
		
		
		cb = new CartBean();
		u.setCart(cb);
		
		session.removeAttribute("payb");
		
		//�g�����U�N�V�������I������
		OracleConnectionManager.getInstance().commit();
		
		//�R�l�N�V������ؒf����
		OracleConnectionManager.getInstance().closeConnection();
		
		//orderconfirm.jsp�֓]��
		resc.setResult(sq);
		resc.setTarget("ordercomplete");
		
		return resc;
	}
}