package command;

import dao.AbstractDaoFactory;
import dao.OracleConnectionManager;
import dao.FavoriteDao;

import exe.*;
import beans.UserBean;

public class FavoriteAddCommand extends AbstractCommand{
	
	//お気に入り追加処理
	public ResponseContext execute(ResponseContext resc){
		
		RequestContext reqc = getRequestContext();UserBean ub = (UserBean)reqc.getSessionAttribute("ub");
		String uid = ub.getUid();		String[] pids = reqc.getParameter("pid");
String pid = pids[0];
	
	//トランザクションを開始する
	OracleConnectionManager.getInstance().beginTransaction();
		//インテグレーションレイヤの処理を呼び出す
	AbstractDaoFactory factory = AbstractDaoFactory.getFactory();
	FavoriteDao fd = factory.getFavoriteDao();
	fd.setFavorite(uid, pid);
	resc.setResult(fd.getFavorites(uid));
		//トランザクションを終了する
	OracleConnectionManager.getInstance().commit();	//コネクションを切断する
	OracleConnectionManager.getInstance().closeConnection();
	
	//favoritedisplay.jspへ転送
	resc.setTarget("favoritedisplay");
	
	return resc;
}
}