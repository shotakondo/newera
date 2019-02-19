package command;

import dao.AbstractDaoFactory;
import dao.OracleConnectionManager;
import dao.ProductDao;

import exe.*;

public class ProductsDisplayCommand extends AbstractCommand{
	
	//商品表示処理
	public ResponseContext execute(ResponseContext resc){
		
		RequestContext reqc = getRequestContext();
		
		//トランザクションを開始する
		OracleConnectionManager.getInstance().beginTransaction();
		
		//インテグレーションレイヤの処理を呼び出す
		AbstractDaoFactory factory = AbstractDaoFactory.getFactory();
		ProductDao pd = factory.getProductDao();
		
		reqc.setSessionAttribute("pl", pd.getAllProducts());
		
		//トランザクションを終了する
		OracleConnectionManager.getInstance().commit();
		
		//コネクションを切断する
		OracleConnectionManager.getInstance().closeConnection();
		
		//productsdisplay.jspへ転送
		resc.setTarget("toppage");
		
		return resc;
	}
}