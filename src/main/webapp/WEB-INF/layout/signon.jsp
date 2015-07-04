<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
		<tiles:insertAttribute name="header"></tiles:insertAttribute>
	<body>

		<tiles:insertAttribute name="body"></tiles:insertAttribute>
	</body>
</html>