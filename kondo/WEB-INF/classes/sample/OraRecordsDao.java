package dao;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.Record;
import exp.ResourceAccessException;

public class OraRecordsDao implements RecordsDao{
	
	public void addRecord(Record p){
		
		PreparedStatement st = null;
		
		try{
			//insert��
			String sql = "";
			
			//PreparedStatement�C���^�[�t�F�C�X����������N���X��
			//�C���X�^���X���擾����
			st = cn.prepareStatement(sql);
			
			//�p�����[�^���Z�b�g����
			
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
	
	public Record getRecord(String pid){
		return null;
	}
	
	public List getAllRecords(){
		
		PreparedStatement st = null;
		ResultSet rs = null;
		
		ArrayList records = new ArrayList();
		
		try{
			//select��
			String sql = "";
			
			//PreparedStatement�C���^�[�t�F�C�X����������N���X��
			//�C���X�^���X���擾����
			st = cn.prepareStatement(sql);
			
			//select���𑗐M��
			//ResultSet�C���^�[�t�F�C�X�����������N���X��
			//�C���X�^���X���Ԃ�
			rs = st.executeQuery();
			
			//�J�[�\������s���X�N���[�����A�f�[�^���t�F�b�`����
			while(rs.next()){
				Record r = new Record();
				
				r.setPid(rs.getString(1));
				r.setName(rs.getString(2));
				r.setPrice(rs.getString(3));
				r.setUname(rs.getString(4))
				
				//�R���N�V�����ɒǉ�����
				records.add(p);
			}
			
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
		
		return records;
	}
}