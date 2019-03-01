package dao;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import exp.ResourceAccessException;

public class OraStockDao implements StockDao{
	
	public int getStock(String pid){
		
		Connection cn = OracleConnectionManager.getInstance().getConnection();
		PreparedStatement st = null;
		ResultSet rs = null;
		
		int num = 0;
		
		try{
			//select文
			String sql = "SELECT  stock_amount FROM stock_table WHERE stock_product_id = '" + pid + "'";
			
			//PreparedStatementインターフェイスを実装するクラスの
			//インスタンスを取得する
			st = cn.prepareStatement(sql);
			
			//select文を送信し
			//ResultSetインターフェイスを実装したクラスの
			//インスタンスが返る
			rs = st.executeQuery();
			
			//カーソルを一行ずつスクロールし、データをフェッチする
			rs.next();
			
			num =  Integer.parseInt(rs.getString(1));
			
		//getConnection, prepareStatement, executeQueryで例外発生の場合
		}catch(SQLException e){
			//ロールバックする
			try{
				cn.rollback();
			}catch(SQLException e2){
				//独自例外にラップして送出する
				throw new ResourceAccessException(e2.getMessage(), e2);
			}
			
			//独自例外にラップして送出する
			throw new ResourceAccessException(e.getMessage(), e);
			
		}
		return num;
	}
	public void setStock(int num, String pid){
	}
	
	public void alterStock(int num, String pid){
		
		Connection cn = OracleConnectionManager.getInstance().getConnection();
		PreparedStatement st = null;
		
		try{
			//select文
			String sql = "update stock_table set stock_amount = (stock_amount - ?) where stock_product_id = ?";
			
			//PreparedStatementインターフェイスを実装するクラスの
			//インスタンスを取得する
			st = cn.prepareStatement(sql);
			
			//パラメータをセットする
			st.setInt(1, num);
			st.setString(2, pid);
			
			st.executeUpdate();
			
		//getConnection, prepareStatement, executeQueryで例外発生の場合
		}catch(SQLException e){
			//ロールバックする
			try{
				cn.rollback();
			}catch(SQLException e2){
				//独自例外にラップして送出する
				throw new ResourceAccessException(e2.getMessage(), e2);
			}
			
			//独自例外にラップして送出する
			throw new ResourceAccessException(e.getMessage(), e);
			
		}
	}
}