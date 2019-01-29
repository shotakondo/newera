package dao;

import java.util.List;

import beans.RecordBean;

public interface RecordDao{
	
	public void addRecord(RecordBean rb);
	public RecordBean getRecord(String pid, String uid);
	public List getAllRecords();
	
}