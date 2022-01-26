<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<title>User Management Application</title>
 <link rel="stylesheet"
href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
crossorigin="anonymous">
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<nav class="navbar navbar-expand-md navbar-light">
<div>
<a class="navbar-brand"> Attraction Management Application </a>
</div>
<ul class="navbar-nav">
<li><a href="<%=request.getContextPath()%>/AttractionServlet/dashboard"
class="nav-link">Back to Dashboard</a></li>
</ul>
</nav>

<div class="container col-md-6">
<div class="card">
<div class="card-body">
<c:if test="${attraction != null}">
<form action="update" method="post">
</c:if>
<c:if test="${attraction == null}">
<form action="insert" method="post">
</c:if>

<caption>
<h2>
<c:if test="${attraction != null}">
Edit Attraction
</c:if>
<c:if test="${attraction == null}">
Add New Attraction
</c:if>
</h2>
</caption>

<c:if test="${attraction != null}">
<input type="hidden" name="oriAttraction_Id" value="<c:out
value='${attraction.attraction_Id}' />" />
</c:if>

<fieldset class="form-group">
<label>Attraction ID</label> <input type="text" value="<c:out
value='${attraction.attraction_Id}' />" class="form-control" name="attraction_Id" required="required">
</fieldset>

<fieldset class="form-group">
<label>Attraction Name</label> <input type="text" value="<c:out
value='${attraction.attractionName}' />" class="form-control" name="attractionName">
</fieldset>

<fieldset class="form-group">
<label>description</label> <input type="text" value="<c:out
value='${attraction.description}' />" class="form-control" name="description">
</fieldset>

<fieldset class="form-group">
<label> image</label> <input type="text" value="<c:out
value='${attraction.image}' />" class="form-control" name="image">
</fieldset>

<fieldset class="form-group">
<label> price</label> <input type="number" value="<c:out
value='${attraction.price}' />" class="form-control" name="price">
</fieldset>

<fieldset class="form-group">
<label> Opening Hours</label> <input type="text" value="<c:out
value='${attraction.openingHours}' />" class="form-control" name="openingHours">
</fieldset>

<fieldset class="form-group">
<label> address</label> <input type="text" value="<c:out
value='${attraction.address}' />" class="form-control" name="address">
</fieldset>

<button type="submit" class="btn btn-success">Confirm Changes</button>
</form>
</div>
</div>
</div>

</body>
</html>