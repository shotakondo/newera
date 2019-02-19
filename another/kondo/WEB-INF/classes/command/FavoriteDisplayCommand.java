package command;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletRequest;

import dao.AbstractDaoFactory;
import dao.OracleConnectionManager;
import dao.FavoriteDao;

import exe.*;
import beans.UserBean;

public class FavoriteDisplayCommand extends AbstractCommand{
	
	//お気に入り表示処理
	public ResponseContext execute(ResponseContext resc){
		
		RequestContext reqc = getRequestContext();
		HttpServletRequest req = (HttpServletRequest)reqc.getRequest();
		HttpSession session = req.getSession();
		
		UserBean ub = (UserBean)session.getAttribute("ub");
		String uid = ub.getUid();
		
		//トランザクションを開始する
		OracleConnectionManager.getInstance().beginTransaction();
		
		//インテグレーションレイヤの処理を呼び出す
		AbstractDaoFactory factory = AbstractDaoFactory.getFactory();
		FavoriteDao fd = factory.getFavoriteDao();
		
		resc.setResult(fd.getFavorites(uid));
		
		//トランザクションを終了する
		OracleConnectionManager.getInstance().commit();
		
		//コネクションを切断する
		OracleConnectionManager.getInstance().closeConnection();
		
		//favoritedisplay.jspへ転送
		resc.setTarget("favoritedisplay");
		
		return resc;
	}
}