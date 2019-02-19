package command;

import dao.AbstractDaoFactory;
import dao.ProductDao;
import dao.OracleConnectionManager;

import exe.*;

public class CartDisplayCommand extends AbstractCommand{
	
	//カート表示機能
	public ResponseContext execute(ResponseContext resc){
		
		//cartdisplay.jspへ転送
		resc.setTarget("cartdisplay");
		
		return resc;
	}
}