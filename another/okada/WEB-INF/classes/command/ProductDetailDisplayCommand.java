package command;

import dao.AbstractDaoFactory;
import dao.OracleConnectionManager;
import dao.ProductDao;

import context.*;
import beans.*;

public class ProductDetailDisplayCommand extends AbstractCommand{
	
	//商品詳細表示機能
	public ResponseContext execute(ResponseContext resc){
		
		RequestContext reqc = getRequestContext();
		
		User u = (User)reqc.getSessionAttribute("userBean");
		String id = u.getId();
		
		String[] pids = reqc.getParameter("pid");
		String pid = pids[0];
		
		System.out.println("ProductDetailDisplayCommand : pid" + pid);

		
		//トランザクションを開始する
		OracleConnectionManager.getInstance().beginTransaction();
		
		//インテグレーションレイヤの処理を呼び出す
		AbstractDaoFactory factory = AbstractDaoFactory.getFactory();
		ProductDao pd = factory.getProductDao();
		
		try{
			resc.setResult(pd.getProduct(pid));
		}catch(Exception e){
			e.printStackTrace();
		}		
		
		
		try{
			//トランザクションを終了する
			OracleConnectionManager.getInstance().commit();
			
			//コネクションを切断する
			OracleConnectionManager.getInstance().closeConnection();
		
		}catch(Exception e){
			e.printStackTrace();
		}	
		
		System.out.println("displayにsetTargetした");
		
		resc.setTarget("display");
		
		
		
		return resc;
	}
}