package exe;

public interface ApplicationController{
	//RequestContext�̃t�@�N�g�����\�b�h
	RequestContext getRequest(Object request);
	
	//ResponseContext�̃t�@�N�g�����\�b�h
	ResponseContext handleRequest(RequestContext req);
	
	//�K�v�ɉ����ė�O�錾��������i�Ǝ��̗�O�ɂ��Ă����j
	void handleResponse(RequestContext req, ResponseContext res);
}