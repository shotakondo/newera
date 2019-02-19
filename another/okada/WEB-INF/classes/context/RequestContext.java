package context;

public interface RequestContext{
	public String getCommandPath();
	public String[] getParameter(String key);
	public Object getRequest();
	public void setRequest(Object request);
	Object getSessionObject(String object);
}
