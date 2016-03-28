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

				
		<style id="holderjs-style" type="text/css"></style>
		
			
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
						<a href="index.html#" class="menu"><span>≡</span> Menu</a>
					</div>

					<div class="box-menu">

						<nav id="cbp-hrmenu" class="cbp-hrmenu">
							<ul id="menu">
								<li><a class="lnk-menu" href="<c:url value="/home"/>">Home</a></li>
                                <li><a class="lnk-menu active" href="#">Listar pistas</a></li>
                                 <li><a class="lnk-menu" href="<c:url value='/create-court'/>">Crear pista</a></li>
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
		  
			   <h3> <span>Pistas disponibles</span><span class="point-little">.</span></h3>
			   
					
					<div class="horas_disponibles">
                      
                       <div class="acc-content">
                                
                            <div class="col-md-4 acc-title">Id</div>
                            <div class="col-md-4 acc-title">Disponibilidad</div>
                        
                            
                            <c:forEach items="${courtList}" var="court">
                               <div class="filasReserva">
                                    <div class="col-md-5 t1"><p class="ng-binding">${court.courtId}</p></div>
                                    <div class="col-md-5 t2"><p class="ng-binding">${court.active}</p> </div>
                                    <div class="col-md-2 t4">
                                        <a href="<c:url value='/delete-court/${court.courtId}' />">Eliminar</a>
                                     </div>
                                </div>
                            </c:forEach>
                    
                        </div>
                    </div>
                    
                    
                    <a class="lnk-menu" href="<c:url value='/create-court'/>">Crear pista</a>
                    <div style="margin-bottom:50px" class="clear"/>
					   

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
				<p>©Todos los derechos reservados</p>
			</div>
		</footer>
		</section>





		<script src="<c:url value='/static/js/jquery-1.10.2.js'/>" type="text/javascript"></script>
		<script src="<c:url value='/static/js/jquery-migrate-1.2.1.min.js'/>" type="text/javascript"></script>
		<script src="<c:url value='/static/js/jquery.transit.min.js'/>" type="text/javascript"></script>

		<!--MENU-->
		<script src="<c:url value='/static/js/modernizr.custom.js'/>" type="text/javascript"></script>
		<script src="<c:url value='/static/js/cbpHorizontalMenu.js'/>" type="text/javascript"></script>
		<!--END MENU-->

		<!--Mini Flexslide-->
		<script src="<c:url value='/static/js/jquery.flexslider.js'/>" type="text/javascript"></script>



		<!--Gallery-->
		<script src="<c:url value='/static/js/jquery.prettyPhoto.js'/>" type="text/javascript"></script>
		<script src="<c:url value='/static/js/isotope.js'/>" type="text/javascript"></script>

		<!-- Button Anchor Top-->
		<script src="<c:url value='/static/js/jquery.ui.totop.js'/>" type="text/javascript"></script>
		<script src="<c:url value='/static/js/custom.js'/>" type="text/javascript"></script>
		<script src="<c:url value='/static/js/jquery.bxslider.js'/>" type="text/javascript"></script>


		<!--Carousel Clients-->
		<script src="<c:url value='/static/js/owl.carousel.js'/>" type="text/javascript"></script>

		<!--Count down-->
		<script src="<c:url value='/static/js/jquery.countdown.js'/>" type="text/javascript"></script>

		<script src="<c:url value='/static/js/custom_ini.js'/>" type="text/javascript"></script>


		<script src="<c:url value='/static/js/main.js'/>" type="text/javascript"></script>



		<a href="index.html#" id="toTop" style="display: none;"><span
			id="toTopHover"></span>To Top</a>
	</body>
</html>