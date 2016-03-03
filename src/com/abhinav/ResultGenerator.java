package com.abhinav;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
public class ResultGenerator {

	public ArrayList<String> resultlist;
	public int cnt;
	private String name;
	private String dept;
	private String roomno;
	
	ResultGenerator(){
		
		resultlist = new ArrayList<String>();
	}
	
	 public void setName(String name) {
	      this.name = name;
	   }
	 public String getName() {
	      return name;
	   }
	 
	 public void setDept(String dept){
	      this.dept = dept;
	   }
	 public String getDept() {
	      return dept;
	   }
	   
	 public void setRoomno(String room) {
		      this.roomno = room;
		   }
	 public String getRoomno() {
		      return roomno;
		   }

	public boolean listFull(){
		if(cnt==0)
		return true;
		else
		return false;
	}
	public void setList(String obj){
		
		resultlist.add(obj);
		cnt--;
		
	}
	
	public void setList(String obj,int n){
		
		resultlist.add(obj);
		cnt = n;
	}
	
	public ArrayList<String> getList(){
	
		return resultlist;
	}
	
	   public ArrayList<ResultGenerator> randomize(List <Faculty> faculty, List <Room> room){
		
		ArrayList<ResultGenerator> al = new ArrayList<ResultGenerator>();
		int count,n;
		Collections.shuffle(faculty);
		Stack<Faculty> st = expShuffle(faculty);							//randomizing to solve experience constraint
		count = faculty.size();
		
		for(int i=0;i<room.size();i++)										//selecting no. of faculty per room
		{
			ResultGenerator rslt = new ResultGenerator();
			if(room.get(i).getSize()<30)
			{
				n = 1;
			}
			else if(room.get(i).getSize()==30)
			{
				n = 2;
			}
			else
				n = 3;
			rslt.setList(room.get(i).getRoomno(),n);
			al.add(rslt);
		}
		
		while(count!=0)
		{
			for(int i=0;i<room.size();i++)
			{
				//if(!st.empty()){
					if(!al.get(i).listFull()&&!room.get(i).getDept().equals(st.peek().getDept())&&!st.empty()){
						al.get(i).setList(st.pop().getName());
						count--;
					}
				//}
				
			}
		}
	/*	while(!st.empty()){
			ResultGenerator rg = new ResultGenerator();
			rg.setList(st.pop().getName());
			al.add(rg);
		}*/
		return al;
		
	}
	     
	   
	   public Stack<Faculty> expShuffle(List<Faculty> faculty){
		   Stack<Faculty> st = new Stack<Faculty>();
		   for(int i = 0;i<faculty.size();i++)		//add inexperienced into to stack first
		   {
			   if(faculty.get(i).getExp().equals("NO"))
			   {
				   st.push(faculty.get(i));
			   }
		   }
		   for(int i = 0;i<faculty.size();i++)		//adding experienced to stack
		   {
			   if(faculty.get(i).getExp().equals("YES"))
			   {
				   st.push(faculty.get(i));
			   }
		   }
		   
		   return st;
	   }
	   
	   public List<ResultGenerator> updateTable(ArrayList<ResultGenerator> rs){
		   
		   
		   ApplicationContext context = 
					new ClassPathXmlApplicationContext("spring-dispatcher-servlet.xml");
					
					ResultJDBCTemplate resultJDBCTemplate = 
							(ResultJDBCTemplate)context.getBean("resultJDBCTemplate");
		   
			resultJDBCTemplate.clear();
					
			for(ResultGenerator record : rs){
			   
			   String temp;
			   int k = record.getList().size();
			   if(k>1||k==0){
			   String st = record.getList().get(0);
			   for(int i=1;i<k;i++){
				   temp = record.getList().get(i);
				   resultJDBCTemplate.create(temp,st);	   
			   }
			   }
			   else if(k==1){
				   resultJDBCTemplate.create(record.getList().get(0),"");
			   }
			   
		   }
			
			List<ResultGenerator> rst = resultJDBCTemplate.listResult();
		   
		   ((ConfigurableApplicationContext)context).close();
		   
		   return rst;
	   }
	   
	   
	   
}
	   