package dao;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.ProductBean;
import exp.ResourceAccessException;

public class OraProductDao implements ProductDao{
	
	public void addProduct(ProductBean pb){
		
		Connection cn = OracleConnectionManager.getInstance().getConnection();
		PreparedStatement st = null;
		
		try{
			//insert文
			String sql = "insert into product_table(product_id,product_name,prouct_price) values (?,?,?)";
			
			//PreparedStatementインターフェイスを実装するクラスの
			//インスタンスを取得する
			st = cn.prepareStatement(sql);
			
			//パラメータをセットする
			st.setString(1, pb.getPid());
			st.setString(2, pb.getName());
			st.setString(3, (String)pb.getPrice());
			
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
	
	public ProductBean getProduct(String pid){
		
		Connection cn = OracleConnectionManager.getInstance().getConnection();
		PreparedStatement st = null;
		ResultSet rs = null;
		
		ProductBean pb = new ProductBean();
		
		try{
			//insert文
			String sql = "select product_id, product_name, product_price, image_path from product_table a, image_table b, displayproduct_table c where c.displayproduct_product_id = a.product_id and c.displayproduct_image_id = b.image_id and product_id = '"+ pid +"'";
			
			//PreparedStatementインターフェイスを実装するクラスの
			//インスタンスを取得する
			st = cn.prepareStatement(sql);
			
			//SQLの実行
			rs = st.executeQuery();
			
			rs.next();
			
			pb.setPid(rs.getString(1));
			pb.setName(rs.getString(2));
			pb.setPrice(rs.getString(3));
			pb.setPath(rs.getString(4));
			
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
		return pb;
	}
	
	public List getAllProducts(){
		
		Connection cn = OracleConnectionManager.getInstance().getConnection();
		PreparedStatement st = null;
		ResultSet rs = null;
		
		ArrayList products = new ArrayList();
		
		try{
			//select文
			String sql = "select product_id, product_name, product_price, image_path from product_table a, image_table b, displayproduct_table c where c.displayproduct_product_id = a.product_id and c.displayproduct_image_id = b.image_id and image_path like '%|_01%' escape '|'";
			
			//PreparedStatementインターフェイスを実装するクラスの
			//インスタンスを取得する
			st = cn.prepareStatement(sql);
			
			//select文を送信し
			//ResultSetインターフェイスを実装したクラスの
			//インスタンスが返る
			rs = st.executeQuery();
			
			//カーソルを一行ずつスクロールし、データをフェッチする
			while(rs.next()){
				ProductBean pb = new ProductBean();
				
				pb.setPid(rs.getString(1));
				pb.setName(rs.getString(2));
				pb.setPrice(rs.getString(3));
				pb.setPath(rs.getString(4));
				
				//コレクションに追加する
				products.add(pb);
			}
			
			//コミットする
			cn.commit();
			
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
		return products;
	}
	
	public List getProducts(String pw){
		
		Connection cn = OracleConnectionManager.getInstance().getConnection();
		PreparedStatement st = null;
		ResultSet rs = null;
		
		ArrayList products = new ArrayList();
		
		ProductBean pb = new ProductBean();
		
		try{
			//select文
			String sql = "select product_id, product_name, product_price, image_path from product_table a, image_table b, displayproduct_table c where c.displayproduct_product_id = a.product_id and c.displayproduct_image_id = b.image_id and image_path like '%|_01%' escape '|' and product_name like '%"+ pw +"%'";
			
			//PreparedStatementインターフェイスを実装するクラスの
			//インスタンスを取得する
			st = cn.prepareStatement(sql);
			
			//select文を送信し
			//ResultSetインターフェイスを実装したクラスの
			//インスタンスが返る
			rs = st.executeQuery();
			
			//カーソルを一行ずつスクロールし、データをフェッチする
			while(rs.next()){
				
				pb.setPid(rs.getString(1));
				pb.setName(rs.getString(2));
				pb.setPrice(rs.getString(3));
				pb.setPath(rs.getString(4));
				
				//コレクションに追加する
				products.add(pb);
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
		return products;
	}
	
	public List getProductsName(){
		
		Connection cn = OracleConnectionManager.getInstance().getConnection();
		PreparedStatement st = null;
		ResultSet rs = null;
		
		ArrayList products = new ArrayList();
		
		try{
			//select文
			String sql = "select product_id, product_name, product_price, image_path from product_table a, image_table b, displayproduct_table c where c.displayproduct_product_id = a.product_id and c.displayproduct_image_id = b.image_id and image_path like '%|_01%' escape '|' order by product_name";
			
			//PreparedStatementインターフェイスを実装するクラスの
			//インスタンスを取得する
			st = cn.prepareStatement(sql);
			
			//select文を送信し
			//ResultSetインターフェイスを実装したクラスの
			//インスタンスが返る
			rs = st.executeQuery();
			
			//カーソルを一行ずつスクロールし、データをフェッチする
			while(rs.next()){
				ProductBean pb = new ProductBean();
				
				pb.setPid(rs.getString(1));
				pb.setName(rs.getString(2));
				pb.setPrice(rs.getString(3));
				pb.setPath(rs.getString(4));
				
				//コレクションに追加する
				products.add(pb);
			}
			
			//コミットする
			cn.commit();
			
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
		return products;
	}
	
	public List getProductsCheap(){
		
		Connection cn = OracleConnectionManager.getInstance().getConnection();
		PreparedStatement st = null;
		ResultSet rs = null;
		
		ArrayList products = new ArrayList();
		
		try{
			//select文
			String sql = "select product_id, product_name, product_price, image_path from product_table a, image_table b, displayproduct_table c where c.displayproduct_product_id = a.product_id and c.displayproduct_image_id = b.image_id and image_path like '%|_01%' escape '|' order by product_price";
			
			//PreparedStatementインターフェイスを実装するクラスの
			//インスタンスを取得する
			st = cn.prepareStatement(sql);
			
			//select文を送信し
			//ResultSetインターフェイスを実装したクラスの
			//インスタンスが返る
			rs = st.executeQuery();
			
			//カーソルを一行ずつスクロールし、データをフェッチする
			while(rs.next()){
				ProductBean pb = new ProductBean();
				
				pb.setPid(rs.getString(1));
				pb.setName(rs.getString(2));
				pb.setPrice(rs.getString(3));
				pb.setPath(rs.getString(4));
				
				//コレクションに追加する
				products.add(pb);
			}
			
			//コミットする
			cn.commit();
			
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
		return products;
	}
	public List getProductsExpensive(){
		
		Connection cn = OracleConnectionManager.getInstance().getConnection();
		PreparedStatement st = null;
		ResultSet rs = null;
		
		ArrayList products = new ArrayList();
		
		try{
			//select文
			String sql = "select product_id, product_name, product_price, image_path from product_table a, image_table b, displayproduct_table c where c.displayproduct_product_id = a.product_id and c.displayproduct_image_id = b.image_id and image_path like '%|_01%' escape '|' order by product_price desc";
			
			//PreparedStatementインターフェイスを実装するクラスの
			//インスタンスを取得する
			st = cn.prepareStatement(sql);
			
			//select文を送信し
			//ResultSetインターフェイスを実装したクラスの
			//インスタンスが返る
			rs = st.executeQuery();
			
			//カーソルを一行ずつスクロールし、データをフェッチする
			while(rs.next()){
				ProductBean pb = new ProductBean();
				
				pb.setPid(rs.getString(1));
				pb.setName(rs.getString(2));
				pb.setPrice(rs.getString(3));
				pb.setPath(rs.getString(4));
				
				//コレクションに追加する
				products.add(pb);
			}
			
			//コミットする
			cn.commit();
			
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
		return products;
	}
}