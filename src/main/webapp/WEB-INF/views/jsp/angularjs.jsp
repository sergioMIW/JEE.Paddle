<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="utf-8">
<title>Spring MVC</title>
<style>.error {	color: red;}</style>
</head>
<body>
	<h1>HOLI</h1>
	

	<a href="<c:url value="/home"/>">Home</a>

	<p>UPM-MIW --- ${now}</p>

</body>
</html>