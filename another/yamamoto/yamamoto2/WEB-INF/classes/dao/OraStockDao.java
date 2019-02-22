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
			//select��
			String sql = "SELECT  stock_amount FROM stock_table WHERE stock_product_id = '" + pid + "'";
			
			//PreparedStatement�C���^�[�t�F�C�X����������N���X��
			//�C���X�^���X���擾����
			st = cn.prepareStatement(sql);
			
			//select���𑗐M��
			//ResultSet�C���^�[�t�F�C�X�����������N���X��
			//�C���X�^���X���Ԃ�
			rs = st.executeQuery();
			
			//�J�[�\������s���X�N���[�����A�f�[�^���t�F�b�`����
			rs.next();
			
			num =  Integer.parseInt(rs.getString(1));
			
		//getConnection, prepareStatement, executeQuery�ŗ�O�����̏ꍇ
		}catch(SQLException e){
			//���[���o�b�N����
			try{
				cn.rollback();
			}catch(SQLException e2){
				//�Ǝ���O�Ƀ��b�v���đ��o����
				throw new ResourceAccessException(e2.getMessage(), e2);
			}
			
			//�Ǝ���O�Ƀ��b�v���đ��o����
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
			//select��
			String sql = "update stock_table set stock_amount = (stock_amount - ?) where stock_product_id = ?";
			
			//PreparedStatement�C���^�[�t�F�C�X����������N���X��
			//�C���X�^���X���擾����
			st = cn.prepareStatement(sql);
			
			//�p�����[�^���Z�b�g����
			st.setInt(1, num);
			st.setString(2, pid);
			
			st.executeUpdate();
			
		//getConnection, prepareStatement, executeQuery�ŗ�O�����̏ꍇ
		}catch(SQLException e){
			//���[���o�b�N����
			try{
				cn.rollback();
			}catch(SQLException e2){
				//�Ǝ���O�Ƀ��b�v���đ��o����
				throw new ResourceAccessException(e2.getMessage(), e2);
			}
			
			//�Ǝ���O�Ƀ��b�v���đ��o����
			throw new ResourceAccessException(e.getMessage(), e);
			
		}
	}
}