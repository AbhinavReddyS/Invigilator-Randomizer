package com.abhinav;

public class Room {

	   private int size;
	   private String roomno;
	   private String dept;


	   public void setDept(String dept) {
	      this.dept = dept;
	   }
	   public String getDept() {
	      return dept;
	   }

	   public void setSize(Integer size) {
	      this.size = size;
	   }
	   public Integer getSize() {
	      return size;
	   }
	   
	   public void setRoomno(String roomno) {
		      this.roomno = roomno;
		   }
	   public String getRoomno() {
		      return roomno;
		   }
	}
