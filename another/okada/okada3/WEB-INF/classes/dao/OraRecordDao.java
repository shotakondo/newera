package dao;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.RecordBean;
import exp.ResourceAccessException;

public class OraRecordDao implements RecordDao{
	
	public void addRecord(RecordBean rb){
		
		Connection cn = OracleConnectionManager.getInstance().getConnection();
		PreparedStatement st = null;
		
		try{
			//insert文
			String sql = "insert into t_products_record(pid,userid) values (?,?)";
			
			//PreparedStatementインターフェイスを実装するクラスの
			//インスタンスを取得する
			st = cn.prepareStatement(sql);
			
			//パラメータをセットする
			st.setString(1, rb.getPid());
			st.setString(2, rb.getUid());
			
			//SQLの実行
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
	
	public RecordBean getRecord(String pid, String uid){
		return null;
	}
	
	public List getAllRecords(){
		
		Connection cn = OracleConnectionManager.getInstance().getConnection();
		PreparedStatement st = null;
		ResultSet rs = null;
		
		ArrayList records = new ArrayList();
		
		try{
			//select文
			String sql = "SELECT p.pid, p.name, p.price, u.name, tp.insert_date FROM t_products p, t_products_record tp, t_user u WHERE p.pid = tp.pid AND u.userid = tp.userid";
			
			//PreparedStatementインターフェイスを実装するクラスの
			//インスタンスを取得する
			st = cn.prepareStatement(sql);
			
			//select文を送信し
			//ResultSetインターフェイスを実装したクラスの
			//インスタンスが返る
			rs = st.executeQuery();
			
			//カーソルを一行ずつスクロールし、データをフェッチする
			while(rs.next()){
				RecordBean rb = new RecordBean();
				
				rb.setPid(rs.getString(1));
				rb.setName(rs.getString(2));
				rb.setPrice(rs.getString(3));
				rb.setUname(rs.getString(4));
				rb.setDate(rs.getString(5));
				
				//コレクションに追加する
				records.add(rb);
			}
			
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
		return records;
	}
}