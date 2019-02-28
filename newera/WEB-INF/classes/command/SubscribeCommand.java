package command;

import dao.AbstractDaoFactory;
import dao.OracleConnectionManager;
import dao.UserDao;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletRequest;

import exe.*;
import beans.*;

public class SubscribeCommand extends exe.AbstractCommand{
	
	//会員登録処理
	public ResponseContext execute(ResponseContext resc){
		
		RequestContext reqc = getRequestContext();
		HttpServletRequest req = (HttpServletRequest)reqc.getRequest();
		HttpSession session = req.getSession();
		
		String firstName = reqc.getParameter("firstName")[0];
		String lastName = reqc.getParameter("lastName")[0];
		String tel = reqc.getParameter("tel")[0];
		String postcode = reqc.getParameter("postcode")[0];
		String address = reqc.getParameter("address")[0];
		String sex = reqc.getParameter("sex")[0];
		String birthday = reqc.getParameter("birthday")[0];
		String pass = reqc.getParameter("pass")[0];
		String repass = reqc.getParameter("repass")[0];
		String email = reqc.getParameter("email")[0];
		
		//char _sex = sex.charAt(0);
		String judge = null;
		String id = null;
		
		//if (firstname == null || firstname.length() == 0 || lastname == null || lastname.length() == 0 || tel == null || tel.length() == 0 || postcode == null || postcode.length() == 0 || address == null || address.length() == 0 || sex == null || sex.length() == 0 || birthday == null || birthday.length() == 0 || pass == null || pass.length() == 0 || repass == null || repass.length() == 0 || email == null || email.length() == 0){
			
			//入力内容が不適切
			resc.setTarget("subscribe");
			
		//}else if(!(pass.equals(repass))){
			
			//メールアドレスと確認用メールアドレスの値が一致しない
			resc.setTarget("subscribe");
			
		//}else{
			
			//新しいUserBeanクラスのインスタンス化をする
			User u = new User();
			
			u.setFirstName(firstName);
			u.setLastName(lastName);
			u.setEmail(email);
			u.setPass(pass);
			u.setTel(tel);
			u.setPostcode(postcode);
			u.setAddress(address);
			u.setSex(sex);
			u.setBirthday(birthday);
			
			//トランザクションを開始する
			OracleConnectionManager.getInstance().beginTransaction();
			
			//インテグレーションレイヤの処理を呼び出す
			AbstractDaoFactory factory = AbstractDaoFactory.getFactory();
			UserDao ud= factory.getUserDao();
			
			//ud.insertUser(u);
			//judge = ud.authUser(email, pass);
			//ub = ud.selectUser(email);
			
			//トランザクションを終了する
			OracleConnectionManager.getInstance().commit();
			
			//コネクションを切断する
			OracleConnectionManager.getInstance().closeConnection();
			
			//judgeがtrueの場合
			//if(judge.equals("userok")){
				//sessionにuidを持たせる
				//session.setAttribute("email", ub.getEmail());
				//session.setAttribute("uname", ub.getFirstname());
				//toppage.jspへ転送
				resc.setTarget("toppage");
				
			//judgeがtrue以外の場合
			//}else{
				//subscirbe.jspへ転送
				resc.setTarget("subscribe");
			//}
		//}
		return resc;
	}
}