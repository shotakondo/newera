package command;

import exe.*;

public class ProductsNarrowCommand extends AbstractCommand{

	public ResponseContext execute(ResponseContext resc){
		//���i�i�荞�ݏ���
		
		//�Z�b�V�����Ȃ��܂��̓��[�U�[�̃Z�b�V�����������Ă���ꍇ��productsdisplay.jsp�֓]��
		resc.setTarget("productsdisplay");
		
		//�Ǘ��҂̃Z�b�V�����������Ă���ꍇ��productsoperate.jsp�֓]��
		resc.setTarget("productsoperate");
		
		return resc;
	}
}