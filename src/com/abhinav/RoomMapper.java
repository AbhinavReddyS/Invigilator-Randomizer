package com.abhinav;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class RoomMapper  implements RowMapper<Room> {
	   public Room mapRow(ResultSet rs, int rowNum) throws SQLException {
		      Room room = new Room();
		      room.setSize(rs.getInt("size"));
		      room.setRoomno(rs.getString("roomno"));
		      room.setDept(rs.getString("dept"));
		      return room;
		   }
		}
