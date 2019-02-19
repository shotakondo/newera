package command;

import java.util.List;
import java.util.ArrayList;

import dao.AbstractDaoFactory;
import dao.OracleConnectionManager;
import dao.ProductDao;

import exe.*;

public class ProductsSortCommand extends AbstractCommand{
	
	//商品並べ替え処理
	public ResponseContext execute(ResponseContext resc){
		
		RequestContext reqc = getRequestContext();
		
		String[] sortparameters = reqc.getParameter("sortparameter");
		String sortparameter = sortparameters[0];
		
		//トランザクションを開始する
		OracleConnectionManager.getInstance().beginTransaction();
		
		//インテグレーションレイヤの処理を呼び出す
		AbstractDaoFactory factory = AbstractDaoFactory.getFactory();
		ProductDao pd = factory.getProductDao();
		
		if(sortparameter.equals("name")){
			session.setAttribute("pl", pd.getProductsName());
			
		}else if(sortparameter.equals("cheap")){
			session.setAttribute("pl", pd.getProductsCheap());
			
		}else if (sortparameter.equals("expensive")){
			session.setAttribute("pl", pd.getProductsExpensive());
		}
		
		//トランザクションを終了する
		OracleConnectionManager.getInstance().commit();
		
		//コネクションを切断する
		OracleConnectionManager.getInstance().closeConnection();
		
		//toppage.jspへ転送
		resc.setTarget("toppage");
		
		return resc;
	}
}