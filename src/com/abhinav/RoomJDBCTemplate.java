package com.abhinav;



import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

public class RoomJDBCTemplate implements RoomDAO {
	
	
	   private DataSource dataSource2;
	   private JdbcTemplate jdbcTemplateObject;
	   
	   public void setDataSource(DataSource dataSource) {
	      this.dataSource2 = dataSource;
	      this.jdbcTemplateObject = new JdbcTemplate(dataSource2);
	   }
	   
	   public void create(String roomno,String dept) {
		      String SQL = "insert into Room (roomno, dept) values (?, ?)";
		      
		      jdbcTemplateObject.update( SQL, roomno, dept);
		      
		   }

	   public List<Room> listRoom() {
		      String SQL = "select * from Room";
		      List <Room> room = jdbcTemplateObject.query(SQL, 
		                                new RoomMapper());
		      return room;
		   }

	   public void createTemp(String roomno,int size) {
			  
		      String SQL = "INSERT INTO room_selected SELECT f.* FROM room f WHERE roomno=?;";
		      jdbcTemplateObject.update( SQL, roomno);
		      String SQL1 = "update room_selected set size=? where roomno=?";
		      jdbcTemplateObject.update(SQL1,size,roomno);
		      
		   }
	   
	   public List<Room> listSelectedRoom() {
		      String SQL = "select * from room_selected; ";
		      List <Room> rooms = jdbcTemplateObject.query(SQL, 
		                                new RoomMapper());
		      return rooms;
		   }
	   public void clear(){
		   String SQL = "delete from room_selected;";
		   jdbcTemplateObject.update(SQL);
	   }

	   

}
