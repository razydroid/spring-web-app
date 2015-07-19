<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="util"%>


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Customers</title>
</head>
<body>


	<table class="table table-bordered table-striped table-responsive">
		<thead>
			<tr>
				<th>
					Customer ID
				</th>
				<th>
					Customer First Name
				</th>
				<th>
					Customer Last Name
				</th>
				<th>
					Customer Email
				</th>
				
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${customers.content}" var="customer">
				<tr>
					<td>
						${customer.customerId}
					</td>
					<td>
						${customer.firstName}
					</td>
					<td>
						${customer.firstName}
					</td>
					<td>
						${customer.email}
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
	<div class="row-fluid">
			<util:pagination thispage="${customers}"></util:pagination>
		</div>

</body>
</html>