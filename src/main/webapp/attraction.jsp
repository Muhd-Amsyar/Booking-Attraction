<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
 <link rel="stylesheet"
href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
crossorigin="anonymous">
<meta charset="ISO-8859-1">
<title>Create Attraction</title>
</head>
<body class="container">
<div class="container col-md-6">
<div class="card">
<div class="card-body">
<form action="AttractionCreationServlet" method="post">
<h2><b>Add new attraction</b></h2>

<fieldset class="form-group">
<label>Attraction Name</label> <input type="text" class="form-control" name="attraction_Id">
</fieldset>

<fieldset class="form-group">
<label>Attraction Name</label> <input type="text" class="form-control" name="attractionName">
</fieldset>

<fieldset class="form-group">
<label>Description</label> <input type="text" class="form-control" name="description">
</fieldset>

<fieldset class="form-group">
<label>Image link</label> <input type="text" class="form-control" name="image">
</fieldset>

<fieldset class="form-group">
<label>Price</label> <input type="number" class="form-control" name="price">
</fieldset>

<fieldset class="form-group">
<label>Opening Hours</label> <input type="text" class="form-control" name="openingHours">
</fieldset>

<fieldset class="form-group">
<label>Address</label> <input type="text" class="form-control" name="address">
</fieldset>


<input type="submit" value="Add Attraction" class="btn btn-primary">

</form>
</body>
</html>