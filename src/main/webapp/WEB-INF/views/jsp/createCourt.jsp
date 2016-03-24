<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="utf-8">
<title>Spring MVC. CreatePista</title>
<style>.error {	color: red;}</style>
</head>
<body>
	<h1>Crear una pista</h1>
	<form:form action="create-court" modelAttribute="court">
		<p>Id:
			<form:input path="id" placeholder="Id" required="required" />
			<form:errors path="id" cssClass="error" />
		</p>
	
		<p>Activo:
			<form:select path="active" items="${activeCourtMap}" />
		</p>
		
		<p>
		  <input type="submit" value="Crear">
		</p>
	</form:form>

	<a href="<c:url value="/home"/>">Home</a>

	<p>UPM-MIW --- ${now}</p>

</body>
</html>