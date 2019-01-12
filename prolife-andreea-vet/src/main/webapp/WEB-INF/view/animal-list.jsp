<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Prolife Andreea Vet</title>

<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/style.css" />

</head>

<body>

	<div id="wrapper">
		<div id="header">
			<h2>PAV - Prolife Andreea Vet</h2>
		</div>
	</div>
	
	
	<table>
				<tr>
					<th>Id</th>
					<th>Nume</th>
					<th>Specie</th>
					<th>Rasa</th>
					<th>Greutate</th>
					<th>Proprietar Id</th>
					<th>Animal Detail</th>
					<th>Actions</th>
					
					
					
				</tr>
				
				<c:forEach var="animal" items="${animals}" >
					
					<c:url var="viewDetails" value="/proprietar/animaldetails">
						<c:param name="animalId" value="${animal.id}" />
					</c:url>
					
					<c:url var="deleteLink" value="/proprietar/deleteAnimal">
						<c:param name="animalId" value="${animal.id}" />
					</c:url>
					
					<tr>
						<td> ${animal.id} </td>
						<td> ${animal.nume} </td>
						<td> ${animal.specie} </td>
						<td> ${animal.rasa} </td>
						<td> ${animal.greutate} </td>
						<td> ${animal.proprietar.id} </td>
						<td> <a href="${viewDetails}">Animal Detail</a> </td>
						<td> 
							<a href="${deleteLink}"
									   onclick="if (!(confirm('Are you sure you want to delete this animal?'))) return false">Delete</a>
						</td>
						
					</tr>
				
				</c:forEach>
	</table>
	
	<br></br>
	
	<a href="${pageContext.request.contextPath}/proprietar/list" >List Proprietari</a>
</body>
</html>