package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class OracleConnectionManager{
	
	private static OracleConnectionManager oraconn = null;
	private Connection cn = null;
	
	private OracleConnectionManager(){}
	
	public static OracleConnectionManager getInstance(){
		if(oraconn == null){
			oraconn = new OracleConnectionManager();
		}
		return oraconn;
	}
	
	public Connection getConnection(){
		if(cn == null){
			try{
				Class.forName("oracle.jdbc.driver.OracleDriver");
				
				cn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "info", "pro");
				
			}catch(ClassNotFoundException e){
				e.printStackTrace();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		return cn;
	}
	
	public void closeConnection(){
		try{
			if(cn != null){
				cn.close();
				cn= null;
				System.out.println("OracleConnectionManager : close");
				//command��close���Ă��邩�炱���̏������icn != null || cn == null�j�ɂ��邩
				//cn = null ���Ȃ��� connection���Ƃ�Ȃ�
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	
	public void beginTransaction(){
		if(cn == null){
			getConnection();
			System.out.println("OracleConnectionManager : getConnection");
		}
		try{
			cn.setAutoCommit(false);
			System.out.println("OracleConnectionManager : setAutoCommit");
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	
	public void commit(){
		try{
			if(cn != null || cn.isClosed() == false){
				cn.commit();
				System.out.println("OracleConnectionManager : commit");
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	
	public void rollback(){
		try{
			cn.rollback();
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
}