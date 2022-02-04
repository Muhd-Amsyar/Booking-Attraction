<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<link rel="stylesheet"
href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
crossorigin="anonymous">

<meta charset="ISO-8859-1">
<title>attraction management</title>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <a class="navbar-brand" href="#">BookTix</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
    <div class="navbar-nav">
      <a class="nav-item nav-link active" href="http://localhost:8090/BookingAttraction/AttractionServlet/dashboard">Attractions <span class="sr-only">(current)</span></a>
      <a class="nav-item nav-link" href="http://localhost:8090/BookingAttraction/GetBookingServlet/dashboard">Book Attractions</a>
      <a class="nav-item nav-link" href="http://localhost:8090/BookingAttraction/UserServlet/dashboard">Profile</a>
    </div>
  </div>
</nav>
<div class="row">
<div class="container">
<h3 class="text-center">List of Attractions</h3>
<hr>
<div class="container text-left">
<!-- Add new user button redirects to the register.jsp page -->
<a href="<%=request.getContextPath()%>/attraction.jsp" class="btn btn-success">Add New Attraction</a>
</div>
<br>
<!-- Create a table to list out all current users information -->
<table class="table">
<thead>
<tr>
<th>ID</th>
<th>Attraction Name</th>
<th>description</th>
<th>image</th>
<th>price</th>
<th>opening hours</th>
<th>address</th>
<th></th>
</tr>
</thead>

<tbody>
<c:forEach var="attraction" items="${listAttractions}">
<!-- For each attraction in the database, display their
information accordingly -->
<tr>
<td>
<c:out value="${attraction.attraction_Id}" />
</td>
<td>
<c:out value="${attraction.attractionName}" />
</td>
<td>
<c:out value="${attraction.description}" />
</td>
<td>
<img width="300" height="200" src="${attraction.image}">
</td>
<td>
<c:out value="${attraction.price}" />
</td>
<td>
<c:out value="${attraction.openingHours}" />
</td>
<td>
<c:out value="${attraction.address}" />
</td>
<!-- For each attraction in the database, Edit/Delete
buttons which invokes the edit/delete functions -->
<td>
<a href="edit?attraction_Id=<c:out value='${attraction.attraction_Id}'
/>">Edit</a> &nbsp;&nbsp;&nbsp;&nbsp;
<a href="delete?attraction_Id=<c:out
value='${attraction.attraction_Id}' />">Delete</a>
</td>
</tr>
</c:forEach>
</tbody>
</table>
</div>
</div>
</body>
</html>