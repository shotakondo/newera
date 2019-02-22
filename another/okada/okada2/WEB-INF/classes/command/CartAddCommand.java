package command;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletRequest;

import dao.AbstractDaoFactory;
import dao.OracleConnectionManager;
import dao.*;

import context.*;
import beans.*;


public class CartAddCommand extends AbstractCommand{
	
	//�J�[�g�ǉ�����
	public ResponseContext execute(ResponseContext resc){
		
		RequestContext reqc = getRequestContext();
		HttpServletRequest req = (HttpServletRequest)reqc.getRequest();
		HttpSession session = req.getSession();
		
		String[] pids = reqc.getParameter("pid");
		String pid = pids[0];
		System.out.println("CartAddCommand pid : "+pid);
		
		User u = (User)session.getAttribute("userBean");
		if(u == null){
			u = new User();
		}
		
		CartBean cb = u.getCart();
		if(cb == null){
			cb = new CartBean();
		}
		
		//�g�����U�N�V�������J�n����
		OracleConnectionManager.getInstance().beginTransaction();
		
		//�C���e�O���[�V�������C���̏������Ăяo��
		AbstractDaoFactory factory = AbstractDaoFactory.getFactory();
		ProductDao pd = factory.getProductDao();
		
		ProductBean pb = new ProductBean();
		
		pb = pd.getProduct(pid);
		
		System.out.println("CartAddCommand pb.getPid : "+pb.getPid());
		System.out.println("CartAddCommand pb.getName : "+pb.getName());
		System.out.println("CartAddCommand pb.getPath : "+pb.getPath());
		
				
		u.setCart(cb);
		
		System.out.println("CartAddCommand u.getCart : "+u.getCart());
		
		session.setAttribute("userBean", u);
		
		//�g�����U�N�V�������I������
		OracleConnectionManager.getInstance().commit();
		
		//�R�l�N�V������ؒf����
		OracleConnectionManager.getInstance().closeConnection();
		
		//cartdisplay.jsp�֓]��
		resc.setTarget("cartdisplay");
		
		return resc;
	}
}