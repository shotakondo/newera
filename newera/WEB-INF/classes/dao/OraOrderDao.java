package dao;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import exp.ResourceAccessException;

import beans.OrderBean;
import beans.ProductBean;

public class OraOrderDao implements OrderDao{
	
	public void setOrder(String sq, String uid, String method, int total){
		
		Connection cn = OracleConnectionManager.getInstance().getConnection();
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try{
			//select��
			String sql = "insert into order_table (order_id, order_user_id, order_method, order_total) values (?, ?, ?, ?)";
			
			//PreparedStatement�C���^�[�t�F�C�X����������N���X��
			//�C���X�^���X���擾����
			st = cn.prepareStatement(sql);
			
			st.setString(1, sq);
			st.setString(2, uid);
			st.setString(3, method);
			st.setInt(4, total);
			
			//select���𑗐M��
			//ResultSet�C���^�[�t�F�C�X�����������N���X��
			//�C���X�^���X���Ԃ�
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
	
	public String getSequence(){
		
		Connection cn = OracleConnectionManager.getInstance().getConnection();
		PreparedStatement st = null;
		ResultSet rs = null;
		
		String sequence;
		
		try{
			//select��
			String sql = "select order_sequence.nextval from dual";
			
			//PreparedStatement�C���^�[�t�F�C�X����������N���X��
			//�C���X�^���X���擾����
			st = cn.prepareStatement(sql);
			
			//select���𑗐M��
			//ResultSet�C���^�[�t�F�C�X�����������N���X��
			//�C���X�^���X���Ԃ�
			rs = st.executeQuery();
			
			rs.next();
			
			sequence = rs.getString(1);
			
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
		return sequence;
	}
	
	public List getOrders(String uid){
		
		Connection cn = OracleConnectionManager.getInstance().getConnection();
		PreparedStatement st = null;
		ResultSet rs = null;
		
		ArrayList orders = new ArrayList();
		
		try{
			//insert��
			String sql = "select distinct order_date, order_id, product_id, product_name, product_price, image_path, detail_num, order_total, order_method from product_table a, image_table b, displayproduct_table c, order_table d, detail_table e, user_table f where c.displayproduct_product_id = a.product_id and c.displayproduct_image_id = b.image_id and d.order_id = e.detail_order_id and e.detail_product_id = a.product_id and image_path like '%|_01%' escape '|' and order_user_id = '"+ uid +"' order by order_id";
			
			//PreparedStatement�C���^�[�t�F�C�X����������N���X��
			//�C���X�^���X���擾����
			st = cn.prepareStatement(sql);
			
			//SQL�̎��s
			rs = st.executeQuery();
			
			if(rs.next()){
			
			while(rs.getBoolean("order_id")){
				ArrayList products = new ArrayList();
				String i = rs.getString(2);
				OrderBean ob = new OrderBean();
				
				ob.setDate(rs.getString(1));
				ob.setOid(rs.getString(2));
				ob.setTotal(rs.getString(8));
				ob.setMethod(rs.getString(9));
				
				while(rs.getString(2).equals(i)){
					ProductBean pb = new ProductBean();
					
					pb.setPid(rs.getString(3));
					pb.setName(rs.getString(4));
					pb.setPrice(rs.getInt(5));
					pb.setPath(rs.getString(6));
					pb.setNum(rs.getInt(7));
					
					products.add(pb);
					rs.next();
					
					if(rs.isAfterLast()){
						break;
					}
				}
				
				ob.setProducts(products);
				
				orders.add(ob);
				
				if(rs.isAfterLast()){
					break;
				}
				
			}
			
			for(int i = 0; i < orders.size(); i++){
				OrderBean ob = (OrderBean)orders.get(i);
				for(int j = 0; j < ob.getProducts().size(); j++){
					ProductBean pb = (ProductBean)ob.getProducts().get(j);
					System.out.println(ob.getOid()+":"+pb.getPid());
				}
			}
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
		return orders;
	}
}