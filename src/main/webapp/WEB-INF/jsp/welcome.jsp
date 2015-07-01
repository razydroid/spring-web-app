<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Bootstrap Form With Spring Mvc Example</title>
</head>
<body>
	<div class="container-fluid">
		<div class="row-fluid">
			<div class="span12">
				<fieldset>
				<legend>User Details</legend>
				    <table class="table table-striped">
					    <tr>
					    	<td>Name</td>
					    	<td>Email</td>
					    	<td>Phone</td>
					    </tr>
					    <tr>
				    	<td>${user.name}</td>
				    	<td>${user.email}</td>
				    	<td>${user.phone}</td>
				    </tr>    		
    				</table>
				</fieldset>
			</div>
		</div>
	</div>		
</body>
</html>