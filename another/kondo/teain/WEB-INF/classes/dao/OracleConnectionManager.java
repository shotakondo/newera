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
				System.out.println("close");
				//commandでcloseしているからここの条件を（cn != null || cn == null）にするか
				//cn = null しないと connectionがとれない
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	
	public void beginTransaction(){
		if(cn == null){
			getConnection();
			System.out.println("getConnection");
		}
		try{
			cn.setAutoCommit(false);
			System.out.println("setAutoCommit");
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	
	public void commit(){
		try{
			if(cn != null || cn.isClosed() == false){
				cn.commit();
				System.out.println("commit");
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