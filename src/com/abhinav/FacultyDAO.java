package com.abhinav;

import java.util.List;

import javax.sql.DataSource;

public interface FacultyDAO {
	
	public void setDataSource(DataSource ds);
	
	public void create(String name, String dept);
	
	public List<Faculty> listFaculty();
	
	public void createTemp(int id);
	 
    public List<Faculty> listSelectedFaculty();
	 
    public void clear();

}
