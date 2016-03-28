<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml"
	class=" js no-touch generatedcontent csstransforms csstransforms3d csstransitions">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Club de padel</title>


		<meta name="author" content="Sergio Gil Jimenez">
		<meta name="keywords"
			content="Tennis, club, events, football, golf, non-profit, betting assistant, football,fitness, tennis, sport, soccer, goal, sports, volleyball, basketball,	charity, club, cricket, football, hockey, magazine, non profit, rugby, soccer, sport, sports, tennis">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">

		<link href="<c:url value='/static/css/bootstrap.css'/>" rel="stylesheet" type="text/css">
		<!--<link href="css/bootstrap.min.css" rel="stylesheet" type="text/css" />-->


		<link href="<c:url value='/static/css/font-awesome.min.css'/>" rel="stylesheet" type="text/css">
		<!--Clients-->
		<link href="<c:url value='/static/css/owl.carousel.css'/>" rel="stylesheet" type="text/css">
		<link href="<c:url value='/static/css/owl.theme.css'/>" rel="stylesheet" type="text/css">


		<link href="<c:url value='/static/css/jquery.bxslider.css'/>" rel="stylesheet" type="text/css">
		<link href="<c:url value='/static/css/jquery.jscrollpane.css'/>" rel="stylesheet" type="text/css">

		<link href="<c:url value='/static/css/flexslider.css'/>" rel="stylesheet" type="text/css">
		<link href="<c:url value='/static/css/component.css'/>" rel="stylesheet" type="text/css">
		<link href="<c:url value='/static/css/prettyPhoto.css'/>" rel="stylesheet" type="text/css">
		<link href="<c:url value='/static/css/style_dir.css'/>" rel="stylesheet" type="text/css">
		<link rel="shortcut icon" type="<c:url value='/static/image/png'/>" href="img/favicon.ico">
		<link href="<c:url value='/static/css/responsive.css'/>" rel="stylesheet" type="text/css">
		<link href="<c:url value='/static/css/animate.css'/>" rel="stylesheet" type="text/css">

		<link href="<c:url value='/static/css/main.css'/>" rel="stylesheet" type="text/css">

				
		<style type="text/css">
				select {
				    border: 1px solid #ddd;
				    background-color: #f9f9f9;
				    height: 40px;
				    padding: 0 10px;
				    width: 80%;
				    font-size: 12px;
				    margin-bottom: 20px;
				    color: #333;
				    -webkit-border-radius: 1px;
				    -moz-border-radius: 1px;
				    border-radius: 1px;
				    -webkit-box-shadow: inset 0 1px 1px rgba(0, 0, 0, .075);
				    -moz-box-shadow: inset 0 1px 1px rgba(0, 0, 0, .075);
				    box-shadow: inset 0 1px 1px rgba(0, 0, 0, .075);
				}
        </style>
		
			
	</head>
	
	<body>
		<!--SECTION TOP LOGIN-->
		<section class="content-top-login">
			<div class="container">
				<div class="col-md-12">

					<div class="box-login">
						
					</div>
				</div>
			</div>
		</section>
		<!--SECTION MENU -->
		<section class="container box-logo">
			<header>
				<div class="content-logo col-md-12">
					<div class="bt-menu">
						<a href="index.html#" class="menu"><span></span> Menu</a>
					</div>

					<div class="box-menu">

						<nav id="cbp-hrmenu" class="cbp-hrmenu">
							<ul id="menu">
								<li><a class="lnk-menu" href="<c:url value="/home"/>">Home</a></li>
                                <li><a class="lnk-menu active" href="#">Crear pista</a></li>
                                <li><a class="lnk-menu" href="<c:url value='/court-list'/>">Listar pistas</a></li>
                                <li><a class="lnk-menu" href="<c:url value="/select-theme/0"/>">Sin estilos</a></li>
							</ul>
						</nav>
					</div>
				</div>
			</header>
		</section>


		<section class="drawer ng-scope">
		<div class="col-md-12 size-img back-img">
			<div class="effect-cover">
			<h3 class="txt-advert animated fadeInUp">Reservas</h3>
			<p class="txt-advert-sub animated">Gesti�n de reservas Indoor Padel.</p>
			</div>
		</div>
		<section id="summary" class="container secondary-page">
		  <div class="general general-results tournaments">
			   
			   <div id="c-calend" class="top-score-title right-score col-md-12">
					<h3> <span>Crear pista</span><span class="point-little">.</span></h3>
					
					<div class="col-md-12 login-page">
						<div id="contact_form">
							<form:form action="create-court" modelAttribute="court" class="register-form ">
									<div class="id">
										<label for="id">Id de la pista:</label>
										<form:input path="courtId" placeholder="Id"/>
		                                <form:errors path="courtId" cssClass="error" />
									</div>
									<div class="clear"></div>
									<div class="id">
										<label for="id">Disponibilidad:</label>
										<form:select path="active" items="${selectActiveOptions}" />
									</div>
									<button type="submit" class="btn btn-default">Enviar</button>
							</form:form>
						</div>
					</div>
					
					
					   

			   </div><!--Close Top Match-->
			  
			</div></section>
		 


		</section>

		 
		<!--SECTION FOOTER-->
		<section id="footer-tag">
			<div class="container">
				<div class="col-md-12">
					<div class="col-md-5">
						<h3>Acerca de Nosotros</h3>
						<p>Indoor Pádel pone a tu disposición 2100 m² de las mejores instalaciones, 6 pistas de pádel de cristal, 
						zona vending climatizada, wifi y una gran terraza con vistas a las pistas, donde podrás disfrutar de los mejores partidos de pádel.</p>
						<p>
						El principal objetivo es crear un club para todos y para ello nuestra principal apuesta será la creación de una gran escuela de pádel,
						donde todo el mundo pueda tener la oportunidad, tanto de aprender como de jugar, como de perfeccionar su juego, y poder disfrutar al máximo 
						del mejor deporte del mundo. TE ESPERAMOS</p>
					</div>
					<div class="col-md-5 cat-footer">
						<div class="footer-map"></div>
						<h3 class="last-cat">Teléfono: 91 XXX XX XX XX</h3>
						<ul class="last-tips">
							<li><a href="#">contacto@indoorpadel.com</a></li>
							<li><a href="#">L-V: 10:00 - 14:30 y 17:00 - 23:00</a></li>
							<li><a href="#">S-D: 10h - 14:30 y 17:00 - 22:00</a></li>
							
						</ul>
					</div>
					
					
					<div class="col-xs-12">
						<ul class="social">
							<li><a href=""><i class="fa fa-facebook"></i></a></li>
							<li><a href=""><i class="fa fa-twitter"></i></a></li>
							<li><a href=""><i class="fa fa-linkedin"></i></a></li>
							<li><a href=""><i class="fa fa-digg"></i></a></li>
							<li><a href=""><i class="fa fa-rss"></i></a></li>
							<li><a href=""><i class="fa fa-youtube"></i></a></li>
							<li><a href=""><i class="fa fa-tumblr"></i></a></li>

						</ul>
					</div>
				</div>
			</div>
		</section>
		<footer>
			<div class="col-md-12 content-footer">
				<p>�Todos los derechos reservados</p>
			</div>
		</footer>
		</section>





		


		<a href="index.html#" id="toTop" style="display: none;"><span
			id="toTopHover"></span>To Top</a>
	</body>
</html>