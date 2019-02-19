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
			//�v���p�e�B�t�@�C����ǂݍ���
			prop.load(new FileInputStream("c:/webapps/j2ee4/dao.properties"));
			
			//dao�Ƃ����L�[�ɑΉ�������������擾���܂�
			String name = prop.getProperty("dao");
			
			//�w�肳�ꂽ���O�̃N���X�ɑΉ�����Class�N���X��
			//�C���X�^���X���擾����i���O�͊��S���薼�ł��邱�Ɓj
			Class c = Class.forName(name);
			
			//Class�N���X�̃C���X�^���X�𗘗p����
			//�Ή�����N���X�̃C���X�^���X�����s��
			factory = (AbstractDaoFactory) c.newInstance();
			
		}catch(FileNotFoundException e){
			//���ۂɂ͓Ǝ���O�Ƀ��b�v���ăX���[����
			throw new RuntimeException(e.getMessage(), e);
		}catch(IOException e){
			//���ۂɂ͓Ǝ���O�Ƀ��b�v���ăX���[����
			throw new RuntimeException(e.getMessage(), e);
		}catch(ClassNotFoundException e){
			//���ۂɂ͓Ǝ���O�Ƀ��b�v���ăX���[����
			throw new RuntimeException(e.getMessage(), e);
		}catch(InstantiationException e){
			//���ۂɂ͓Ǝ���O�Ƀ��b�v���ăX���[����
			throw new RuntimeException(e.getMessage(), e);
		}catch(IllegalAccessException e){
			//���ۂɂ͓Ǝ���O�Ƀ��b�v���ăX���[����
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