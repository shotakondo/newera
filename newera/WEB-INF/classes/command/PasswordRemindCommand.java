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
		
		
		//�g�����U�N�V�������J�n����
		OracleConnectionManager.getInstance().beginTransaction();
		
		//�C���e�O���[�V�������C���̏������Ăяo��
		AbstractDaoFactory factory=AbstractDaoFactory.getFactory();
		
		UserDao ud = factory.getUserDao();
		
		boolean b = ud.checkEmail(u);
		
		reqc.setSessionAttribute("userBean",u);
		String id = ud.getUserId(u.getEmail());
		
		//�g�����U�N�V�������I������
		OracleConnectionManager.getInstance().commit();
		
		//�R�l�N�V������ؒf����
		OracleConnectionManager.getInstance().closeConnection();
			
		if(b == true){

			send(email,id);
			//System.out.println(email,id);
			
			resc.setTarget("output");
			System.out.println(email+"���[�����܂���");
		}else{
			
			resc.setTarget("email");
		}
		return resc;
	}


	private final String ENCODE = "Windows-31J";
	

//�������烁�[�����t�ɕK�v��SMTP,SSL�F�؂Ȃǂ̐ݒ�

     public void send(String mailaddress, String id) {
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
                    "nitorytest@gmail.com", "newera�̃p�X���[�h���}�C���_�[", ENCODE);//���M�ҏ��
            message.setFrom(addrFrom);

            final Address addrTo = new InternetAddress(mailaddress,
                    "", ENCODE);//������
            message.addRecipient(Message.RecipientType.TO, addrTo);

            // ���[����Subject
            message.setSubject("�p�X���[�h�ύX�葱���̂��ē�", ENCODE);
			
			message.setText("�������url����p�X���[�h�ύX���Ă������� \n http://172.19.2.6:8080/newera/jumppassreplace?user_id="+id, ENCODE);
        	//message.setText("http://192.168.1.4:8080/newera/jumppassreplace?user_id="+id, ENCODE);
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


