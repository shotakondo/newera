package command;

import dao.AbstractDaoFactory;
import dao.ProductDao;
import dao.OracleConnectionManager;

import exe.*;

public class CartDisplayCommand extends AbstractCommand{
	
	//カート表示機能
	public ResponseContext execute(ResponseContext resc){
		
		//トランザクションを開始する
		OracleConnectionManager.getInstance().beginTransaction();
		
		//インテグレーションレイヤの処理を呼び出す
		AbstractDaoFactory factory = AbstractDaoFactory.getFactory();
		ProductDao pd = factory.getProductDao();
		
		resc.setResult();
		
		//トランザクションを終了する
		OracleConnectionManager.getInstance().commit();
		
		//コネクションを切断する
		OracleConnectionManager.getInstance().closeConnection();
		
		//cartdisplay.jspへ転送
		resc.setTarget("cartdisplay");
		
		return resc;
	}
}