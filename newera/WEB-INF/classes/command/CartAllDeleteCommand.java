package command;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletRequest;

import context.*;
import beans.*;
import dao.*;


public class CartAllDeleteCommand extends AbstractCommand{
	
	//カート追加処理
	public ResponseContext execute(ResponseContext resc){
		
		RequestContext reqc = getRequestContext();
		HttpServletRequest req = (HttpServletRequest)reqc.getRequest();
		HttpSession session = req.getSession();
		
		//トランザクションを開始する
		OracleConnectionManager.getInstance().beginTransaction();
		
		//インテグレーションレイヤの処理を呼び出す
		AbstractDaoFactory factory = AbstractDaoFactory.getFactory();
		CartBean cb = (CartBean)session.getAttribute("cb");
		
		cb.alldeleteProduct();
		//トランザクションを終了する
		OracleConnectionManager.getInstance().commit();
		
		//コネクションを切断する
		OracleConnectionManager.getInstance().closeConnection();
		
		session.setAttribute("cb", cb);
		
		//cartdisplay.jspへ転送
		resc.setTarget("cartdisplay");
		
		return resc;
	}
}