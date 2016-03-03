package com.abhinav;

import java.util.List;

import javax.sql.DataSource;

public interface RoomDAO {
	
	public void setDataSource(DataSource ds);
	
	public void create(String name, String dept);
	
	public List<Room> listRoom();
	
	public void createTemp(String roomno,int size);
	
	public List<Room> listSelectedRoom();
	
	public void clear();
	 

}
