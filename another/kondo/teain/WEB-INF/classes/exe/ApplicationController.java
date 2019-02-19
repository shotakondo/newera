package exe;

public interface ApplicationController{
	//RequestContextのファクトリメソッド
	RequestContext getRequest(Object request);
	
	//ResponseContextのファクトリメソッド
	ResponseContext handleRequest(RequestContext req);
	
	//必要に応じて例外宣言を加える（独自の例外にしておく）
	void handleResponse(RequestContext req, ResponseContext res);
}