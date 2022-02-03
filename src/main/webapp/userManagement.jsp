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
<title>User Dashboard</title>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <a class="navbar-brand" href="#">Navbar</a>
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
<h3 class="text-center">List of Users</h3>
<hr>
<div class="container text-left">
<!-- Add new user button redirects to the register.jsp page -->
<a href="<%=request.getContextPath()%>/register.jsp" class="btn btn-primary">Add New User</a>
</div>
<br>
<!-- Create a table to list out all current users information -->
<table class="table">
<thead>
<tr>
<th>ID</th>
<th>Email</th>
<th>Password</th>
<th>Name</th>
<th>Actions</th>
</tr>
</thead>
<tbody>
<c:forEach var="user" items="${listUsers}">
<!-- For each user in the database, display their
information accordingly -->
<tr>
<td>
<c:out value="${user.id}" />
</td>
<td>
<c:out value="${user.email}" />
</td>
<td>
<c:out value="${user.password}" />
</td>
<td>
<c:out value="${user.name}" />
</td>
<!-- For each user in the database, Edit/Delete
buttons which invokes the edit/delete functions -->
<td>
<a href="edit?id=<c:out value='${user.id}'
/>">Edit</a> &nbsp;&nbsp;&nbsp;&nbsp;
<a href="delete?id=<c:out
value='${user.id}' />">Delete</a>
</td>
</tr>
</c:forEach>
</tbody>
</table>
</div>
</div>
</body>
</html>