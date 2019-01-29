package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class OracleConnectionManager{
	
	private static OracleConnectionManager oraconn = null;
	private Connection cn;
	
	private OracleConnectionManager(){
	}
	
	//�V���O���g���p�^�[����K�p����
	public static OracleConnectionManager getInstance(){
		if(oraconn == null){
			oraconn = new OracleConnectionManager();
		}
		return oraconn;
	}
	
	public Connection getConnection(){
		
		try{
			//Driver�C���^�[�t�F�C�X�������N���X�����[�h����
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//Connection�C���^�[�t�F�C�X����������N���X��
			//�C���X�^���X��Ԃ�
			cn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","info","pro");
			
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return cn;
	}
	
	public void closeConnection(){
		try{
			if(cn != null){
				cn.close();
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	
	public void beginTransaction(){
		try{
			if(cn == null || cn.isClosed()){
				getConnection();
			}
			//�����R�~�b�g��OFF�ɂ���
			cn.setAutoCommit(false);
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	
	public void commit(){
		//�R�~�b�g����
		try{
			cn.commit();
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	
	public void rollback(){
		//���[���o�b�N����
		try{
			cn.rollback();
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
}
