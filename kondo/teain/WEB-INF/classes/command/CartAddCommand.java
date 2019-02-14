package command;

import java.util.ArrayList;
import java.util.List;

import dao.AbstractDaoFactory;
import dao.OracleConnectionManager;
import dao.ProductDao;

import exe.*;
import beans.*;

public class CartAddCommand extends AbstractCommand{
	
	//カート追加処理
	public ResponseContext execute(ResponseContext resc){	RequestContext reqc = getRequestContext();
	
					
		
							
					
		
		
								
		
	CartBean cb = (CartBean)reqc.getSessionAttribute("cb");
	String[] pids = reqc.getParameter("pid");
	String pid = pids[0];
	
	if(cb == null){
cb = new CartBean();
}
//トランザクションを開始する
OracleConnectionManager.getInstance().beginTransaction();
//インテグレーションレイヤの処理を呼び出す
		AbstractDaoFactory factory = AbstractDaoFactory.getFactory();
		ProductDao pd = factory.getProductDao();	
		ProductBean pb = new ProductBean();
pb = pd.getProduct(pid);
cb.addProduct(pb);
session.setAttribute("cb", cb);
//トランザクションを終了する
OracleConnectionManager.getInstance().commit();

//コネクションを切断する
OracleConnectionManager.getInstance().closeConnection();

//cartdisplay.jspへ転送
resc.setTarget("cartdisplay");

		return resc;
	}
}