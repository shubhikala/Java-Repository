<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">

<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<meta charset="utf-8">
<title>Bill Reimbursement Login</title>
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">

<link href="css/bootstrap.min.css" rel="stylesheet">

<style type="text/css">
.modal-content {
	margin-top: 100px;
}

.modal-footer {
	border-top: 0px;
}
</style>
</head>

<body>
	<!--login modal-->
	<div id="loginModal">
		<div class="modal-dialog">
			<div class="modal-content">

				<!-- Header Section -->
				<div class="modal-header">
					<h2>Login here..</h2>
				</div>

				<!-- Body Section -->
				<div class="modal-body">
					<form class="form col-md-12" action="LoginServlet">

						<input type="text" class="form-control input-md"
							placeholder="Email" name="email" required autofocus /> 
					    <input type="password" class="form-control input-md"
							placeholder="Password" name="password" required /> 
						<label class="checkbox"> <input type="checkbox"
							value="remember-me" /> Remember me
						</label> <input type="submit" value="Sign In"
							class="btn btn-primary btn-md " /><br> 
						<label style="color: red"> ${invalid}</label>
					</form>
				</div>

				<!-- Footer Section -->
				<div class="modal-footer">
					<div class="col-md-12">
						<span class="pull-left"><a href="#">Forgot Password?</a></span>
					</div>
				</div>
			</div>
		</div>
	</div>

	<script src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
</body>
</html>