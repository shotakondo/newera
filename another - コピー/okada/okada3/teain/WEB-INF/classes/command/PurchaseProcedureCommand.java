package command;

import java.util.ArrayList;
import java.util.List;

import dao.AbstractDaoFactory;
import dao.OracleConnectionManager;
import dao.StockDao;

import exe.*;
import beans.*;

public class PurchaseProcedureCommand extends AbstractCommand{
	
	//購入手続き機能
	public ResponseContext execute(ResponseContext resc){		RequestContext reqc = getRequestContext();	CartBean cb = (CartBean)reqc.getSessionAttribute("cb");
		String[] nums = reqc.getParameter("num");	Boolean judge = false;

			
							
		
									
				
		
					
		
													
																								cb.alterProductsNum(nums);
		
		//トランザクションを開始する
		OracleConnectionManager.getInstance().beginTransaction();
			//インテグレーションレイヤの処理を呼び出す
		AbstractDaoFactory factory = AbstractDaoFactory.getFactory();
																							StockDao sd = factory.getStockDao();
	
		for(int i = 0; i < cb.getProducts().size(); i++){
			ProductBean pb = (ProductBean)cb.getProducts().get(i);
			if(pb.getNum().length() == 0 || Integer.parseInt(pb.getNum()) == 0){
		System.out.println("カートから"+pb.getName()+"を削除します");			cb.deleteProduct(pb.getPid());
			}
		}
			if(cb.getProducts().size() == 0){
			judge = true;
}else{
		for(int i = 0; i < cb.getProducts().size(); i++){
				ProductBean pb = (ProductBean)cb.getProducts().get(i);
				if(Integer.parseInt(pb.getNum()) > 30){
			System.out.println(pb.getName()+"の在庫を30以下にしてください");
					judge = true;
					break;				}
			}			for(int i = 0; i < cb.getProducts().size(); i++){
				ProductBean pb = (ProductBean)cb.getProducts().get(i);
				if(judge == false && Integer.parseInt(pb.getNum()) > sd.getStock(pb.getPid())){
	System.out.println(pb.getName()+"の在庫が不足しています");
	judge = true;
					break;
				}
			}		}
		
		session.setAttribute("cb", cb);		//トランザクションを終了する
		OracleConnectionManager.getInstance().commit();		//コネクションを切断する
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