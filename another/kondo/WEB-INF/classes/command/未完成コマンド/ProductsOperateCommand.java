package command;

import exe.*;

public class ProductsOperateCommand extends AbstractCommand{

	public ResponseContext execute(ResponseContext resc){
		//���i�\������
		
		//productsoperate.jsp�֓]��
		resc.setTarget("productsoperate");
		
		return resc;
	}
}