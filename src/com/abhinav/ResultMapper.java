package com.abhinav;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class ResultMapper  implements RowMapper<ResultGenerator> {
	   public ResultGenerator mapRow(ResultSet rs, int rowNum) throws SQLException {
		      ResultGenerator result = new ResultGenerator();
		      result.setName(rs.getString("name"));
		      result.setDept(rs.getString("dept"));
		      result.setRoomno(rs.getString("roomno"));
		      return result;
		   }
		}
