package command;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletRequest;

import dao.AbstractDaoFactory;
import dao.OracleConnectionManager;
import dao.FavoriteDao;

import exe.*;
import beans.UserBean;

public class FavoriteAlterCommand extends AbstractCommand{
	
	//お気に入り追加処理
	public ResponseContext execute(ResponseContext resc){
		
		RequestContext reqc = getRequestContext();
		HttpServletRequest req = (HttpServletRequest)reqc.getRequest();
		HttpSession session = req.getSession();
		
		UserBean ub = (UserBean)session.getAttribute("ub");
		String uid = ub.getUid();
		String pid = reqc.getParameter("pid")[0];
		String comment = reqc.getParameter("comment")[0];
		
		//値が入っているか確認
		if (comment != null || comment.length() != 0){
			
			//トランザクションを開始する
			OracleConnectionManager.getInstance().beginTransaction();
			
			//インテグレーションレイヤの処理を呼び出す
			AbstractDaoFactory factory = AbstractDaoFactory.getFactory();
			FavoriteDao fd = factory.getFavoriteDao();
			
			fd.alterFavorite(uid, pid, comment);
			resc.setResult(fd.getFavorites(uid));
			
			//トランザクションを終了する
			OracleConnectionManager.getInstance().commit();
			
			//コネクションを切断する
			OracleConnectionManager.getInstance().closeConnection();
			
		}
		
		//favoritedisplay.jspへ転送
		resc.setTarget("favoritedisplay");
		
		return resc;
	}
}