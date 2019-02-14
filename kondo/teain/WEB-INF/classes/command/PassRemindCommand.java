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
	
	//�p�X���[�h���}�C���h�@�\
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
		
		// SMTP�T�[�o�[�̐ݒ�B�����ł�googlemail��smtp�T�[�o�[��ݒ�B
		props.put("mail.smtp.host", "smtp.gmail.com");
		
		// SSL�p�Ƀ|�[�g�ԍ���ύX�B
		props.put("mail.smtp.port", "587"); 
		
		// �^�C���A�E�g�ݒ�
		props.put("mail.smtp.connectiontimeout", "60000");
		props.put("mail.smtp.timeout", "60000");
		
		// �F��
		props.put("mail.smtp.auth", "true");
		
		//�ǉ�
		props.put("mail.smtp.starttls.enable" , "true");
		
		//props�ɐݒ肵�������g�p���āAsession�̍쐬
		final Session session = Session.getInstance(props, new Authenticator(){
			protected PasswordAuthentication getPasswordAuthentication(){
				return new PasswordAuthentication("nitorytest@gmail.com", "juserpass");
			}
		});
		
		// �������烁�b�Z�[�W���e�̐ݒ�B��L�ō쐬����session�������ɓn���B
		final MimeMessage message = new MimeMessage(session);
		
		try {
			final Address addrFrom = new InternetAddress("nitorytest@gmail.com", "nitorytest�̃p�X���[�h���}�C���_�[", ENCODE);//���M�ҏ��
			message.setFrom(addrFrom);
			
			final Address addrTo = new InternetAddress(mailaddress,"�������߂䂫���܁B���̕����͂������ōD���ɕ\���ł���", ENCODE);//������
			message.addRecipient(Message.RecipientType.TO, addrTo);
			
			// ���[����Subject
			message.setSubject("�p�X���[�h�ύX�葱���̂��ē�", ENCODE);
			
			message.setText("http://172.19.2.6:8080/newera/jumppassreplace?user_id="+id, ENCODE);
			
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


