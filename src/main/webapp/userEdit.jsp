<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<title>User Management Application</title>

<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css" integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn" crossorigin="anonymous">
<style>
body{margin-top:20px;
background-color:#f2f6fc;
color:#69707a;
}
.img-account-profile {
    height: 10rem;
}
.rounded-circle {
    border-radius: 50% !important;
}
.card {
    box-shadow: 0 0.15rem 1.75rem 0 rgb(33 40 50 / 15%);
}
.card .card-header {
    font-weight: 500;
}
.card-header:first-child {
    border-radius: 0.35rem 0.35rem 0 0;
}
.card-header {
    padding: 1rem 1.35rem;
    margin-bottom: 0;
    background-color: rgba(33, 40, 50, 0.03);
    border-bottom: 1px solid rgba(33, 40, 50, 0.125);
}
.form-control, .dataTable-input {
    display: block;
    width: 100%;
    padding: 0.875rem 1.125rem;
    font-size: 0.875rem;
    font-weight: 400;
    line-height: 1;
    color: #69707a;
    background-color: #fff;
    background-clip: padding-box;
    border: 1px solid #c5ccd6;
    -webkit-appearance: none;
    -moz-appearance: none;
    appearance: none;
    border-radius: 0.35rem;
    transition: border-color 0.15s ease-in-out, box-shadow 0.15s ease-in-out;
}

.nav-borders .nav-link.active {
    color: #0061f2;
    border-bottom-color: #0061f2;
}
.nav-borders .nav-link {
    color: #69707a;
    border-bottom-width: 0.125rem;
    border-bottom-style: solid;
    border-bottom-color: transparent;
    padding-top: 0.5rem;
    padding-bottom: 0.5rem;
    padding-left: 0;
    padding-right: 0;
    margin-left: 1rem;
    margin-right: 1rem;
}
</style>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div class="container-xl px-4 mt-4">
<nav class="navbar navbar-expand-md navbar-light">
<div>
<a class="navbar-brand"> User Management Application </a>
</div>
<ul class="navbar-nav">
<li><a href="<%=request.getContextPath()%>/UserServlet/dashboard"
class="nav-link">Back to Dashboard</a></li>
</ul>
</nav>
    <div class="row">
        <div class="col-xl-4">
            <!-- Profile picture card-->
            <div class="card mb-4 mb-xl-0">
                <div class="card-header">Profile Picture</div>
                <div class="card-body text-center">
                    <!-- Profile picture image-->
                    <img class="img-account-profile rounded-circle mb-2" src="http://bootdey.com/img/Content/avatar/avatar1.png" alt="">
                    <!-- Profile picture help block-->
                    <div class="small font-italic text-muted mb-4">JPG or PNG no larger than 5 MB</div>
                    <!-- Profile picture upload button-->
                    <button class="btn btn-primary" type="button">Upload new image</button>
                </div>
            </div>
        </div>
        
        
 <div class="col-xl-8">
            <!-- Account details card-->
            <div class="card mb-4">
                <div class="card-body">
<c:if test="${user != null}">
<form action="update" method="post">
</c:if>
<c:if test="${user == null}">
<form action="insert" method="post">
</c:if>
<caption>
<h2>
<c:if test="${user != null}">
Edit User
</c:if>
<c:if test="${user == null}">
Add New User
</c:if>
</h2>
</caption>
<c:if test="${user != null}">
<input type="hidden" name="oriId" value="<c:out
value='${user.id}' />" />
</c:if>

<fieldset class="form-group">
<label>User ID</label> <input type="text" value="<c:out
value='${user.id}' />" class="form-control" name="id" required="required"  readonly>
</fieldset>

<label>Email</label> <input type="email" value="<c:out
value='${user.email}' />" class="form-control" name="email">
</fieldset>
<fieldset class="form-group">
<label>Password</label> <input type="password" value="<c:out
value='${user.password}' />" class="form-control" name="password">
</fieldset>

<fieldset class="form-group">
<label> Name</label> <input type="text" value="<c:out
value='${user.name}' />" class="form-control" name="name">
</fieldset>

<button type="submit" class="btn btn-primary">Save Changes</button>
</form>
</div>
</div>
</div>
</div>
</div>
</body>
</html>