package exe;

public interface RequestContext{
	
	public String getCommandPath();
	public String[] getParameter(String key);
	public Object getRequest();
	public void setRequest(Object request);
	public Object getSession();
	public Object getSessionAttribute(String param);
	public void setSessionAttribute(String name, Object beanobject);
	public void setRemoveAttribute(String beanname);
	public  String[] getUrlParameter();
	
}
