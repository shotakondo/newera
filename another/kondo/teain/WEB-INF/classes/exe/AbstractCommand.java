package exe;

public abstract class AbstractCommand{
	
	//RequestContext���i�[����C���X�^���X�ϐ�
	private RequestContext reqContext;
	
	public void init(RequestContext reqc){
		reqContext = reqc;
	}
	//protected�ł��悢
	public RequestContext getRequestContext(){
		return reqContext;
	}
	
	public abstract ResponseContext execute(ResponseContext resc);
}