package command;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletRequest;

import dao.AbstractDaoFactory;
import dao.OracleConnectionManager;
import dao.FavoriteDao;

import context.*;
import beans.User;
import exp.*;

public class FavoriteDisplayCommand extends AbstractCommand{
	
	//���C�ɓ���\������
	public ResponseContext execute(ResponseContext resc){
		
		RequestContext reqc = getRequestContext();
		HttpServletRequest req = (HttpServletRequest)reqc.getRequest();
		HttpSession session = req.getSession();
		
		User u = (User)session.getAttribute("userBean");
		String id = u.getId();
			System.out.println("id = u.getId()"+id);
			
		
		if(id == null){
			System.out.println("FavoriteDisplayCommand id��null������=���O�C�����Ă��Ȃ��̂ŗ�O�����܂���");
			throw new exp.favoriteException("���O�C�����Ă��������B", new RuntimeException());
		}
			
				
		//�g�����U�N�V�������J�n����
		OracleConnectionManager.getInstance().beginTransaction();
		
		//�C���e�O���[�V�������C���̏������Ăяo��
		AbstractDaoFactory factory = AbstractDaoFactory.getFactory();
		FavoriteDao fd = factory.getFavoriteDao();
		
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