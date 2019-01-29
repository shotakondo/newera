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
			System.out.println("���O�C���G���[");
		}
  		
		request.setAttribute("user",email);
  		//request.setAttribute("user",tel);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("output.jsp");
			dispatcher.forward(request, response);
		send(email);

		System.out.println(email);
  }

private final String ENCODE = "Windows-31J";
	

//�������烁�[�����t�ɕK�v��SMTP,SSL�F�؂Ȃǂ̐ݒ�

     public void send(String mailaddress) {
        final Properties props = new Properties();

        // SMTP�T�[�o�[�̐ݒ�B�����ł�googlemail��smtp�T�[�o�[��ݒ�B
        props.put("mail.smtp.host", "smtp.gmail.com");

        // SSL�p�Ƀ|�[�g�ԍ���ύX�B
        props.put("mail.smtp.port", "587"); //465

        // �^�C���A�E�g�ݒ�
        props.put("mail.smtp.connectiontimeout", "60000");
        props.put("mail.smtp.timeout", "60000");

        // �F��
        props.put("mail.smtp.auth", "true");
    	//Session session = Session.getInstance( props, new myAuth() );
    	
    	//�ǉ�
    	props.put("mail.smtp.starttls.enable" , "true");

        // SSL���g�p����Ƃ��͂��̐ݒ肪�K�v�B
        //props.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        //props.setProperty("mail.smtp.socketFactory.fallback", "false");
        //props.setProperty("mail.smtp.socketFactory.port", "465");

       //props�ɐݒ肵�������g�p���āAsession�̍쐬
        final Session session = Session.getInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("nitorytest@gmail.com", "juserpass");
            }
        });

     

        // �������烁�b�Z�[�W���e�̐ݒ�B��L�ō쐬����session�������ɓn���B
        final MimeMessage message = new MimeMessage(session);

        try {
            final Address addrFrom = new InternetAddress(
                    "nitorytest@gmail.com", "nitorytest�̃p�X���[�h���}�C���_�[", ENCODE);//���M�ҏ��
            message.setFrom(addrFrom);

            final Address addrTo = new InternetAddress(mailaddress,
                    "�������߂䂫���܁B���̕����͂������ōD���ɕ\���ł���", ENCODE);//������
            message.addRecipient(Message.RecipientType.TO, addrTo);

            // ���[����Subject
            message.setSubject("�p�X���[�h�ύX�葱���̂��ē�", ENCODE);

            // ���[���{���B
        	

        //	message.setText("NITORY�������p���������A���肪�Ƃ��������܂��B", ENCODE);

		//	message.setText("�p�X���[�h�̍Đݒ�����肢�������܂��B", ENCODE);
        	
		//	message.setText("------------------------------", ENCODE);
        	
		//	message.setText("���p�X���[�h�Đݒ�葱����");
        	
            message.setText("http://172.19.2.6:8080/mailtest/set.jsp", ENCODE);


            // ���̑��̕t�����B
            message.addHeader("X-Mailer���[���[", "blancoMail 0.1�G���W���H");
            message.setSentDate(new Date());
        } catch (MessagingException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        // ���[�����M�B
        try {
            Transport.send(message);
        } catch (AuthenticationFailedException e) {
            // �F�؎��s
                 e.printStackTrace();
        } catch (MessagingException e) {
            // smtp�T�[�o�ւ̐ڑ����s
           e.printStackTrace();
           
        }
    }
}