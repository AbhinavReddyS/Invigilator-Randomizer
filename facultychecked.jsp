<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="css/style.css" type="text/css" media="screen" charset="utf-8" />
<title>Invigilator Randomizer</title>
<style type="text/css">
    <%@include file="css/style.css" %>
    </style>
</head>
<%@ page import="com.abhinav.*"%>
<%@ page import="java.util.List"%>
<body>
			<form action="/InvigilatorRandomizer/rooms" action="post">
					<div id="table" class="help">
							<h1>Faculty </h1>
							<div class="col w10 last">
								<div class="content">
									<br>
									<table>
										<tr>
											<th>ID no.</th>
											<th>First Name</th>
											<th>Last Name</th>
											<th>Department</th>
											<th>Experience</th>
										</tr>				
										<% 
										List<Faculty> faculty = (List<Faculty>)request.getAttribute("facultylist");
										for (Faculty record : faculty) {
										%>
										 <tr id="id_1">
											<td><%=record.getId()%></td>
											<td><%=record.getName()%></td>
											<td>lastname</td>
											<td><%=record.getDept()%></td>
											<td><%=record.getExp()%></td>
										</tr>
										<% 	} %>									
									</table>
								</div>							
							</div>
				   	</div>
							<p class="last" align="right">
								<input type="submit" name="submit" />
								
								<br />
							</p>
							<br>
						</form>
							<div id="footer">
			<p class="last">Copyright 2015 - CHAITANYA BHARATHI INSTITUTE OF TECHNOLOGY</p>
		</div>

</body>
</html>