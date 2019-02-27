package command;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletRequest;
import dao.AbstractDaoFactory;
import dao.OracleConnectionManager;
import dao.FavoriteDao;

import context.*;
import beans.*;

public class FavoriteAddCommand extends AbstractCommand{
	
	//���C�ɓ���ǉ�����
	public ResponseContext execute(ResponseContext resc){
		
		RequestContext reqc = getRequestContext();
		HttpServletRequest req = (HttpServletRequest)reqc.getRequest();
		HttpSession session = req.getSession();
		
		User u = (User)session.getAttribute("userBean");
		String id = u.getId();
		
		String[] pids = reqc.getParameter("pid");
		String pid = pids[0];
		
		//�g�����U�N�V�������J�n����
		OracleConnectionManager.getInstance().beginTransaction();
		
		//�C���e�O���[�V�������C���̏������Ăяo��
		AbstractDaoFactory factory = AbstractDaoFactory.getFactory();
		FavoriteDao fd = factory.getFavoriteDao();
		
		fd.setFavorite(id, pid);
		resc.setResult(fd.getFavorites(id));
		
		//�g�����U�N�V�������I������
		OracleConnectionManager.getInstance().commit();
		
		//�R�l�N�V������ؒf����
		OracleConnectionManager.getInstance().closeConnection();
		
		//favoritedisplay.jsp�֓]��
		resc.setTarget("favoritedisplay");
		
		return resc;
	}
}