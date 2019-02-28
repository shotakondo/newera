package command;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletRequest;

import exe.*;
import beans.*;

public class EmailEntryCommand extends exe.AbstractCommand{
	
	//���[���A�h���X�\�����ݏ���(��)
	public ResponseContext execute(ResponseContext resc){
		
		RequestContext reqc = getRequestContext();
		HttpServletRequest req = (HttpServletRequest)reqc.getRequest();
		HttpSession session = req.getSession();
		
		//requestContext�̃C���X�^���X���擾����
		String email = reqc.getParameter("email")[0];
		
		//email�Ɋi�[����Ă��郁�[���A�h���X�ɖ{�l�m�F���[���𑗐M����
		
		//session��email���i�[����
		session.setAttribute("email", email);
		
		//subscribe�ɓ]������
		//�{����entrycomplete�ɓ]������
		resc.setTarget("subscribe");
		
		return resc;
	}
}