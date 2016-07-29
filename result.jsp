<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Invigilator Randomizer</title>
<style type="text/css">
    <%@include file="css/style.css" %>
    </style>
</head>

<%@ page import="com.abhinav.*"%>
<%@ page import="java.util.ArrayList"%>
<body>
<div id="table" class="help">
							<div class="col w10 last">
								<div class="content">
									<br>
									<table>
										<tr>
											<th>S.No.</th>
											<th>Name</th>
											<th>Department</th>
											<th>Room</th>
										</tr>
										<%  ArrayList<ResultGenerator> rs = (ArrayList<ResultGenerator>)request.getAttribute("msg");
										int id=0;
										for (ResultGenerator record : rs) {%>
										<tr id="id_1">
											<td><%=++id%> </td>
											<td><%=record.getName()%></td	>
											<td><%=record.getDept() %></td>
											<td><%=record.getRoomno() %></td>
											
										</tr>
										
										<%}	
										%>
										
									</table>
								</div>							
							</div>
							</div>
<h3><a href="/InvigilatorRandomizer/downloadPDF">Download PDF Document</a></h3>

<div id="footer">
			<p class="last">Copyright 2015 - CHAITANYA BHARATHI INSTITUTE OF TECHNOLOGY</p>
		</div>
</body>
</html>