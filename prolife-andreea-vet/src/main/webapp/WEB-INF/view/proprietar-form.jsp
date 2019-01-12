<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

<html>

<head>
<meta charset="ISO-8859-1">
<title>Save Proprietar</title>

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
		<h3>Save Proprietar</h3>
		
		<c:url var="saveAnimal" value="/proprietar/saveAnimal">
				<c:param name="proprietarId" value="${proprietar.id}" />
		</c:url>
	
		<form:form action="saveProprietar" modelAttribute="proprietar" method="POST">
			
			
			
			<!-- need to associate this data with proprietar id -->
			<form:hidden path="id" />
					
			<table>
				<tbody>
					<tr>
						<td><label>First name:</label></td>
						<td><form:input path="firstName" /></td>
					</tr>
				
					<tr>
						<td><label>Last name:</label></td>
						<td><form:input path="lastName" /></td>
					</tr>

					<tr>
						<td><label>Telefon:</label></td>
						<td><form:input path="telefon" /></td>
					</tr>
					

					<tr>
						<td><label></label></td>
						<td>
						
						<input type="submit" value="Save" class="save" />
						
												
					</tr>
										
			
				</tbody>
				
			</table>
		
		
		</form:form>
	
		<div style="clear; both;"></div>
		
		<p>
			<a href="${pageContext.request.contextPath}/proprietar/list">Back to List</a>		
		</p>

	
		</div>
	
	
</body>
</html>