<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<title>Booking Management Application</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">

</head>
<body>
	<nav class="navbar navbar-expand-md navbar-light">
		<div>
			<a class="navbar-brand"> Booking Management Application </a>
		</div>
		<ul class="navbar-nav">
			<li><a
				href="<%=request.getContextPath()%>/GetBookingServlet/dashboard"
				class="nav-link">Back to Dashboard</a></li>
		</ul>
	</nav>
	<div class="container col-md-6">
		<div class="card">
			<div class="card-body">
				<c:if test="${booking != null}">
					<form action="update" method="post">
				</c:if>
				<c:if test="${booking == null}">
					<form action="insert" method="post">
				</c:if>
				<caption>
					<h2>
						<c:if test="${booking != null}">
Edit booking
</c:if>
						<c:if test="${booking == null}">
Add New booking
</c:if>
					</h2>
				</caption>
				<c:if test="${booking != null}">
					<input type="hidden" name="oribookingid"
						value="<c:out 
value='${booking.bookingid}' />" />
				</c:if>
				<fieldset class="form-group">
					<label>booking id</label> <input type="text"
						value="<c:out 
value='${booking.bookingid}' />" class="form-control"
						name="bookingid" required="required">
				</fieldset>
				
				<fieldset class="form-group">
					<label>Attraction Id</label> <input type="text"
						value="<c:out 
value='${booking.attractionid}' />" class="form-control"
						name="attractionid">
				</fieldset>
				
				<fieldset class="form-group">
					<label>Attraction Name</label> <input type="text"
						value="<c:out 
value='${booking.attractionname}' />" class="form-control"
						name="attractionname">
				</fieldset>
				
				<fieldset class="form-group">
					<label> User Id</label> <input type="text"
						value="<c:out 
value='${booking.userid}' />" class="form-control"
						name="userid">
				</fieldset>
				
				<fieldset class="form-group">
					<label> Date</label> <input type="text"
						value="<c:out 
value='${booking.date}' />" class="form-control"
						name="date">
				</fieldset>
				
				<fieldset class="form-group">
					<label> Number of Tickets</label> <input type="text"
						value="<c:out 
value='${booking.numberoftickets}' />" class="form-control"
						name="numberoftickets">
				</fieldset>
				
				<fieldset class="form-group">
					<label> Total Price</label> <input type="text"
						value="<c:out 
value='${booking.totalprice}' />" class="form-control"
						name="totalprice">
				</fieldset>
				
				<button type="submit" class="btn btn-success">Save</button>
				</form>
			</div>
		</div>
	</div>


</body>
</html>