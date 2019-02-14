package dao;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.Product;
import exp.ResourceAccessException;

public class OraProductsDao implements ProductsDao{
	
	public void addProduct(Product p){
		
		PreparedStatement st = null;
		
		try{
			//insert��
			String sql = "insert into t_products(pid,name,price)" + "values(?,?,?)";
			
			//PreparedStatement�C���^�[�t�F�C�X����������N���X��
			//�C���X�^���X���擾����
			st = cn.prepareStatement(sql);
			
			//�p�����[�^���Z�b�g����
			st.setString(1, p.getPid());
			st.setString(2, p.getName());
			st.setString(3, p.getPrice());
			
			//SQL�̎��s
			st.executeUpdate();
			
			//Class.forName()�ŗ�O�����̏ꍇ
		}catch(ClassNotFoundException e){
			//�Ǝ���O�Ƀ��b�v���đ��o����
			throw new ResourceAccessException(e.getMessage(), e);
			
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
			
		}finally{
			//���\�[�X�̊J���������s��
			try{
				if(st != null){
					st.close();
				}
			}catch(SQLException e2){
				//�Ǝ���O�Ƀ��b�v���đ��o����
				throw new ResourceAccessException(e2.getMessage(), e2);
				
			}finally{
				try{
					if(cn != null){
						cn.close();
					}
				}catch(SQLException e3){
					//�Ǝ���O�Ƀ��b�v���đ��o����
					throw new ResourceAccessException(e3.getMessage(), e3);
				}
			}
		}
	}
	
	public Product getProduct(String pid){
		return null;
	}
	
	public List getAllProducts(){
		
		PreparedStatement st = null;
		ResultSet rs = null;
		
		ArrayList products = new ArrayList();
		
		try{
			//select��
			String sql = "select pid, name, price from t_products order by lpad(pid,6,0)";
			
			//PreparedStatement�C���^�[�t�F�C�X����������N���X��
			//�C���X�^���X���擾����
			st = cn.prepareStatement(sql);
			
			//select���𑗐M��
			//ResultSet�C���^�[�t�F�C�X�����������N���X��
			//�C���X�^���X���Ԃ�
			rs = st.executeQuery();
			
			//�J�[�\������s���X�N���[�����A�f�[�^���t�F�b�`����
			while(rs.next()){
				Product p = new Product();
				
				p.setPid(rs.getString(1));
				p.setName(rs.getString(2));
				p.setPrice(rs.getString(3));
				
				//�R���N�V�����ɒǉ�����
				products.add(p);
			}
			
			//�R�~�b�g����
			cn.commit();
			
			//Class.forName()�ŗ�O�����̏ꍇ
		}catch(ClassNotFoundException e){
			//�Ǝ���O�Ƀ��b�v���đ��o����
			throw new ResourceAccessException(e.getMessage(), e);
			
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
			
		}finally{
			//���\�[�X�̊J���������s��
			try{
				if(rs != null){
					rs.close();
				}
				if(st != null){
					st.close();
				}
			}catch(SQLException e2){
				//�Ǝ���O�Ƀ��b�v���đ��o����
				throw new ResourceAccessException(e2.getMessage(), e2);
			}finally{
				try{
					if(cn != null){
						cn.close();
					}
				}catch(SQLException e3){
					//�Ǝ���O�Ƀ��b�v���đ��o����
					throw new ResourceAccessException(e3.getMessage(), e3);
				}
			}
		}
		
		return products;
	}
}