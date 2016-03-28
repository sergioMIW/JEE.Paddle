$( document ).ready(function() {
			
			//VARIABLES
			var messageBox = $('.message-box');
			var alertBox = $('.alert');
			var mensajeErrorGenerico = "Error en el login. Revise los cambios (%errorGeneral%)";
			var mensajeError = "Error no se ha podido logear. Revise los cambios (%error%)";
			var mensajeSuccess = "Se ha logeado correctamente. El token asignado es: (%token%)";

			var url = "http://salonso.etsisi.upm.es/miw_serv/padel/conexion.php"; // the script where you handle the form input.
		    var submitForm = $(".login-form");

			
			var ocultar = function(div){
				setTimeout(function(){div.addClass("oculto");}, 10000);
			}
			
			var resetForm = function(){
				$(".login-form input").focus();
				$(".login-form input[type=text],[type=password]").val('');
			}

			
			var loginAutentification = function (data){
				console.log("SUCESS! Mensaje: " + data.token);
				
				$(".loginButtonIni").text("Cerrar session");
				alertBox.text("").append(mensajeSuccess.replace("%token%",data.token));
				alertBox.removeClass('alert-danger').addClass('alert-success');
				messageBox.removeClass("oculto");
				ocultar(messageBox);

			};
			
			

			var errorAutentification = function (data){
				console.log("ERROR! Mensaje:" + data.errorMessage);
				resetForm();
				alertBox.text("").append(mensajeError.replace("%error%",data.errorMessage));
				alertBox.removeClass('alert-success').addClass('alert-danger');
				messageBox.removeClass("oculto");
				ocultar(messageBox);

			};
			
			var errorGenerico = function(data){
                console.log("ERROR! Mensaje: Revise los inputs");
                resetForm();
				alertBox.text("").append(mensajeErrorGenerico.replace("%errorGeneral%",data));
				alertBox.removeClass('alert-success').removeClass('alert-danger').addClass('alert-warning');
				messageBox.removeClass("oculto");
				ocultar(messageBox);
			
			}
			
			
			$(".loginOutButton").click(function(e){
				$(".loginButtonIni").text("login");
				e.preventDefault(); 
			});
			
		
			$(".login-form").submit(function(e) {
                
                var id = $(".login-form #name_user").val().trim();
                var correo = $(".login-form #name_login").val().trim(); 
                var passwd = $(".login-form #password_login").val().trim(); 
                
				if(id === "" || correo === ""){
					errorGenerico("error||correo");
					return;
				}
				//var data_value = "id=tdcl&correo=tdcl@etsisi.upm.es&password=*tdcl*";
				var data_form_value = "id=" + id + "&correo=" + correo +"&password=" + passwd;

				$.ajax({
					   type: "GET",
					   url: url,
					   data: data_form_value, 
					   success: function(data)
					   {
						  var returnedData = JSON.parse(data);
						  if(returnedData.errorMessage === "none")
							loginAutentification(returnedData);
						  else
							errorAutentification(returnedData);
							
						   
					   },
					   error : function(data)
					   {
						  
					   }
					   
					 });

				e.preventDefault(); 
			});
                
            });