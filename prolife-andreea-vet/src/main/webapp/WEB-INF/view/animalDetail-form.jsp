<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>   
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add New Visit</title>

	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/style.css">

	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/add-customer-style.css">
</head>
<body>
	<div id="wrapper">
		<div id="header">
			<h2>PAV - Prolife Andreea Vet</h2>
		</div>
	</div>
	
	<div id="container">
		<form:form action="saveAnimalDetail" modelAttribute="animalDetail" method="POST">
			<form:hidden path="animal.id" />
			<input type="hidden" name="animalId" value="${animal.id}" />
			
			<table>
				<tr>
					<td> Anamneza: </td>
					<td><form:textarea path="anamneza" rows="5" cols="30" /> </td>
				</tr>
				<tr>
					<td> Tratament: </td>
					<td><form:textarea path="tratament" rows="5" cols="30" /> </td>
				</tr>
				<tr>
					<td> Observatii: </td>
					<td><form:textarea path="observatii" rows="5" cols="30" /> </td>
				</tr>
				<tr>
					<td><label></label></td>
					<td><input type="submit" value="Save" class="save" /></td>						
				</tr>
			</table>
		</form:form>
	</div>
</body>
</html>