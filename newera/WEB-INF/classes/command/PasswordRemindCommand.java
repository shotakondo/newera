package command;

import java.io.UnsupportedEncodingException;
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
import java.io.PrintWriter;

import dao.*;
import beans.*;
import context.*;
import exp.*;

public class PasswordRemindCommand extends AbstractCommand{
	public ResponseContext execute(ResponseContext resc){
		
		RequestContext reqc = getRequestContext();
		
		OracleConnectionManager.getInstance().beginTransaction();
		reqc.getSession();
		String[] emails = reqc.getParameter("email");
		String email = emails[0];
		
		String[] tels = reqc.getParameter("tel");
		String tel = tels[0];
		User u = (User) reqc.getSessionAttribute("userBean");
		u.setEmail(email);
		u.setTel(tel);
		
		
		//トランザクションを開始する
		OracleConnectionManager.getInstance().beginTransaction();
		
		//インテグレーションレイヤの処理を呼び出す
		AbstractDaoFactory factory=AbstractDaoFactory.getFactory();
		
		UserDao ud = factory.getUserDao();
		
		boolean b = ud.checkEmail(u);
		
		reqc.setSessionAttribute("userBean",u);
		String id = ud.getUserId(u.getEmail());
		
		//トランザクションを終了する
		OracleConnectionManager.getInstance().commit();
		
		//コネクションを切断する
		OracleConnectionManager.getInstance().closeConnection();
			
		if(b == true){

			send(email,id);
			//System.out.println(email,id);
			
			resc.setTarget("output");
			System.out.println(email+"メール送ました");
		}else{
			
			resc.setTarget("email");
		}
		return resc;
	}


	private final String ENCODE = "Windows-31J";
	

//ここからメール送付に必要なSMTP,SSL認証などの設定

     public void send(String mailaddress, String id) {
        final Properties props = new Properties();

        // SMTPサーバーの設定。ここではgooglemailのsmtpサーバーを設定。
        props.put("mail.smtp.host", "smtp.gmail.com");

        // SSL用にポート番号を変更。
        props.put("mail.smtp.port", "587"); //465

        // タイムアウト設定
        props.put("mail.smtp.connectiontimeout", "60000");
        props.put("mail.smtp.timeout", "60000");

        // 認証
        props.put("mail.smtp.auth", "true");
    	//Session session = Session.getInstance( props, new myAuth() );
    	
    	//追加
    	props.put("mail.smtp.starttls.enable" , "true");

        // SSLを使用するとこはこの設定が必要。
        //props.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        //props.setProperty("mail.smtp.socketFactory.fallback", "false");
        //props.setProperty("mail.smtp.socketFactory.port", "465");

       //propsに設定した情報を使用して、sessionの作成
        final Session session = Session.getInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("nitorytest@gmail.com", "juserpass");
            }
        });

     

        // ここからメッセージ内容の設定。上記で作成したsessionを引数に渡す。
        final MimeMessage message = new MimeMessage(session);

        try {
            final Address addrFrom = new InternetAddress(
                    "nitorytest@gmail.com", "neweraのパスワードリマインダー", ENCODE);//送信者情報
            message.setFrom(addrFrom);

            final Address addrTo = new InternetAddress(mailaddress,
                    "", ENCODE);//宛先情報
            message.addRecipient(Message.RecipientType.TO, addrTo);

            // メールのSubject
            message.setSubject("パスワード変更手続きのご案内", ENCODE);
			
			message.setText("こちらのurlからパスワード変更してください \n http://172.19.2.6:8080/newera/jumppassreplace?user_id="+id, ENCODE);
        	//message.setText("http://192.168.1.4:8080/newera/jumppassreplace?user_id="+id, ENCODE);
            // その他の付加情報。
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


