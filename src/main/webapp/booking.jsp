<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="BookingServlet" method="post">
		Attraction Name: <input type="text" name="attractionname">
		user: <input type="text" name="userid">
		Date: <input type="text" name="date"> 
		Number of Tickets: <input type="text" name="numberoftickets">
		Total Cost: <input type="text" name="totalcost"> 
		<input type="submit" value="Call Servlet" />
	</form>
</body>
</html>