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

</head>
<body>

	<div id="wrapper">
		<div id="header">
			<h2>ProLife Andreea Vet</h2>
		</div>
	</div>

	<div id="container">
		<h3>View Animal Detail</h3>
		
		
		<p>Id : ${animalDetail.id}   </p>
		 
		<br></br>
		
		<p>Anamneza : ${animalDetail.anamneza} </p>
		
		<br></br>
		
		<p>Tratament: ${animalDetail.tratament} </p>
		
		<br></br>
		
		<p>Observatii: ${animalDetail.observatii} </p>
		
		<div style="clear; both;"></div>
		
		<p>
			<a href="${pageContext.request.contextPath}/proprietar/animals">Back to Animals</a>
		</p>
	
	</div>
</body>
</html>