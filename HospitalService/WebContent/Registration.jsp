<%@page import="com.Hospital"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<title>Hospital Registration</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="stylesheet" href="Views/bootstrap.min.css">
<link rel="stylesheet" href="Views/style.css">
<script src="Components/jquery-3.2.1.min.js"></script>
<script src="Components/Hospitals.js"></script>


</head>
<body>



	<div class="main">
		<div class="container">
			<div class="signup-content">
				<div class="signup-img">
					<img src="signup-img2.jpg" alt="">
				</div>
				<div class="signup-form">
					<form class="register-form" id="formHospital" name="formHospital">
						<h2>Hospital registration</h2>


						<input type="text" class="hospital" id="HRegID" name="HRegID"
							placeholder="ID">

						<div class="form-group">
							<input type="text" class="hospital" id="HName" name="HName"
								placeholder="Name">
						</div>

						<div class="form-group">
							<input type="text" class="hospital" id="HAddress" name="HAddress"
								placeholder="Address">
						</div>

						<div class="form-group">
							<input type="text" class="hospital" id="HCity" name="HCity"
								placeholder="City">
						</div>

						<div class="form-group">
							<input type="text" class="hospital" id="HDestrict"
								name="HDestrict" placeholder="Destrict">
						</div>


						<div class="form-group">
							<input type="text" class="hospital" id="HProvince"
								name="HProvince" placeholder="Province">
						</div>



						<div class="form-group">
							<input type="email" class="hospital" id="HEmail" name="HEmail"
								placeholder="Email">
						</div>

						<div class="form-group">
							<input type="text" class="hospital" id="HContactNum"
								name="HContactNum" placeholder="Number">
						</div>


						<div class="form-group">
							<input type="text" class="hospital" id="HUsername"
								name="HUsername" placeholder="Username">
						</div>

						<div class="form-group">
							<input type="password" class="hospital" id="HPassword"
								name="HPassword" placeholder="Password">
						</div>

						<br> <input id="btnSave" name="btnSave" type="button"
							value="Save" class="btn btn-outline-info"> <input
							type="hidden" id="hidItemIDSave" name="hidItemIDSave" value="">


					</form>
				</div>
			</div>
		</div>
	</div>



	<br>
	<br>
	<div class="gridForm">
		<div id="alertSuccess" class="alert alert-success"></div>
		<div id="alertError" class="alert alert-danger"></div>

		<br>
		<div id="divItemsGrid">
			<%
				Hospital hospitalObj = new Hospital();
			out.print(hospitalObj.readHospitals());
			%>
		</div>

	</div>




</body>
</html>