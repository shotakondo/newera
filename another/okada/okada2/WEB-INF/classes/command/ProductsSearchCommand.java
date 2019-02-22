package command;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletRequest;

import java.util.List;
import java.util.ArrayList;

import dao.AbstractDaoFactory;
import dao.OracleConnectionManager;
import dao.ProductDao;

import context.*;
import beans.*;

public class ProductsSearchCommand extends AbstractCommand{
	
	//商品検索処理
	public ResponseContext execute(ResponseContext resc){
		
		RequestContext reqc = getRequestContext();
		
		String[] productwords = reqc.getParameter("productword");
		String productword = productwords[0];
		
		if(productword != null && productword.length() != 0){
			//トランザクションを開始する
			OracleConnectionManager.getInstance().beginTransaction();
			
			//インテグレーションレイヤの処理を呼び出す
			AbstractDaoFactory factory = AbstractDaoFactory.getFactory();
			ProductDao pd = factory.getProductDao();
			
			reqc.setSessionAttribute("productlist", pd.getProductsWord(productword));
			//session.setAttribute("productlist", pd.getProductsWord(productwordtop));
			
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