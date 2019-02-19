package dao;

import java.util.List;

import beans.Record;

public interface RecordsDao{
	
	public void addRecord(Record p);
	public Record getRecord(String pid);
	public List getAllRecords();
	
}