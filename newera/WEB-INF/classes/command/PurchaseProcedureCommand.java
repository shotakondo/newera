package command;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletRequest;

import dao.AbstractDaoFactory;
import dao.OracleConnectionManager;
import dao.StockDao;

import context.*;
import beans.*;

public class PurchaseProcedureCommand extends AbstractCommand{
	
	//購入手続き機能
	public ResponseContext execute(ResponseContext resc){
		
		RequestContext reqc = getRequestContext();
		HttpServletRequest req = (HttpServletRequest)reqc.getRequest();
		HttpSession session = req.getSession();
		User u = (User)session.getAttribute("userBean");
		if(u == null){
			u = new User();
		}
		
		CartBean cb = u.getCart();
		if(cb == null){
			cb = new CartBean();
		}
		
		String[] numliststring = req.getParameterValues("num");
		int[] numlistint = new int[numliststring.length];
		
		for(int i = 0; i < numliststring.length; i++){
			numlistint[i] = Integer.parseInt(numliststring[i]);
		}
		
		Boolean judge = false;
		System.out.println("はじめ");
		cb.alterProductsNum(numlistint);
		System.out.println("終わり");
		//トランザクションを開始する
		OracleConnectionManager.getInstance().beginTransaction();
		
		//インテグレーションレイヤの処理を呼び出す
		AbstractDaoFactory factory = AbstractDaoFactory.getFactory();
		StockDao sd = factory.getStockDao();
		
		for(int i = 0; i < cb.getProducts().size(); i++){
			ProductBean pb = (ProductBean)cb.getProducts().get(i);
			if(String.valueOf(pb.getNum()).equals(null) || pb.getNum() == 0){
				System.out.println("カートから"+pb.getName()+"を削除します");
				cb.deleteProduct(pb.getPid());
			}
		}
		
		if(cb.getProducts().size() == 0){
			judge = true;
		}else{
			for(int i = 0; i < cb.getProducts().size(); i++){
				ProductBean pb = (ProductBean)cb.getProducts().get(i);
				if(pb.getNum() > 30){
					System.out.println(pb.getName()+"の在庫を30以下にしてください");
					judge = true;
					break;
				}
			}
			for(int i = 0; i < cb.getProducts().size(); i++){
				ProductBean pb = (ProductBean)cb.getProducts().get(i);
				if(judge == false && pb.getNum() > sd.getStock(pb.getPid())){
					System.out.println(pb.getName()+"の在庫が不足しています");
					judge = true;
					break;
				}
			}
		}
		
		u.setCart(cb);
		
		//トランザクションを終了する
		OracleConnectionManager.getInstance().commit();
		
		//コネクションを切断する
		OracleConnectionManager.getInstance().closeConnection();
		
		if(judge == true){
			//cartdisplay.jspへ転送
			resc.setTarget("cartdisplay");
		}else{
			//purchaseprocedure.jspへ転送
			resc.setTarget("purchaseprocedure");
		}
		
		return resc;
	}
}