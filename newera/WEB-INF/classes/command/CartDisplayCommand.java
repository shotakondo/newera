package command;

import dao.AbstractDaoFactory;
import dao.ProductDao;
import dao.OracleConnectionManager;

import exe.*;

public class CartDisplayCommand extends exe.AbstractCommand{
	
	//�J�[�g�\���@�\
	public ResponseContext execute(ResponseContext resc){
		
		//cartdisplay.jsp�֓]��
		resc.setTarget("cartdisplay");
		
		return resc;
	}
}