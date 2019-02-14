package command;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletRequest;

import dao.AbstractDaoFactory;
import dao.OracleConnectionManager;
import dao.UserDao;

import exe.*;

import beans.UserBean;

public class LoginCommand extends AbstractCommand{
	
	//���O�C������
	public ResponseContext execute(ResponseContext resc){
		
		RequestContext reqc = getRequestContext();
		HttpServletRequest req = (HttpServletRequest)reqc.getRequest();
		HttpSession session = req.getSession();
		
		String email = reqc.getParameter("email")[0];
		String pass = reqc.getParameter("pass")[0];
		String judge = null;
		
		//�V����UserBean�̃C���X�^���X��������
		UserBean ub = new UserBean();
		
		ub.setEmail(email);
		ub.setPass(pass);
		
		//�l�������Ă��邩�m�F
		if (email == null || email.length() == 0 || pass == null || pass.length() == 0){
			
			//���O�C�����s��login.jsp�֓]��
			resc.setTarget("login");
			
		}else{
			
			//�g�����U�N�V�������J�n����
			OracleConnectionManager.getInstance().beginTransaction();
			
			//�C���e�O���[�V�������C���̏������Ăяo��
			AbstractDaoFactory factory = AbstractDaoFactory.getFactory();
			UserDao ud = factory.getUserDao();
			
			judge = ud.authUser(email, pass);
			ub = ud.selectUser(email);
			
			resc.setResult(ub);
			
			//�g�����U�N�V�������I������
			OracleConnectionManager.getInstance().commit();
			
			//�R�l�N�V������ؒf����
			OracleConnectionManager.getInstance().closeConnection();
			
			if(judge.equals("ok")){
				//session��uid����������
				session.setAttribute("ub",ub);
				//toppage.jsp�֓]��
				resc.setTarget("toppage");
			}
		}
		return resc;
	}
}