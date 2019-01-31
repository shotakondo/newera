package servlet;
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
import java.util.ArrayList;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse; 
import javax.servlet.http.HttpSession;
import beans.User;
import dao.*;
@WebServlet("/SendMailServlet")
public class SendMailServlet extends HttpServlet {
	
	
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  	request.setCharacterEncoding("Windows-31J");
  	
		String email = request.getParameter("email");
  		String tel = request.getParameter("tel");
  	
  		User u = new OraUserDao().getUser(email);
  		if(new OraUserDao().checkEmail(email,tel)){
			HttpSession session = request.getSession();
			session.setAttribute("user", u);
			
			response.sendRedirect("index.jsp");
		}else{
			System.out.println("ログインエラー");
		}
  		
		request.setAttribute("user",email);
  		//request.setAttribute("user",tel);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("output.jsp");
			dispatcher.forward(request, response);
		send(email);

		System.out.println(email);
  }

private final String ENCODE = "Windows-31J";
	

//ここからメール送付に必要なSMTP,SSL認証などの設定

     public void send(String mailaddress) {
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
                    "nitorytest@gmail.com", "nitorytestのパスワードリマインダー", ENCODE);//送信者情報
            message.setFrom(addrFrom);

            final Address addrTo = new InternetAddress(mailaddress,
                    "おかだめゆきさま。この部分はこっちで好きに表示できる", ENCODE);//宛先情報
            message.addRecipient(Message.RecipientType.TO, addrTo);

            // メールのSubject
            message.setSubject("パスワード変更手続きのご案内", ENCODE);

            // メール本文。
        	

        //	message.setText("NITORYをご利用いただき、ありがとうございます。", ENCODE);

		//	message.setText("パスワードの再設定をお願いいたします。", ENCODE);
        	
		//	message.setText("------------------------------", ENCODE);
        	
		//	message.setText("＜パスワード再設定手続き＞");
        	
            message.setText("http://172.19.2.6:8080/mailtest/set.jsp", ENCODE);


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