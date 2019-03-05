package command;
import java.util.List;

import dao.*;
import context.*;
import beans.*;
import exp.*;

public class getUserCommand extends AbstractCommand{
	public ResponseContext execute(ResponseContext resc){
		RequestContext reqc = getRequestContext();
		
		OracleConnectionManager.getInstance().beginTransaction();
		
		User u = (User)reqc.getSessionAttribute("userBean");
		
		
		
		try{
			
			u = (User) reqc.getSessionAttribute("userBean");
			System.out.println("getUserCommand"+u);
			
		}catch(NullPointerException e){
			
			System.out.println("getUsertCommand getSessionがnullだったのでcatchに入って例外投げました");
			throw new exp.asdfException("ログインしてください。", new RuntimeException());
			
		}
		
		
		//System.out.println("User u = (User) reqc.getSessionAttribute("userBean")"+u);
		String id = u.getId();
		System.out.println("getUserCommandでgetSessionAttributeした後のu.getId() : "+id);
		
		//トランザクションを開始する
		OracleConnectionManager.getInstance().beginTransaction();
		
		//インテグレーションレイヤの処理を呼び出す
		AbstractDaoFactory factory=AbstractDaoFactory.getFactory();
		UserDao dao=factory.getUserDao();
		
		u =dao.getUser(u.getEmail(), u);
		//トランザクションを終了する
		OracleConnectionManager.getInstance().commit();
		
		//コネクションを切断する
		OracleConnectionManager.getInstance().closeConnection();
		
		System.out.println("getUserCommandのListのl : "+ u);
		
		resc.setResult(u);

		resc.setTarget("edituser");
		return resc;

	}
}
