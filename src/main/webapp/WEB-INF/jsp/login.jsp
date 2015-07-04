
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<div class="container-fluid">
	<div class="row-fluid">
		<div class="span12">
			<fieldset>
				<legend>Bootstrap Form With Spring Mvc Example</legend>
				<!-- <form class="form-horizontal" method="post" action='/login'  name="employeeForm" id="employeeForm">  -->
				<form:form method="post" class="form-horizontal" action='/login'
					modelAttribute="user" name="loginForm" id="loginForm">
					<div class="control-group">
						<label class="control-label">User Name</label>
						<div class="controls">
							<input type="text" name="name" id="name"
								title="User Name" value="">
						</div>
					</div>
					<div class="control-group">
						<label class="control-label">Password</label>
						<div class="controls">
							<input type="password" name="password" id="password"
								title="password" value="">
						</div>
					</div>
					<div class="form-actions">
						<button type="submit" class="btn btn-success">Submit</button>
						<button type="button" class="btn">Cancel</button>
					</div>
					<!-- </form>  -->
				</form:form>
			</fieldset>
		</div>
	</div>
</div>
