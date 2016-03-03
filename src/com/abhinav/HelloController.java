package com.abhinav;


import org.springframework.web.servlet.ModelAndView;





import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.abhinav.ResultGenerator;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;

@Controller
public class HelloController {
	
	@RequestMapping("/welcome")
	public ModelAndView helloWorld(){ 

		ModelAndView modelandview = new ModelAndView ("login");
		//login page do validation	
		return modelandview;
	}
	
		@RequestMapping("/faculty")
		public ModelAndView helloWorld1(){ 
			
			ModelAndView modelandview = new ModelAndView ("faculty");
		
			ApplicationContext context = 
					new ClassPathXmlApplicationContext("spring-dispatcher-servlet.xml");

					FacultyJDBCTemplate facultyJDBCTemplate = 
					(FacultyJDBCTemplate)context.getBean("facultyJDBCTemplate");
					
					List <Faculty> faculty = facultyJDBCTemplate.listFaculty();
					
					modelandview.addObject("facultylist",faculty);
				
					((ConfigurableApplicationContext)context).close();
			
			return modelandview;
		}
		
		@RequestMapping("/faculty_result")
		public ModelAndView helloWorld2(HttpServletRequest request){ 

			ModelAndView modelandview = new ModelAndView ("facultychecked");
		
			String checked[] = request.getParameterValues("checkbox");		//Has all the checked faculty ID's
		
			ApplicationContext context = 
					new ClassPathXmlApplicationContext("spring-dispatcher-servlet.xml");

					FacultyJDBCTemplate facultyJDBCTemplate = 
					(FacultyJDBCTemplate)context.getBean("facultyJDBCTemplate");
					
					facultyJDBCTemplate.clear();
					
					for(int i = 0;i<checked.length;i++){
						int id = Integer.parseInt(checked[i]);
						facultyJDBCTemplate.createTemp(id);
					}
					
					List <Faculty> faculty = facultyJDBCTemplate.listSelectedFaculty();	
					modelandview.addObject("facultylist",faculty);
					((ConfigurableApplicationContext)context).close();
			
			
			return modelandview;
		}
		
		
		
		@RequestMapping("/rooms")
		public ModelAndView helloWorld3(HttpServletRequest request){ 
			
			ModelAndView modelandview = new ModelAndView ("rooms");
			
			ApplicationContext context = 
			new ClassPathXmlApplicationContext("spring-dispatcher-servlet.xml");
			
			RoomJDBCTemplate roomJDBCTemplate = 
					(RoomJDBCTemplate)context.getBean("roomJDBCTemplate");

					List <Room> room = roomJDBCTemplate.listRoom();
	
				modelandview.addObject("roomlist",room);
				((ConfigurableApplicationContext)context).close();
				
			return modelandview;
		}
	
		
		@RequestMapping("/rooms_result")
		public ModelAndView helloWorld4(HttpServletRequest request){ 
			
			ModelAndView modelandview = new ModelAndView ("roomschecked");
			
			String checked[] = request.getParameterValues("checkbox");
			int size;
			ApplicationContext context = 
			new ClassPathXmlApplicationContext("spring-dispatcher-servlet.xml");
			
			RoomJDBCTemplate roomJDBCTemplate = 
					(RoomJDBCTemplate)context.getBean("roomJDBCTemplate");
			
			roomJDBCTemplate.clear();
			
			for(int i = 0;i<checked.length;i++){
				
				size = Integer.parseInt(request.getParameter(checked[i]));
				roomJDBCTemplate.createTemp(checked[i],size);
			}

					List <Room> room = roomJDBCTemplate.listSelectedRoom();
	
				modelandview.addObject("roomlist",room);
				((ConfigurableApplicationContext)context).close();
				
			return modelandview;
		}
		
		@RequestMapping("/result")
		public ModelAndView helloWorld5(){ 
			
			ResultGenerator result = new ResultGenerator();
			ModelAndView modelandview = new ModelAndView ("result");
			
					ApplicationContext context = 
					new ClassPathXmlApplicationContext("spring-dispatcher-servlet.xml");

					FacultyJDBCTemplate facultyJDBCTemplate = 
					(FacultyJDBCTemplate)context.getBean("facultyJDBCTemplate");

					List <Faculty> faculty = facultyJDBCTemplate.listSelectedFaculty();
					
					RoomJDBCTemplate roomJDBCTemplate = 
							(RoomJDBCTemplate)context.getBean("roomJDBCTemplate");

					List <Room> room = roomJDBCTemplate.listSelectedRoom();
								
					ArrayList<ResultGenerator> rst = result.randomize(faculty,room);	
					
					List<ResultGenerator> rt = result.updateTable(rst);
		
			modelandview.addObject("msg",rt);
			((ConfigurableApplicationContext)context).close();
			
			return modelandview;
		}
		
		@RequestMapping("/downloadPDF")
		public ModelAndView helloWorld6(){ 
			
			 ApplicationContext context = 
						new ClassPathXmlApplicationContext("spring-dispatcher-servlet.xml");
						
			 ResultJDBCTemplate resultJDBCTemplate = 
								(ResultJDBCTemplate)context.getBean("resultJDBCTemplate");
						
			 List<ResultGenerator> rst = resultJDBCTemplate.listResult();
						   
			 ((ConfigurableApplicationContext)context).close();
			
			return new ModelAndView("pdfView", "resultset", rst);
		}
		
	
}

		

