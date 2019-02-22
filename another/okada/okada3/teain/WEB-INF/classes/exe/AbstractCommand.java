package exe;

public abstract class AbstractCommand{
	
	//RequestContextを格納するインスタンス変数
	private RequestContext reqContext;
	
	public void init(RequestContext reqc){
		reqContext = reqc;
	}
	//protectedでもよい
	public RequestContext getRequestContext(){
		return reqContext;
	}
	
	public abstract ResponseContext execute(ResponseContext resc);
}