package command;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletRequest;

import dao.AbstractDaoFactory;
import dao.OracleConnectionManager;
import dao.*;

import exe.*;
import beans.*;

public class OrderCompleteCommand extends AbstractCommand{
	
	//注文確定処理
	public ResponseContext execute(ResponseContext resc){
		
		RequestContext reqc = getRequestContext();
		HttpServletRequest req = (HttpServletRequest)reqc.getRequest();
		HttpSession session = req.getSession();
		
		CartBean cb = (CartBean)session.getAttribute("cb");
		UserBean ub = (UserBean)session.getAttribute("ub");
		PaymentBean payb = (PaymentBean)session.getAttribute("payb");
		
		int total = 0;
		
		//トランザクションを開始する
		OracleConnectionManager.getInstance().beginTransaction();
		
		//インテグレーションレイヤの処理を呼び出す
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
		
		//cbのセッション破棄
		session.removeAttribute("cb");
		
		//トランザクションを終了する
		OracleConnectionManager.getInstance().commit();
		
		//コネクションを切断する
		OracleConnectionManager.getInstance().closeConnection();
		
		//orderconfirm.jspへ転送
		resc.setTarget("ordercomplete");
		
		return resc;
	}
}