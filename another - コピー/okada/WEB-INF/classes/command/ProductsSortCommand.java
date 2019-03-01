package command;

import java.util.List;
import java.util.ArrayList;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletRequest;

import dao.AbstractDaoFactory;
import dao.OracleConnectionManager;
import dao.ProductDao;

import context.*;

public class ProductsSortCommand extends AbstractCommand{
	
	//商品並べ替え処理
	public ResponseContext execute(ResponseContext resc){
		
		RequestContext reqc = getRequestContext();
		HttpServletRequest req = (HttpServletRequest)reqc.getRequest();
		HttpSession session = req.getSession();
		
		String sortparameter = reqc.getParameter("sortparameter")[0];
		
		//トランザクションを開始する
		OracleConnectionManager.getInstance().beginTransaction();
		
		//インテグレーションレイヤの処理を呼び出す
		AbstractDaoFactory factory = AbstractDaoFactory.getFactory();
		ProductDao pd = factory.getProductDao();
		
		if(sortparameter.equals("name")){
			session.setAttribute("productlist", pd.getProductsName());
			
		}else if(sortparameter.equals("cheap")){
			session.setAttribute("productlist", pd.getProductsCheap());
			
		}else if (sortparameter.equals("expensive")){
			session.setAttribute("productlist", pd.getProductsExpensive());
		}
		
		//トランザクションを終了する
		OracleConnectionManager.getInstance().commit();
		
		//コネクションを切断する
		OracleConnectionManager.getInstance().closeConnection();
		
		//toppage.jspへ転送
		resc.setTarget("home");
		
		return resc;
	}
}