package com.abhinav;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class FacultyMapper  implements RowMapper<Faculty> {
	   public Faculty mapRow(ResultSet rs, int rowNum) throws SQLException {
		      Faculty faculty = new Faculty();
		      faculty.setId(rs.getInt("id"));
		      faculty.setName(rs.getString("name"));
		      faculty.setDept(rs.getString("dept"));
		      faculty.setExp(rs.getString("experienced"));
		      return faculty;
		   }
		}
