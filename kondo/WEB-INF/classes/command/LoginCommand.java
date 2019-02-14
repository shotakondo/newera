package command;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletRequest;

import dao.AbstractDaoFactory;
import dao.OracleConnectionManager;
import dao.UserDao;

import exe.*;

import beans.UserBean;

public class LoginCommand extends AbstractCommand{
	
	//ログイン処理
	public ResponseContext execute(ResponseContext resc){
		
		RequestContext reqc = getRequestContext();
		HttpServletRequest req = (HttpServletRequest)reqc.getRequest();
		HttpSession session = req.getSession();
		
		String email = reqc.getParameter("email")[0];
		String pass = reqc.getParameter("pass")[0];
		String judge = null;
		
		//新しいUserBeanのインスタンス化をする
		UserBean ub = new UserBean();
		
		ub.setEmail(email);
		ub.setPass(pass);
		
		//値が入っているか確認
		if (email == null || email.length() == 0 || pass == null || pass.length() == 0){
			
			//ログイン失敗→login.jspへ転送
			resc.setTarget("login");
			
		}else{
			
			//トランザクションを開始する
			OracleConnectionManager.getInstance().beginTransaction();
			
			//インテグレーションレイヤの処理を呼び出す
			AbstractDaoFactory factory = AbstractDaoFactory.getFactory();
			UserDao ud = factory.getUserDao();
			
			judge = ud.authUser(email, pass);
			ub = ud.selectUser(email);
			
			resc.setResult(ub);
			
			//トランザクションを終了する
			OracleConnectionManager.getInstance().commit();
			
			//コネクションを切断する
			OracleConnectionManager.getInstance().closeConnection();
			
			if(judge.equals("ok")){
				//sessionにuidを持たせる
				session.setAttribute("ub",ub);
				//toppage.jspへ転送
				resc.setTarget("toppage");
			}
		}
		return resc;
	}
}