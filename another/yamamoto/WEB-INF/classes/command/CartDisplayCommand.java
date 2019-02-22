package command;

import dao.AbstractDaoFactory;
import dao.ProductDao;
import dao.OracleConnectionManager;

import context.*;

public class CartDisplayCommand extends AbstractCommand{
	
	//�J�[�g�\���@�\
	public ResponseContext execute(ResponseContext resc){
		
		//cartdisplay.jsp�֓]��
		resc.setTarget("cartdisplay");
		
		return resc;
	}
}