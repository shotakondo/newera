package command;

import dao.AbstractDaoFactory;
import dao.OracleConnectionManager;
import dao.OrderDao;

import exe.*;
import beans.UserBean;

public class OrderDisplayCommand extends AbstractCommand{
	
	//お気に入り表示処理
	public ResponseContext execute(ResponseContext resc){
		
		RequestContext reqc = getRequestContext();
		
		UserBean ub = (UserBean)reqc.getSessionAttribute("ub");
		String uid = ub.getUid();
		
		//トランザクションを開始する
		OracleConnectionManager.getInstance().beginTransaction();
		
		//インテグレーションレイヤの処理を呼び出す
		AbstractDaoFactory factory = AbstractDaoFactory.getFactory();
		OrderDao od = factory.getOrderDao();
		
		resc.setResult(od.getOrders(uid));
		
		//トランザクションを終了する
		OracleConnectionManager.getInstance().commit();
		
		//コネクションを切断する
		OracleConnectionManager.getInstance().closeConnection();
		
		//favoritedisplay.jspへ転送
		resc.setTarget("orderdisplay");
		
		return resc;
	}
}