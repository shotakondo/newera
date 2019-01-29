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
			//insert��
			String sql = "insert into product_table(product_id,product_name,prouct_price) values (?,?,?)";
			
			//PreparedStatement�C���^�[�t�F�C�X����������N���X��
			//�C���X�^���X���擾����
			st = cn.prepareStatement(sql);
			
			//�p�����[�^���Z�b�g����
			st.setString(1, pb.getPid());
			st.setString(2, pb.getName());
			st.setString(3, (String)pb.getPrice());
			
			//SQL�̎��s
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
	
	public ProductBean getProduct(String pid){
		
		Connection cn = OracleConnectionManager.getInstance().getConnection();
		PreparedStatement st = null;
		ResultSet rs = null;
		
		ProductBean pb = new ProductBean();
		
		try{
			//insert��
			String sql = "select product_id, product_name, product_price, image_path from product_table a, image_table b, displayproduct_table c where c.displayproduct_product_id = a.product_id and c.displayproduct_image_id = b.image_id and product_id = '"+ pid +"'";
			
			//PreparedStatement�C���^�[�t�F�C�X����������N���X��
			//�C���X�^���X���擾����
			st = cn.prepareStatement(sql);
			
			//SQL�̎��s
			rs = st.executeQuery();
			
			rs.next();
			
			pb.setPid(rs.getString(1));
			pb.setName(rs.getString(2));
			pb.setPrice(rs.getString(3));
			pb.setPath(rs.getString(4));
			
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
		return pb;
	}
	
	public List getAllProducts(){
		
		Connection cn = OracleConnectionManager.getInstance().getConnection();
		PreparedStatement st = null;
		ResultSet rs = null;
		
		ArrayList products = new ArrayList();
		
		try{
			//select��
			String sql = "select product_id, product_name, product_price, image_path from product_table a, image_table b, displayproduct_table c where c.displayproduct_product_id = a.product_id and c.displayproduct_image_id = b.image_id and image_path like '%|_01%' escape '|'";
			
			//PreparedStatement�C���^�[�t�F�C�X����������N���X��
			//�C���X�^���X���擾����
			st = cn.prepareStatement(sql);
			
			//select���𑗐M��
			//ResultSet�C���^�[�t�F�C�X�����������N���X��
			//�C���X�^���X���Ԃ�
			rs = st.executeQuery();
			
			//�J�[�\������s���X�N���[�����A�f�[�^���t�F�b�`����
			while(rs.next()){
				ProductBean pb = new ProductBean();
				
				pb.setPid(rs.getString(1));
				pb.setName(rs.getString(2));
				pb.setPrice(rs.getString(3));
				pb.setPath(rs.getString(4));
				
				//�R���N�V�����ɒǉ�����
				products.add(pb);
			}
			
			//�R�~�b�g����
			cn.commit();
			
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
		return products;
	}
	
	public List getProducts(String pw){
		
		Connection cn = OracleConnectionManager.getInstance().getConnection();
		PreparedStatement st = null;
		ResultSet rs = null;
		
		ArrayList products = new ArrayList();
		
		ProductBean pb = new ProductBean();
		
		try{
			//select��
			String sql = "select product_id, product_name, product_price, image_path from product_table a, image_table b, displayproduct_table c where c.displayproduct_product_id = a.product_id and c.displayproduct_image_id = b.image_id and image_path like '%|_01%' escape '|' and product_name like '%"+ pw +"%'";
			
			//PreparedStatement�C���^�[�t�F�C�X����������N���X��
			//�C���X�^���X���擾����
			st = cn.prepareStatement(sql);
			
			//select���𑗐M��
			//ResultSet�C���^�[�t�F�C�X�����������N���X��
			//�C���X�^���X���Ԃ�
			rs = st.executeQuery();
			
			//�J�[�\������s���X�N���[�����A�f�[�^���t�F�b�`����
			while(rs.next()){
				
				pb.setPid(rs.getString(1));
				pb.setName(rs.getString(2));
				pb.setPrice(rs.getString(3));
				pb.setPath(rs.getString(4));
				
				//�R���N�V�����ɒǉ�����
				products.add(pb);
			}
			
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
		return products;
	}
	
	public List getProductsName(){
		
		Connection cn = OracleConnectionManager.getInstance().getConnection();
		PreparedStatement st = null;
		ResultSet rs = null;
		
		ArrayList products = new ArrayList();
		
		try{
			//select��
			String sql = "select product_id, product_name, product_price, image_path from product_table a, image_table b, displayproduct_table c where c.displayproduct_product_id = a.product_id and c.displayproduct_image_id = b.image_id and image_path like '%|_01%' escape '|' order by product_name";
			
			//PreparedStatement�C���^�[�t�F�C�X����������N���X��
			//�C���X�^���X���擾����
			st = cn.prepareStatement(sql);
			
			//select���𑗐M��
			//ResultSet�C���^�[�t�F�C�X�����������N���X��
			//�C���X�^���X���Ԃ�
			rs = st.executeQuery();
			
			//�J�[�\������s���X�N���[�����A�f�[�^���t�F�b�`����
			while(rs.next()){
				ProductBean pb = new ProductBean();
				
				pb.setPid(rs.getString(1));
				pb.setName(rs.getString(2));
				pb.setPrice(rs.getString(3));
				pb.setPath(rs.getString(4));
				
				//�R���N�V�����ɒǉ�����
				products.add(pb);
			}
			
			//�R�~�b�g����
			cn.commit();
			
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
		return products;
	}
	
	public List getProductsCheap(){
		
		Connection cn = OracleConnectionManager.getInstance().getConnection();
		PreparedStatement st = null;
		ResultSet rs = null;
		
		ArrayList products = new ArrayList();
		
		try{
			//select��
			String sql = "select product_id, product_name, product_price, image_path from product_table a, image_table b, displayproduct_table c where c.displayproduct_product_id = a.product_id and c.displayproduct_image_id = b.image_id and image_path like '%|_01%' escape '|' order by product_price";
			
			//PreparedStatement�C���^�[�t�F�C�X����������N���X��
			//�C���X�^���X���擾����
			st = cn.prepareStatement(sql);
			
			//select���𑗐M��
			//ResultSet�C���^�[�t�F�C�X�����������N���X��
			//�C���X�^���X���Ԃ�
			rs = st.executeQuery();
			
			//�J�[�\������s���X�N���[�����A�f�[�^���t�F�b�`����
			while(rs.next()){
				ProductBean pb = new ProductBean();
				
				pb.setPid(rs.getString(1));
				pb.setName(rs.getString(2));
				pb.setPrice(rs.getString(3));
				pb.setPath(rs.getString(4));
				
				//�R���N�V�����ɒǉ�����
				products.add(pb);
			}
			
			//�R�~�b�g����
			cn.commit();
			
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
		return products;
	}
	public List getProductsExpensive(){
		
		Connection cn = OracleConnectionManager.getInstance().getConnection();
		PreparedStatement st = null;
		ResultSet rs = null;
		
		ArrayList products = new ArrayList();
		
		try{
			//select��
			String sql = "select product_id, product_name, product_price, image_path from product_table a, image_table b, displayproduct_table c where c.displayproduct_product_id = a.product_id and c.displayproduct_image_id = b.image_id and image_path like '%|_01%' escape '|' order by product_price desc";
			
			//PreparedStatement�C���^�[�t�F�C�X����������N���X��
			//�C���X�^���X���擾����
			st = cn.prepareStatement(sql);
			
			//select���𑗐M��
			//ResultSet�C���^�[�t�F�C�X�����������N���X��
			//�C���X�^���X���Ԃ�
			rs = st.executeQuery();
			
			//�J�[�\������s���X�N���[�����A�f�[�^���t�F�b�`����
			while(rs.next()){
				ProductBean pb = new ProductBean();
				
				pb.setPid(rs.getString(1));
				pb.setName(rs.getString(2));
				pb.setPrice(rs.getString(3));
				pb.setPath(rs.getString(4));
				
				//�R���N�V�����ɒǉ�����
				products.add(pb);
			}
			
			//�R�~�b�g����
			cn.commit();
			
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
		return products;
	}
}