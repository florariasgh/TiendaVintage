<%-- 
    Document   : modificarFormaDePago
    Created on : 15/10/2021, 14:34:11
    Author     : arias
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Modificar forma de pago</title>
        <link href="./resources/bootstrap.min.css" rel="stylesheet">
        <!-- Custom styles for this template -->
        <link href="./resources/css" rel="stylesheet">
        <!-- Custom styles for this template -->
        <link href="./resources/blog.css" rel="stylesheet">
    </head>
    <body>
        <h1>Modificar Forma de pago</h1>

		<form method="POST" action="ModificarFormaDePagoServlet"> 
			
			<input type="hidden" name="txtId" value="${id}" />
			<div class="form-group">
				<label for="txtNombre">Nombre</label>
                                <input type="text" name="txtNombre" id="txtNombre" value="${nombre}"/>
                                
			</div> 
			 

			<input type="submit" value="Modificar" class="btn btn-primary" />
		</form>
                <a href="/TiendaVintage/listadoFormaDePago.jsp"><button type="button" class="btn btn-primary">Volver atras</button></a>
    </body>
</html>

