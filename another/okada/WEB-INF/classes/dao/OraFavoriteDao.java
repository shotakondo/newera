package dao;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import exp.ResourceAccessException;

import beans.FavoriteBean;

public class OraFavoriteDao implements FavoriteDao{
	
	public List getFavorites(String id){
		
		Connection cn = OracleConnectionManager.getInstance().getConnection();
		PreparedStatement st = null;
		ResultSet rs = null;
		
		ArrayList favorites = new ArrayList();
		
		try{
			//insert文
			String sql = "select distinct product_id, product_name, product_price, image_path, favorite_date from product_table a, image_table b, displayproduct_table c, user_table d, favorite_table e where c.displayproduct_product_id = a.product_id and c.displayproduct_image_id = b.image_id and e.favorite_user_id = d.user_id and e.favorite_product_id = a.product_id and image_path like '%|_01%' escape '|' and favorite_user_id = '"+ id +"'";
			
			//PreparedStatementインターフェイスを実装するクラスの
			//インスタンスを取得する
			st = cn.prepareStatement(sql);
			
			//SQLの実行
			rs = st.executeQuery();
			
			while(rs.next()){
				FavoriteBean fb = new FavoriteBean();
				
				fb.setPid(rs.getString(1));
				fb.setName(rs.getString(2));
				fb.setPrice(rs.getString(3));
				fb.setPath(rs.getString(4));
				fb.setDate(rs.getString(5));
				
				
				favorites.add(fb);
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
		return favorites;
	}
	
	public void setFavorite(String id, String pid){
		
		Connection cn = OracleConnectionManager.getInstance().getConnection();
		PreparedStatement st = null;
		
		try{
			//insert文
			String sql = "insert into favorite_table(favorite_user_id, favorite_product_id, favorite_date) values (?,?,default)";
			
			//PreparedStatementインターフェイスを実装するクラスの
			//インスタンスを取得する
			st = cn.prepareStatement(sql);
			
			//パラメータをセットする
			st.setString(1, id);
			st.setString(2, pid);
			
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
	
	public void deleteFavorite(String id, String pid){
		
		Connection cn = OracleConnectionManager.getInstance().getConnection();
		PreparedStatement st = null;
		
		try{
			//insert文
			String sql = "delete from favorite_table where favorite_user_id = ? and favorite_product_id = ?";
			
			//PreparedStatementインターフェイスを実装するクラスの
			//インスタンスを取得する
			st = cn.prepareStatement(sql);
			
			//パラメータをセットする
			st.setString(1, id);
			st.setString(2, pid);
			
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
	
	public void alterFavorite(String id, String pid){
		
		Connection cn = OracleConnectionManager.getInstance().getConnection();
		PreparedStatement st = null;
		
		try{
			//insert文
			String sql = "insert into favorite_table(favorite_user_id, favorite_product_id, favorite_date) values (?,?,default)";
			
			//PreparedStatementインターフェイスを実装するクラスの
			//インスタンスを取得する
			st = cn.prepareStatement(sql);
			
			//パラメータをセットする
			st.setString(1, id);
			st.setString(2, pid);
			
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
	
}