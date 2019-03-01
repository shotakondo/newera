package context;

public interface RequestContext{
	public String getCommandPath();
	public String[] getParameter(String key);
	public Object getRequest();
	public Object getSession();
	//public Object getAttribute();
	//public Object getRequestDispatcher(String b);
	public Object getSessionAttribute(String a);
	//public Object getRemoveAttribute();
	public boolean attributeCheck(String beanname);
	public void setSessionAttribute(String name, Object o);
	public void setRemoveAttribute(String n);
	public void setRequest(Object request);
	public  String[] getUrlParameter();
	public void sessionInvalidate();
	
}
