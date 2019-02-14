package dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public abstract class AbstractDaoFactory{
	
	public static AbstractDaoFactory getFactory(){
		
		AbstractDaoFactory factory = null;
		Properties prop = new Properties();
		
		try{
			//プロパティファイルを読み込む
			prop.load(new FileInputStream("c:/webapps/j2ee4/dao.properties"));
			
			//daoというキーに対応した文字列を取得します
			String name = prop.getProperty("dao");
			
			//指定された名前のクラスに対応したClassクラスの
			//インスタンスを取得する（名前は完全限定名であること）
			Class c = Class.forName(name);
			
			//Classクラスのインスタンスを利用して
			//対応するクラスのインスタンス化を行う
			factory = (AbstractDaoFactory) c.newInstance();
			
		}catch(FileNotFoundException e){
			//実際には独自例外にラップしてスローする
			throw new RuntimeException(e.getMessage(), e);
		}catch(IOException e){
			//実際には独自例外にラップしてスローする
			throw new RuntimeException(e.getMessage(), e);
		}catch(ClassNotFoundException e){
			//実際には独自例外にラップしてスローする
			throw new RuntimeException(e.getMessage(), e);
		}catch(InstantiationException e){
			//実際には独自例外にラップしてスローする
			throw new RuntimeException(e.getMessage(), e);
		}catch(IllegalAccessException e){
			//実際には独自例外にラップしてスローする
			throw new RuntimeException(e.getMessage(), e);
		}
		
		return factory;
	}
	
	public abstract ProductDao getProductDao();
	public abstract UserDao getUserDao();
	public abstract CartDao getCartDao();
	public abstract FavoriteDao getFavoriteDao();
	public abstract StockDao getStockDao();
	public abstract OrderDao getOrderDao();
	public abstract DetailDao getDetailDao();
	
}