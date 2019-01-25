<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>


<meta charset="ISO-8859-1">

<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/style.css">

	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/add-customer-style.css">

<title>Animal Detail</title>
<style>
.col {

	float:left;
	width:75%;
	margin-top:6px;
}

</style>
</head>
<body>

	<div id="wrapper">
		<div id="header">
			<h2>ProLife Andreea Vet</h2>
		</div>
	</div>

	<div id="container">
		<h3>View Animal Details</h3>
		
		<c:forEach var="animalDetail" items="${animalDetails}">
			<p> Anamneza: ${animalDetail.anamneza} </p>
			<br>
			<p> Tratament: ${animalDetail.tratament} </p>
			<br>
			<p> Observatii: ${animalDetail.observatii} </p>
			<hr>
		</c:forEach>
		
		<p> Id : ${animal.id}   </p>		 		
		
		<p>
			<a href="${pageContext.request.contextPath}/animal/animals">Back to Animals</a>
		</p>
	
	</div>
</body>
</html>