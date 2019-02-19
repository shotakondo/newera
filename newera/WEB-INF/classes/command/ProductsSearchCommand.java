package command;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletRequest;

import dao.AbstractDaoFactory;
import dao.OracleConnectionManager;
import dao.ProductDao;

import context.*;

public class ProductsSearchCommand extends AbstractCommand{
	
	//商品検索処理
	public ResponseContext execute(ResponseContext resc){
		
		RequestContext reqc = getRequestContext();
		HttpServletRequest req = (HttpServletRequest)reqc.getRequest();
		HttpSession session = req.getSession();
		
		String productword = reqc.getParameter("productword")[0];
		
		if(productword != null && productword.length() != 0){
			//トランザクションを開始する
			OracleConnectionManager.getInstance().beginTransaction();
			
			//インテグレーションレイヤの処理を呼び出す
			AbstractDaoFactory factory = AbstractDaoFactory.getFactory();
			ProductDao pd = factory.getProductDao();
			
			session.setAttribute("productlist", pd.getProductsWord(productword));
			
			//トランザクションを終了する
			OracleConnectionManager.getInstance().commit();
			
			//コネクションを切断する
			OracleConnectionManager.getInstance().closeConnection();
		}
			
		//toppage.jspへ転送
		resc.setTarget("home");
		
		return resc;
	}
}