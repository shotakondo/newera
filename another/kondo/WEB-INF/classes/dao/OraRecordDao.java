package dao;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.RecordBean;
import exp.ResourceAccessException;

public class OraRecordDao implements RecordDao{
	
	public void addRecord(RecordBean rb){
		
		Connection cn = OracleConnectionManager.getInstance().getConnection();
		PreparedStatement st = null;
		
		try{
			//insert��
			String sql = "insert into t_products_record(pid,userid) values (?,?)";
			
			//PreparedStatement�C���^�[�t�F�C�X����������N���X��
			//�C���X�^���X���擾����
			st = cn.prepareStatement(sql);
			
			//�p�����[�^���Z�b�g����
			st.setString(1, rb.getPid());
			st.setString(2, rb.getUid());
			
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
	
	public RecordBean getRecord(String pid, String uid){
		return null;
	}
	
	public List getAllRecords(){
		
		Connection cn = OracleConnectionManager.getInstance().getConnection();
		PreparedStatement st = null;
		ResultSet rs = null;
		
		ArrayList records = new ArrayList();
		
		try{
			//select��
			String sql = "SELECT p.pid, p.name, p.price, u.name, tp.insert_date FROM t_products p, t_products_record tp, t_user u WHERE p.pid = tp.pid AND u.userid = tp.userid";
			
			//PreparedStatement�C���^�[�t�F�C�X����������N���X��
			//�C���X�^���X���擾����
			st = cn.prepareStatement(sql);
			
			//select���𑗐M��
			//ResultSet�C���^�[�t�F�C�X�����������N���X��
			//�C���X�^���X���Ԃ�
			rs = st.executeQuery();
			
			//�J�[�\������s���X�N���[�����A�f�[�^���t�F�b�`����
			while(rs.next()){
				RecordBean rb = new RecordBean();
				
				rb.setPid(rs.getString(1));
				rb.setName(rs.getString(2));
				rb.setPrice(rs.getString(3));
				rb.setUname(rs.getString(4));
				rb.setDate(rs.getString(5));
				
				//�R���N�V�����ɒǉ�����
				records.add(rb);
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
		return records;
	}
}