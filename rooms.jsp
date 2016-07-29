<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Invigilator Randomizer</title>
<link rel="stylesheet" href="css/style.css" type="text/css" media="screen" charset="utf-8" />
<style type="text/css">
    <%@include file="css/style.css" %>
    </style>
</head>
<%@ page import="com.abhinav.*"%>
<%@ page import="java.util.List"%>
<body>

			<form action="/InvigilatorRandomizer/rooms_result" action="post">
			<div id="table" class="help">
							<h1>Rooms </h1>
							<div class="col w10 last">
								<div class="content">
									<br>
									<table>
										<tr>
											<th class="checkbox"></th>
											<th>Room no.</th>
											<th>Block</th>
											<th>Capacity</th>
											<th>Size</th>
										</tr>
										<%  List<Room> room1 = (List<Room>)request.getAttribute("roomlist");
											int id = 1;
											for (Room record : room1) {%>
										<tr id="id_1">
											<td class="checkbox"><input type="checkbox" name="checkbox" value=<%=record.getRoomno()%> /></td>
											<td><%=record.getRoomno()%></td>
											<td><%=record.getDept() %></td>
											<td><%=record.getSize() %></td>
											<td><input type="text" name=<%=record.getRoomno()%> size="3" class="text" /></td>
										</tr>
										
										<%id++;		
										}%>
										
									</table>
								</div>							
							</div>
							</div>
							<p class="last" align="right">
								<input type="submit" name="submit"  />
							</p>
							<br>
							<p class="last">
								<input type="reset"  class="novisible" />
								<a href="" class="button form_submit"><span>Reset</span></a>
								<br />
							</p>
			</form>
							<div id="footer">
			<p class="last">Copyright 2015 - CHAITANYA BHARATHI INSTITUTE OF TECHNOLOGY</p>
		</div>

 
</body>
</html>