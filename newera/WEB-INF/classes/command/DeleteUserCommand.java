package command;
import java.util.List;

import dao.*;
import context.*;
import beans.*;
import exp.*;

public class DeleteUserCommand extends AbstractCommand{
	public ResponseContext execute(ResponseContext resc){
		RequestContext reqc = getRequestContext();
		
		OracleConnectionManager.getInstance().beginTransaction();
		
		reqc.getSession();
		boolean b = reqc.attributeCheck("userBean");
		System.out.println("DeleteCommandAttributeCheck" + b);
		
		User ub = new User();
		
		try{
			
			ub = (User) reqc.getSessionAttribute("userBean");
			System.out.println((User) reqc.getSessionAttribute("userBean"));
			
		}catch(NullPointerException e){
			
			System.out.println("DeleteUserCommand getSession��null�������̂�catch�ɓ����ė�O�����܂���");
			throw new exp.NotLoginException("���O�C�����Ă�������", new RuntimeException());
			
		}
		
		String id = ub.getId();
		System.out.println(id);
		
		OracleConnectionManager.getInstance().beginTransaction();
		
		//�C���e�O���[�V�������C���̏������Ăяo��
		AbstractDaoFactory factory = AbstractDaoFactory.getFactory();
		UserDao dao=factory.getUserDao();
		DetailDao dd = factory.getDetailDao();
		OrderDao od = factory.getOrderDao();
		FavoriteDao fd = factory.getFavoriteDao();
		
		if(id!=null){
			System.out.println("ub!=null ������");
			List orders = od.getOrders(id);
			for(int i = 0; i < orders.size(); i++){
				OrderBean ob = (OrderBean)orders.get(i);
				dd.deleteDetails(ob.getOid());
			}
			od.deleteOrders(id);
			fd.deleteFavorites(id);
			dao.DeleteUser(id);
			//�g�����U�N�V�������I������
			OracleConnectionManager.getInstance().commit();
			
			//�R�l�N�V������ؒf����
			OracleConnectionManager.getInstance().closeConnection();
			System.out.println("DeleteUser(id)"+id);
			
			reqc.setRemoveAttribute("userBean");
			User u = new User();
			reqc.setSessionAttrbiute("userBean", u);
			System.out.println("�މ�܂���");
			resc.setTarget("home");
			
		}else{
			
			System.out.println("DeleteUserCommand id��null�������̂�catch�ɓ����ė�O�����܂���");
			throw new exp.asdfException("�މ�ł��܂���ł���", new RuntimeException());
			
		}
		
		
		
		return resc;
	}
}
