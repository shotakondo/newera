package command;

import exe.*;

public class ProductsSearchCommand extends AbstractCommand{

	public ResponseContext execute(ResponseContext resc){
		//���i��������
		
		//�����̏ꍇ��productsdisplay.jsp�֓]��
		resc.setTarget("productsdisplay");
		
		//���s�̏ꍇ�����̃y�[�W�֓]��
		
		return resc;
	}
}