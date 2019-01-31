package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class OracleConnectionManager {
		public static String sqlDB = null;
		public Connection cn = null;
		public OracleConnectionManager() {

		}
		
		public Connection cn() throws Exception{
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				cn = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:orcl","info","pro");
				return cn;
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			return null;
		}
		public  void getSQL(String sql) throws Exception{
			Connection cn =cn();
			Statement stmt = cn.createStatement();
			stmt.executeUpdate(sql);
		}
		public ResultSet getResultSet(String sql) throws Exception{
			Connection cn =cn();
			Statement stmt = cn.createStatement();
			ResultSet rs=	stmt.executeQuery(sql);
			return rs;
		}
		
	
		public PreparedStatement getStatement(String sql) throws SQLException, Exception{
			return cn().prepareStatement(sql);
		}
		
	public static void main(String[] args) throws Exception {
		System.out.println(new OracleConnectionManager().cn());
	}
}
