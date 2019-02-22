package command;

import java.io.UnsupportedEncodingException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Properties;
import javax.mail.Address;
import javax.mail.AuthenticationFailedException;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import dao.*;
import exe.*;
import beans.UserBean;

public class PassRemindCommand extends AbstractCommand{
	
	//パスワードリマインド機能
	public ResponseContext execute(ResponseContext resc){
		
		RequestContext reqc = getRequestContext();
		
		boolean judge = false;
		
		String[] emails = reqc.getParameter("email");
		String email = emails[0];
		String[] tels = reqc.getParameter("tel");
		String tel = tels[0];
		
		UserBean ub = new UserBean();
		
		ub.getUid();
		ub.setEmail(email);
		ub.setTel(tel);
		
		OracleConnectionManager.getInstance().beginTransaction();
		
		AbstractDaoFactory factory = AbstractDaoFactory.getFactory();
		UserDao ud = factory.getUserDao();
		
		judge = ud.checkEmail(ub);
		
		if(judge == true){
			
			reqc.setSessionAttribute("ub",ub);
			
			String uid = ub.getUid();
			
			send(email,uid);
			
			resc.setTarget("output");
			
		}else{
			resc.setTarget("login");
		}
		return resc;
	}
	
	public void send(String email, String uid) {
		
		private final String ENCODE = "Windows-31J";
		final Properties props = new Properties();
		
		// SMTPサーバーの設定。ここではgooglemailのsmtpサーバーを設定。
		props.put("mail.smtp.host", "smtp.gmail.com");
		
		// SSL用にポート番号を変更。
		props.put("mail.smtp.port", "587"); 
		
		// タイムアウト設定
		props.put("mail.smtp.connectiontimeout", "60000");
		props.put("mail.smtp.timeout", "60000");
		
		// 認証
		props.put("mail.smtp.auth", "true");
		
		//追加
		props.put("mail.smtp.starttls.enable" , "true");
		
		//propsに設定した情報を使用して、sessionの作成
		final Session session = Session.getInstance(props, new Authenticator(){
			protected PasswordAuthentication getPasswordAuthentication(){
				return new PasswordAuthentication("nitorytest@gmail.com", "juserpass");
			}
		});
		
		// ここからメッセージ内容の設定。上記で作成したsessionを引数に渡す。
		final MimeMessage message = new MimeMessage(session);
		
		try {
			final Address addrFrom = new InternetAddress("nitorytest@gmail.com", "nitorytestのパスワードリマインダー", ENCODE);//送信者情報
			message.setFrom(addrFrom);
			
			final Address addrTo = new InternetAddress(mailaddress,"おかだめゆきさま。この部分はこっちで好きに表示できる", ENCODE);//宛先情報
			message.addRecipient(Message.RecipientType.TO, addrTo);
			
			// メールのSubject
			message.setSubject("パスワード変更手続きのご案内", ENCODE);
			
			message.setText("http://172.19.2.6:8080/newera/jumppassreplace?user_id="+id, ENCODE);
			
			message.addHeader("X-Mailerメーラー", "blancoMail 0.1エンジン？");
			
			message.setSentDate(new Date());
			
		} catch (MessagingException e) {
			 e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		// メール送信。
		try {
			Transport.send(message);
		} catch (AuthenticationFailedException e) {
			// 認証失敗
			e.printStackTrace();
		} catch (MessagingException e) {
			// smtpサーバへの接続失敗
			e.printStackTrace();
		}
	}
}


