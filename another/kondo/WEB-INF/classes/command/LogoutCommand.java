package command;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletRequest;

import exe.*;

public class LogoutCommand extends AbstractCommand{
	
	//ログアウト処理
	public ResponseContext execute(ResponseContext resc){
		
		RequestContext reqc = getRequestContext();
		HttpServletRequest req = (HttpServletRequest)reqc.getRequest();
		HttpSession session = req.getSession();
		
		session.invalidate();
		
		//toppage.jspへ転送
		resc.setTarget("toppage");
		
		return resc;
	}
}