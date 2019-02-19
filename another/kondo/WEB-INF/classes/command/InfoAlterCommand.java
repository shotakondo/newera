package command;

import dao.AbstractDaoFactory;
import dao.OracleConnectionManager;
import dao.UserDao;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletRequest;

import exe.*;
import beans.UserBean;

public class InfoAlterCommand extends AbstractCommand{
	
	//�o�^���ύX����
	public ResponseContext execute(ResponseContext resc){
		
		RequestContext reqc = getRequestContext();
		HttpServletRequest req = (HttpServletRequest)reqc.getRequest();
		HttpSession session = req.getSession();
		UserBean ub = new UserBean();
		
		String newpass = null;
		
		String firstname = reqc.getParameter("firstname")[0];
		String lastname = reqc.getParameter("lastname")[0];
		String tel = reqc.getParameter("tel")[0];
		String postcode = reqc.getParameter("postcode")[0];
		String address = reqc.getParameter("address")[0];
		String sex = reqc.getParameter("sex")[0];
		String email = reqc.getParameter("email")[0];
		String reemail = reqc.getParameter("reemail")[0];
		String nowpass = reqc.getParameter("nowpass")[0];
		String pass = reqc.getParameter("pass")[0];
		String repass = reqc.getParameter("repass")[0];
		
		//���͓��e���s�K��
		if(firstname == null || firstname.length() == 0 || lastname == null || lastname.length() == 0 || tel == null || tel.length() == 0 || postcode == null || postcode.length() == 0 || address == null || address.length() == 0 || sex == null || sex.length() == 0 || email == null || email.length() == 0 || reemail == null || reemail.length() == 0){
			
			//�g�����U�N�V�������J�n����
			email = (String)session.getAttribute("email");
			
			OracleConnectionManager.getInstance().beginTransaction();
			
			//�C���e�O���[�V�������C���̏������Ăяo��
			AbstractDaoFactory factory = AbstractDaoFactory.getFactory();
			UserDao ud = factory.getUserDao();
			
			ub = ud.selectUser(email);
			
			//�g�����U�N�V�������I������
			OracleConnectionManager.getInstance().commit();
			
			//�R�l�N�V������ؒf����
			OracleConnectionManager.getInstance().closeConnection();
			
			resc.setResult(ub);
			
			resc.setTarget("infodisplayalter");
			
			return resc;
			
		//���[���A�h���X�܂��̓p�X���[�h���m�F�p�ƈ�v���Ȃ�
		}else if(!(pass.equals(repass)) || !(email.equals(reemail))){
			
			//�g�����U�N�V�������J�n����
			email = (String)session.getAttribute("email");
			
			OracleConnectionManager.getInstance().beginTransaction();
			
			//�C���e�O���[�V�������C���̏������Ăяo��
			AbstractDaoFactory factory = AbstractDaoFactory.getFactory();
			UserDao ud = factory.getUserDao();
			
			ub = ud.selectUser(email);
			
			//�g�����U�N�V�������I������
			OracleConnectionManager.getInstance().commit();
			
			//�R�l�N�V������ؒf����
			OracleConnectionManager.getInstance().closeConnection();
			
			resc.setResult(ub);
			
			resc.setTarget("infodisplayalter");
			
			return resc;
			
		}else if(pass == "" && repass == ""){
			
			//�p�X���[�h���ǂ����null�̏ꍇ
			newpass = nowpass;
		}else if(pass.equals(repass)){
			
			//�p�X���[�h���m�F�p�ƈ�v�����ꍇ
			newpass = pass;
		}
		
		ub.setFirstname(firstname);
		ub.setLastname(lastname);
		ub.setEmail(email);
		ub.setPass(newpass);
		ub.setTel(tel);
		ub.setPostcode(postcode);
		ub.setAddress(address);
		ub.setSex(sex);
		
		//�g�����U�N�V�������J�n����
		OracleConnectionManager.getInstance().beginTransaction();
		
		//�C���e�O���[�V�������C���̏������Ăяo��
		AbstractDaoFactory factory = AbstractDaoFactory.getFactory();
		UserDao ud = factory.getUserDao();
		
		ud.updateUser(ub);
		
		//�g�����U�N�V�������I������
		OracleConnectionManager.getInstance().commit();
		
		//�R�l�N�V������ؒf����
		OracleConnectionManager.getInstance().closeConnection();
		
		session.setAttribute("email", email);
		session.setAttribute("uname", firstname);
		
		//mypage.jsp�֓]��
		resc.setTarget("mypage");
		
		return resc;
	}
}