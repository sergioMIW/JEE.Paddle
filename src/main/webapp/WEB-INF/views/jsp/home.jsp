<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="utf-8" />
<title>Spring 4 MVC. Home</title>
</head>
<body>
	<H1>Página principal</H1>

	<h3>Vistas</h3>
	  
       
     <a href="<c:url value="/select-theme/1"/>">Ir a la pagina con estilos</a>
     <br></br>
     <a href="<c:url value="/select-theme/0"/>">Ir a la pagina sin estilos</a>
    
   
	
	<h3>Acciones</h3>
	<p><a href="<c:url value='/court-list'/>">Lista de pistas</a></p>
    <p><a href="<c:url value='/create-court'/>">Crear una pista</a></p>
	<p>UPM-MIW --- ${now}</p>
</body>
</html>