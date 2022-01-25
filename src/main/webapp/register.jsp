<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css" integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn" crossorigin="anonymous">
<meta charset="ISO-8859-1">
<title>Register</title>
<style>
body{
    margin-top:20px;
    background-color: #f2f3f8;
}
.card {
    margin-bottom: 1.5rem;
    box-shadow: 0 1px 15px 1px rgba(52,40,104,.08);
}

.card {
    position: relative;
    display: -ms-flexbox;
    display: flex;
    -ms-flex-direction: column;
    flex-direction: column;
    min-width: 0;
    word-wrap: break-word;
    background-color: #fff;
    background-clip: border-box;
    border: 1px solid #e5e9f2;
    border-radius: .2rem;
}
</style>
</head>
<body>
<div class="container h-100">
    		<div class="row h-100">
				<div class="col-sm-10 col-md-8 col-lg-6 mx-auto d-table h-100">
					<div class="d-table-cell align-middle">

						<div class="text-center mt-4">
							<h1 class="h2">Get started</h1>
							<p class="lead">
								Start creating the best possible user experience for you customers.
							</p>
						</div>

						<div class="card">
							<div class="card-body">
								<div class="m-sm-4">
									<form action="RegisterServlet" method = "post">
										<div class="form-group">
											<label>ID</label>
											<input class="form-control form-control-lg" type="text" name="id" placeholder="Enter your id">
										</div>
										<div class="form-group">
											<label>Email</label>
											<input class="form-control form-control-lg" type="text" name="email" placeholder="Enter your email">
										</div>
										<div class="form-group">
											<label>Password</label>
											<input class="form-control form-control-lg" type="text" name="password" placeholder="Enter your password">
										</div>
										<div class="form-group">
											<label>Name</label>
											<input class="form-control form-control-lg" type="text" name="userName" placeholder="Enter name">
										</div>
										<div class="text-center mt-3">
											<button type ="submit" class="btn btn-lg btn-primary"  value="Call Servlet">Sign up</button>
											
										</div>
									</form>
								</div>
							</div>
						</div>

					</div>
				</div>
			</div>
		</div>
</body>