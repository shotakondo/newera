package exe;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class WebApplicationController implements ApplicationController{
	
	//RequestContext�̃t�@�N�g�����\�b�h
	public RequestContext getRequest(Object request){
		RequestContext reqc = new WebRequestContext();
		
		//HttpServletRequest�̎����N���X�̃C���X�^���X���Z�b�g����
		reqc.setRequest(request);
		
		return reqc;
	}
	
	//ResponseContext�̃t�@�N�g�����\�b�h�A�R�A�����̑I���Ǝ��s���s��
	public ResponseContext handleRequest(RequestContext req){
		
		AbstractCommand command = CommandFactory.getCommand(req);
		command.init(req);//Command������������
		
		//�R�}���h�����s����
		//�߂�l�Ƃ���ResponseContext�̃C���X�^���X�𓾂�
		//�����ŋ��ResponseContext�̃C���X�^���X�𓾂�
		ResponseContext resc = command.execute(new WebResponseContext());
		
		return resc;
	}
	
	//�R�A�����̌��ʂ̎擾�AView�̑I���Ɠ]�����s��
	public void handleResponse(RequestContext reqc, ResponseContext resc){
		
		//Object�^��Ԃ����߃L���X�g����K�v������
		HttpServletRequest req = (HttpServletRequest) reqc.getRequest();
		HttpServletResponse res = (HttpServletResponse) resc.getResponse();
		
		//�R�A�����̎��s���ʂ��擾���ēo�^���s��
		req.setAttribute("data", resc.getResult());
		
		RequestDispatcher rd = req.getRequestDispatcher(resc.getTarget());
		
		try{
			rd.forward(req, res);
		}catch(ServletException e){
			//�Ǝ���O�Ƀ��b�v����throw����
			e.printStackTrace();
		}catch(IOException e){
			//�Ǝ���O�Ƀ��b�v����throw����
			e.printStackTrace();
		}
	}
}