package command;

import dao.AbstractDaoFactory;
import dao.OracleConnectionManager;
import dao.UserDao;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletRequest;

import exe.*;
import beans.*;

public class SubscribeCommand extends exe.AbstractCommand{
	
	//����o�^����
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
			
			//���͓��e���s�K��
			resc.setTarget("subscribe");
			
		//}else if(!(pass.equals(repass))){
			
			//���[���A�h���X�Ɗm�F�p���[���A�h���X�̒l����v���Ȃ�
			resc.setTarget("subscribe");
			
		//}else{
			
			//�V����UserBean�N���X�̃C���X�^���X��������
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
			
			//�g�����U�N�V�������J�n����
			OracleConnectionManager.getInstance().beginTransaction();
			
			//�C���e�O���[�V�������C���̏������Ăяo��
			AbstractDaoFactory factory = AbstractDaoFactory.getFactory();
			UserDao ud= factory.getUserDao();
			
			//ud.insertUser(u);
			//judge = ud.authUser(email, pass);
			//ub = ud.selectUser(email);
			
			//�g�����U�N�V�������I������
			OracleConnectionManager.getInstance().commit();
			
			//�R�l�N�V������ؒf����
			OracleConnectionManager.getInstance().closeConnection();
			
			//judge��true�̏ꍇ
			//if(judge.equals("userok")){
				//session��uid����������
				//session.setAttribute("email", ub.getEmail());
				//session.setAttribute("uname", ub.getFirstname());
				//toppage.jsp�֓]��
				resc.setTarget("toppage");
				
			//judge��true�ȊO�̏ꍇ
			//}else{
				//subscirbe.jsp�֓]��
				resc.setTarget("subscribe");
			//}
		//}
		return resc;
	}
}