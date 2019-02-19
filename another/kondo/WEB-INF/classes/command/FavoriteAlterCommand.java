package command;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletRequest;

import dao.AbstractDaoFactory;
import dao.OracleConnectionManager;
import dao.FavoriteDao;

import exe.*;
import beans.UserBean;

public class FavoriteAlterCommand extends AbstractCommand{
	
	//���C�ɓ���ǉ�����
	public ResponseContext execute(ResponseContext resc){
		
		RequestContext reqc = getRequestContext();
		HttpServletRequest req = (HttpServletRequest)reqc.getRequest();
		HttpSession session = req.getSession();
		
		UserBean ub = (UserBean)session.getAttribute("ub");
		String uid = ub.getUid();
		String pid = reqc.getParameter("pid")[0];
		String comment = reqc.getParameter("comment")[0];
		
		//�l�������Ă��邩�m�F
		if (comment != null || comment.length() != 0){
			
			//�g�����U�N�V�������J�n����
			OracleConnectionManager.getInstance().beginTransaction();
			
			//�C���e�O���[�V�������C���̏������Ăяo��
			AbstractDaoFactory factory = AbstractDaoFactory.getFactory();
			FavoriteDao fd = factory.getFavoriteDao();
			
			fd.alterFavorite(uid, pid, comment);
			resc.setResult(fd.getFavorites(uid));
			
			//�g�����U�N�V�������I������
			OracleConnectionManager.getInstance().commit();
			
			//�R�l�N�V������ؒf����
			OracleConnectionManager.getInstance().closeConnection();
			
		}
		
		//favoritedisplay.jsp�֓]��
		resc.setTarget("favoritedisplay");
		
		return resc;
	}
}