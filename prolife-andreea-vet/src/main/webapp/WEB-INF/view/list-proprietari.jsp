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
			<h2 align="center">PAV - Prolife Andreea Vet</h2>
		</div>
	</div>
	
	<br>
	
	<form:form action="search" method="POST">	
		
		
	  Search proprietar: <input type="text" name="searchName" />
	
	<input type="submit" value="Search" class="add-button" />
	
	<input type="button"  value="Add Proprietar"
					   onclick="window.location.href='showFormForAdd'; return false;"
					   class="add-button" /> 
	
	<input type="button" value="Animals List"
						onclick="window.location.href='${pageContext.request.contextPath}/animal/animals'; return false;"
						class="add-button" />
	
	
	</form:form>
					   
	
	
	<table>
				<tr>
					<th>Id</th>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Telefon</th>
					<th>Action</th>
					<th>Animal</th>
					
					
				</tr>
				
				<c:forEach var="proprietar" items="${proprietari}" >
					
					<!-- construct an "update" link with customer id -->
					<c:url var="updateLink" value="/proprietar/showFormForUpdate">
						<c:param name="proprietarId" value="${proprietar.id}" />
					</c:url>					

					<!-- construct an "delete" link with customer id -->
					<c:url var="deleteLink" value="/proprietar/delete">
						<c:param name="proprietarId" value="${proprietar.id}" />
					</c:url>	
					
					<c:url var="saveAnimal" value="/animal/showFormForAddAnimal">
						<c:param name="proprietarId" value="${proprietar.id}" />
					</c:url>
					
					<tr>
						<td> ${proprietar.id} </td>
						<td> ${proprietar.firstName} </td>
						<td> ${proprietar.lastName} </td>
						<td> ${proprietar.telefon} </td>
						<td> 
						
						<a href="${updateLink}">Update</a> 
						<a href="${deleteLink}"
									   onclick="if (!(confirm('Are you sure you want to delete this proprietar?'))) return false">Delete</a>
						</td>
						
						<td>
						<a href="${saveAnimal}">Add Animal</a>
						</td>
						
					</tr>
				
				</c:forEach>
	</table>
	
	<img height="350" width="1060" src="https://ybxzcgnc7b-flywheel.netdna-ssl.com/wp-content/uploads/2017/11/cute.jpg" />
	
	
</body>

</html>