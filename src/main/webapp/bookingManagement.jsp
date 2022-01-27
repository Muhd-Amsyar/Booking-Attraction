<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<link rel="stylesheet" 
href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" 
integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" 
crossorigin="anonymous">
</head>
<body>
<div class="row">
		<div class="container">
			<h3 class="text-center">List of Bookings</h3>
			<hr>
			<div class="container text-left">
				<!-- Add new user button redirects to the register.jsp page -->
				<a href="<%=request.getContextPath()%>/booking.jsp"
					class="btn btn-success">Add New User</a>
			</div>
			<br>
			<!-- Create a table to list out all current users information -->
			<table class="table">
				<thead>
					<tr>
						<th>Booking Id</th>
						<th>Attraction Id</th>
						<th>Attraction Name</th>
						<th>User Id</th>
						<th>Date</th>
						<th>Number of Tickets</th>
						<th>Total Price</th>
					</tr>
				</thead>
				<!-- Pass in the list of users receive via the Servlet's response to a loop -->

				<tbody>
					<c:forEach var="booking" items="${listBookings}">
						<!-- For each user in the database, display their information accordingly -->
						<tr>
							<td><c:out value="${booking.bookingid}" /></td>
							<td><c:out value="${booking.attractionid}" /></td>
							<td><c:out value="${booking.attractionname}" /></td>
							<td><c:out value="${booking.userid}" /></td>
							<td><c:out value="${booking.date}" /></td>
							<td><c:out value="${booking.numberoftickets}" /></td>
							<td><c:out value="${booking.totalprice}" /></td>
							<!-- For each user in the database, Edit/Delete buttons which invokes the edit/delete functions -->
							<td><a href="edit?name=<c:out value='${booking.bookingid}' />">Edit</a>
								&nbsp;&nbsp;&nbsp;&nbsp; 
								<a href="delete?name=<c:out value='${booking.bookingid}' />">Delete</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>