package command;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletRequest;

import dao.AbstractDaoFactory;
import dao.OracleConnectionManager;
import dao.ProductDao;

import context.*;
import beans.*;
import exp.*;

public class CartAddCommand extends AbstractCommand{
	
	//カート追加処理
	public ResponseContext execute(ResponseContext resc){
		
		RequestContext reqc = getRequestContext();
		HttpServletRequest req = (HttpServletRequest)reqc.getRequest();
		HttpSession session = req.getSession();
		
		User u = (User)session.getAttribute("userBean");
		
		
		CartBean cb = u.getCart();
		String[] pids = reqc.getParameter("pid");
		String pid = pids[0];
		int subtotal = 0;
		
		if(cb == null){
			cb = new CartBean();
		}
		
		//トランザクションを開始する
		OracleConnectionManager.getInstance().beginTransaction();
		
		//インテグレーションレイヤの処理を呼び出す
		AbstractDaoFactory factory = AbstractDaoFactory.getFactory();
		ProductDao pd = factory.getProductDao();
		
		ProductBean pb = new ProductBean();
		
		pb = pd.getProduct(pid);
		
		cb.addProduct(pb);
		
		for(int i = 0; i < cb.getProducts().size(); i++){
			ProductBean pro = (ProductBean)cb.getProducts().get(i);
			subtotal += pro.getPrice() * pro.getNum();
		}
		
		cb.setSubtotal(subtotal);
		u.setCart(cb);
		
		//トランザクションを終了する
		OracleConnectionManager.getInstance().commit();
		
		//コネクションを切断する
		OracleConnectionManager.getInstance().closeConnection();
		
		//cartdisplay.jspへ転送
		resc.setTarget("cartdisplay");
		
		return resc;
	}
}