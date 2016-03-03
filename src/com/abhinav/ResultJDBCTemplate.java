package com.abhinav;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

public class ResultJDBCTemplate {
	
	 private DataSource dataSource1;
	   private JdbcTemplate jdbcTemplateObject;
	   
	   public void setDataSource(DataSource dataSource) {
	      this.dataSource1 = dataSource;
	      this.jdbcTemplateObject = new JdbcTemplate(dataSource1);
	   }
	   
	   public void create(String name,String roomno) {
		   
		      String SQL = "insert into Result (name, roomno) values (?, ?)";  
		      jdbcTemplateObject.update( SQL, name, roomno);
		      
		   }
	   
	   public void clear(){
		   String SQL = "delete from result;";
		   jdbcTemplateObject.update(SQL);
	   }
	   
	   public List<ResultGenerator> listResult() {
		      String SQL = "select faculty.name, faculty.dept, result.roomno from result natural join faculty;";
		      List <ResultGenerator> result = jdbcTemplateObject.query(SQL, 
		                                new ResultMapper());
		      return result;
		   }

}
