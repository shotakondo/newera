package command;
import java.util.List;

import dao.*;
import context.*;
import beans.*;
import exp.*;

public class DeleteUserCommand extends AbstractCommand{
	public ResponseContext execute(ResponseContext resc){
		RequestContext reqc = getRequestContext();
		
		OracleConnectionManager.getInstance().beginTransaction();
		
		reqc.getSession();
		boolean b = reqc.attributeCheck("userBean");
		System.out.println("DeleteCommandAttributeCheck" + b);
		
		User ub = new User();
		
		try{
			
			ub = (User) reqc.getSessionAttribute("userBean");
			System.out.println((User) reqc.getSessionAttribute("userBean"));
			
		}catch(NullPointerException e){
			
			System.out.println("DeleteUserCommand getSessionがnullだったのでcatchに入って例外投げました");
			throw new exp.NotLoginException("ログインしてください", new RuntimeException());
			
		}
		
		String id = ub.getId();
		System.out.println(id);
		
		OracleConnectionManager.getInstance().beginTransaction();
		
		//インテグレーションレイヤの処理を呼び出す
		AbstractDaoFactory factory = AbstractDaoFactory.getFactory();
		UserDao dao=factory.getUserDao();
		DetailDao dd = factory.getDetailDao();
		OrderDao od = factory.getOrderDao();
		FavoriteDao fd = factory.getFavoriteDao();
		
		if(id!=null){
			System.out.println("ub!=null 入った");
			List orders = od.getOrders(id);
			for(int i = 0; i < orders.size(); i++){
				OrderBean ob = (OrderBean)orders.get(i);
				dd.deleteDetails(ob.getOid());
			}
			od.deleteOrders(id);
			fd.deleteFavorites(id);
			dao.DeleteUser(id);
			//トランザクションを終了する
			OracleConnectionManager.getInstance().commit();
			
			//コネクションを切断する
			OracleConnectionManager.getInstance().closeConnection();
			System.out.println("DeleteUser(id)"+id);
			
			reqc.setRemoveAttribute("userBean");
			User u = new User();
			reqc.setSessionAttrbiute("userBean", u);
			System.out.println("退会しました");
			resc.setTarget("home");
			
		}else{
			
			System.out.println("DeleteUserCommand idがnullだったのでcatchに入って例外投げました");
			throw new exp.asdfException("退会できませんでした", new RuntimeException());
			
		}
		
		
		
		return resc;
	}
}
