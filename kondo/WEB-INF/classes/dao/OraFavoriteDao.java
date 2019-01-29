package dao;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import exp.ResourceAccessException;

import beans.ProductBean;

public class OraFavoriteDao implements FavoriteDao{
	
	public List getFavorites(String uid){
		
		Connection cn = OracleConnectionManager.getInstance().getConnection();
		PreparedStatement st = null;
		ResultSet rs = null;
		
		ArrayList favorites = new ArrayList();
		
		ProductBean pb = new ProductBean();
		
		try{
			//insert文
			String sql = "select product_id, product_name, product_price, image_path from product_table a, image_table b, displayproduct_table c, user_table d, favorite_table e where c.displayproduct_product_id = a.product_id and c.displayproduct_image_id = b.image_id and e.favorite_user_id = d.user_id and e.favorite_product_id = a.product_id and image_path like '%|_01%' escape '|' and favorite_user_id = '"+ uid +"'";
			
			//PreparedStatementインターフェイスを実装するクラスの
			//インスタンスを取得する
			st = cn.prepareStatement(sql);
			
			//SQLの実行
			rs = st.executeQuery();
			
			while(rs.next()){
				
				pb.setPid(rs.getString(1));
				pb.setName(rs.getString(2));
				pb.setPrice(rs.getString(3));
				pb.setPath(rs.getString(4));
				
				favorites.add(pb);
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
	
	public void setFavorite(String uid, String pid){
		
		Connection cn = OracleConnectionManager.getInstance().getConnection();
		PreparedStatement st = null;
		
		try{
			//insert文
			String sql = "insert into favorite_table(favorite_user_id, favorite_product_id) values ('?','?')";
			
			//PreparedStatementインターフェイスを実装するクラスの
			//インスタンスを取得する
			st = cn.prepareStatement(sql);
			
			//パラメータをセットする
			st.setString(1, uid);
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