package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import dao.AbstractDaoFactory;
import dao.OracleConnectionManager;
import dao.ProductDao;

import exe.*;

public class TopPageFilter implements Filter {
	public void init(FilterConfig config) throws ServletException{
	}
	public void destroy(){
	}
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
	throws IOException, ServletException{
		
		HttpServletRequest hreq = (HttpServletRequest)req;
		
		HttpSession session = hreq.getSession();
		
		AbstractDaoFactory factory = AbstractDaoFactory.getFactory();
		ProductDao pd = factory.getProductDao();
		
		session.setAttribute("productlist", pd.getAllProducts());
		
		//トランザクションを終了する
		OracleConnectionManager.getInstance().commit();
		
		//コネクションを切断する
		OracleConnectionManager.getInstance().closeConnection();
		
		RequestDispatcher disp = req.getRequestDispatcher("toppage");
		disp.forward(req,res);
		
	}
}