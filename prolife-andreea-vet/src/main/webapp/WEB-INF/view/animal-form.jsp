<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>   
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<title>Save Animal</title>

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
		<h3>Save Animal</h3>
				
				
		
		<form:form action="saveAnimal" modelAttribute="animal"  method="POST">
		
			
			
			<!-- need to associate this data with proprietar id -->
			<form:hidden path="id" />
			
			<table>
				<tbody>
					<tr>
						<td><label>Nume:</label></td>
						<td><form:input path="nume" /></td>
					</tr>
				
					<tr>
						<td><label>Specie:</label></td>
						<td><form:input path="specie" /></td>
					</tr>

					<tr>
						<td><label>Rasa:</label></td>
						<td><form:input path="rasa" /></td>
					</tr>
					
					<tr>
						<td><label>Greutate:</label></td>
						<td><form:input path="greutate" /></td>
					</tr>
					
					<tr>
						<td>${proprietar.id}</td>
					</tr>
					
					

					<tr>
						<td><label></label></td>
						<td><input type="submit" value="Save" class="save" /></td>
						
					</tr>
			
				</tbody>
			</table>
		
		
		</form:form>
	</div>
</body>
</html>