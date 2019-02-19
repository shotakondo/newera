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
			prop.load(new FileInputStream("C:/WEB-UPS/N/dao2.properties"));
			
			String name = prop.getProperty("dao");
			
			Class c = Class.forName(name);
			
			factory = (AbstractDaoFactory)c.newInstance();
			
		}catch(FileNotFoundException e){
			e.printStackTrace();
			throw new RuntimeException(e.getMessage(), e);
		}catch(IOException e){
			e.printStackTrace();
			throw new RuntimeException(e.getMessage(), e);
		}catch(ClassNotFoundException e){
			e.printStackTrace();
			throw new RuntimeException(e.getMessage(), e);
		}catch(InstantiationException e){
			e.printStackTrace();
			throw new RuntimeException(e.getMessage(), e);
		}catch(IllegalAccessException e){
			e.printStackTrace();
			throw new RuntimeException(e.getMessage(), e);
		}
		return factory;
	}
	//add!
	public abstract ProductsDao getProductsDao();
	/*-----------------------------------------------*/
	
	
	public abstract UserDao getUserDao();
	
	
	
	
	
	
	
}