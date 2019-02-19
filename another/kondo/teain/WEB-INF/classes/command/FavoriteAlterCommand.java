package command;

import dao.AbstractDaoFactory;
import dao.OracleConnectionManager;
import dao.FavoriteDao;

import exe.*;
import beans.UserBean;

public class FavoriteAlterCommand extends AbstractCommand{
	
	//���C�ɓ���ǉ�����
	public ResponseContext execute(ResponseContext resc){
		
		RequestContext reqc = getRequestContext();
		
		UserBean ub = (UserBean)reqc.getSessionAttribute("ub");
		String uid = ub.getUid();
		String[] pids = reqc.getParameter("pid");
		String pid = pids[0];
		String[] comments = reqc.getParameter("comment");
		String comment = comments[0];
		
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