package com.abhinav;

public class Faculty {

	   private int id;
	   private String name;
	   private String dept;
	   private String exp;

	   public void setDept(String dept) {
	      this.dept = dept;
	   }
	   public String getDept() {
	      return dept;
	   }
	   
	   public void setExp(String exp) {
		      this.exp = exp;
		   }
		   public String getExp() {
		      return exp;
		   }

	   public void setId(Integer id) {
	      this.id = id;
	   }
	   public Integer getId() {
	      return id;
	   }
	   
	   public void setName(String name) {
		      this.name = name;
		   }
		   public String getName() {
		      return name;
		   }
	}
