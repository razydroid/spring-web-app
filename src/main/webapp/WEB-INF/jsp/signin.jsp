<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<title>Student Enrollment Form</title>
<link href="<c:url value='/resources/css/bootstrap.css' />"
	rel="stylesheet"></link>
<link href="<c:url value='/resources/css/custom.css' />"
	rel="stylesheet"></link>


<div class="form-container">

	<h1>Sign In Form</h1>
	<form:form method="post" class="form-horizontal" action='/signin'
		modelAttribute="user" name="loginForm" id="loginForm">

		<div class="has-error">
			<c:if test="${not empty errorMessage}">
 			 ${errorMessage}
		</c:if>
		</div>

		<div class="row">
			<div class="form-group col-md-12">
				<label class="col-md-3 control-lable" for="name">User Name</label>
				<div class="col-md-7">
					<form:input type="text" path="name" id="name"
						class="form-control input-sm" />
					<div class="has-error">
						<form:errors path="name" class="help-inline" />
					</div>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="form-group col-md-12">
				<label class="col-md-3 control-lable" for="password">Password</label>
				<div class="col-md-7">
					<form:input type="password" path="password" id="password"
						class="form-control input-sm" />
					<div class="has-error">
						<form:errors path="password" class="help-inline" />
					</div>
				</div>
			</div>
		</div>
		<div class="form-actions">
			<button type="submit" class="btn btn-success">Submit</button>
			<button type="button" class="btn">Cancel</button>
		</div>
	</form:form>
</div>
</body>
</html>