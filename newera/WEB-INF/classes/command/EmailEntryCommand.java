package command;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletRequest;

import exe.*;
import beans.*;

public class EmailEntryCommand extends exe.AbstractCommand{
	
	//メールアドレス申し込み処理(仮)
	public ResponseContext execute(ResponseContext resc){
		
		RequestContext reqc = getRequestContext();
		HttpServletRequest req = (HttpServletRequest)reqc.getRequest();
		HttpSession session = req.getSession();
		
		//requestContextのインスタンスを取得する
		String email = reqc.getParameter("email")[0];
		
		//emailに格納されているメールアドレスに本人確認メールを送信する
		
		//sessionにemailを格納する
		session.setAttribute("email", email);
		
		//subscribeに転送する
		//本来はentrycompleteに転送する
		resc.setTarget("subscribe");
		
		return resc;
	}
}