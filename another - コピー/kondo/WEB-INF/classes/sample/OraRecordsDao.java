package dao;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.Record;
import exp.ResourceAccessException;

public class OraRecordsDao implements RecordsDao{
	
	public void addRecord(Record p){
		
		PreparedStatement st = null;
		
		try{
			//insert文
			String sql = "";
			
			//PreparedStatementインターフェイスを実装するクラスの
			//インスタンスを取得する
			st = cn.prepareStatement(sql);
			
			//パラメータをセットする
			
			//SQLの実行
			st.executeUpdate();
			
			//Class.forName()で例外発生の場合
		}catch(ClassNotFoundException e){
			//独自例外にラップして送出する
			throw new ResourceAccessException(e.getMessage(), e);
			
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
			
		}finally{
			//リソースの開放処理を行う
			try{
				if(st != null){
					st.close();
				}
			}catch(SQLException e2){
				//独自例外にラップして送出する
				throw new ResourceAccessException(e2.getMessage(), e2);
				
			}finally{
				try{
					if(cn != null){
						cn.close();
					}
				}catch(SQLException e3){
					//独自例外にラップして送出する
					throw new ResourceAccessException(e3.getMessage(), e3);
				}
			}
		}
	}
	
	public Record getRecord(String pid){
		return null;
	}
	
	public List getAllRecords(){
		
		PreparedStatement st = null;
		ResultSet rs = null;
		
		ArrayList records = new ArrayList();
		
		try{
			//select文
			String sql = "";
			
			//PreparedStatementインターフェイスを実装するクラスの
			//インスタンスを取得する
			st = cn.prepareStatement(sql);
			
			//select文を送信し
			//ResultSetインターフェイスを実装したクラスの
			//インスタンスが返る
			rs = st.executeQuery();
			
			//カーソルを一行ずつスクロールし、データをフェッチする
			while(rs.next()){
				Record r = new Record();
				
				r.setPid(rs.getString(1));
				r.setName(rs.getString(2));
				r.setPrice(rs.getString(3));
				r.setUname(rs.getString(4))
				
				//コレクションに追加する
				records.add(p);
			}
			
			//Class.forName()で例外発生の場合
		}catch(ClassNotFoundException e){
			//独自例外にラップして送出する
			throw new ResourceAccessException(e.getMessage(), e);
			
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
			
		}finally{
			//リソースの開放処理を行う
			try{
				if(rs != null){
					rs.close();
				}
				if(st != null){
					st.close();
				}
			}catch(SQLException e2){
				//独自例外にラップして送出する
				throw new ResourceAccessException(e2.getMessage(), e2);
			}finally{
				try{
					if(cn != null){
						cn.close();
					}
				}catch(SQLException e3){
					//独自例外にラップして送出する
					throw new ResourceAccessException(e3.getMessage(), e3);
				}
			}
		}
		
		return records;
	}
}