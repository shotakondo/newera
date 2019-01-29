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
			//insert��
			String sql = "select product_id, product_name, product_price, image_path from product_table a, image_table b, displayproduct_table c, user_table d, favorite_table e where c.displayproduct_product_id = a.product_id and c.displayproduct_image_id = b.image_id and e.favorite_user_id = d.user_id and e.favorite_product_id = a.product_id and image_path like '%|_01%' escape '|' and favorite_user_id = '"+ uid +"'";
			
			//PreparedStatement�C���^�[�t�F�C�X����������N���X��
			//�C���X�^���X���擾����
			st = cn.prepareStatement(sql);
			
			//SQL�̎��s
			rs = st.executeQuery();
			
			while(rs.next()){
				
				pb.setPid(rs.getString(1));
				pb.setName(rs.getString(2));
				pb.setPrice(rs.getString(3));
				pb.setPath(rs.getString(4));
				
				favorites.add(pb);
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
		return favorites;
	}
	
	public void setFavorite(String uid, String pid){
		
		Connection cn = OracleConnectionManager.getInstance().getConnection();
		PreparedStatement st = null;
		
		try{
			//insert��
			String sql = "insert into favorite_table(favorite_user_id, favorite_product_id) values ('?','?')";
			
			//PreparedStatement�C���^�[�t�F�C�X����������N���X��
			//�C���X�^���X���擾����
			st = cn.prepareStatement(sql);
			
			//�p�����[�^���Z�b�g����
			st.setString(1, uid);
			st.setString(2, pid);
			
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
}