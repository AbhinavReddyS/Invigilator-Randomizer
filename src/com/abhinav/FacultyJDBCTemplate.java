package com.abhinav;



import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

public class FacultyJDBCTemplate implements FacultyDAO {
	
	
	   private DataSource dataSource1;
	   private JdbcTemplate jdbcTemplateObject;
	   
	   public void setDataSource(DataSource dataSource) {
	      this.dataSource1 = dataSource;
	      this.jdbcTemplateObject = new JdbcTemplate(dataSource1);
	   }
	   
	   public void create(String name,String dept) {
		      String SQL = "insert into Faculty (name, dept) values (?, ?)";
		      
		      jdbcTemplateObject.update( SQL, name, dept);
		      
		   }
	   
	   
	   public List<Faculty> listFaculty() {
		      String SQL = "select * from Faculty";
		      List <Faculty> faculty = jdbcTemplateObject.query(SQL, 
		                                new FacultyMapper());
		      return faculty;
		   }
	   
	   public void createTemp(int id) {
		  
		      String SQL = "INSERT INTO faculty_selected SELECT f.* FROM faculty f WHERE id=?;";
		      jdbcTemplateObject.update( SQL, id);
		      
		   }
	   
	   public List<Faculty> listSelectedFaculty() {
		      String SQL = "select * from faculty_selected";
		      List <Faculty> faculty = jdbcTemplateObject.query(SQL, 
		                                new FacultyMapper());
		      return faculty;
		   }
	   public void clear(){
		   String SQL = "delete from faculty_selected;";
		   jdbcTemplateObject.update(SQL);
	   }


}
